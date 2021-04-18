package _7_symboltable.ordered;

import java.util.ArrayList;

//Left Leaning Red Black BST
public class RedBlackBST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    private enum Colour {
        BLACK, RED
    }

    private class TreeNode implements Comparable<TreeNode> {
        Key key;
        Value value;
        TreeNode left;
        TreeNode right;
        Colour colour;
        int count;

        public TreeNode(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            colour = Colour.RED;
        }

        @Override
        public int compareTo(TreeNode that) {
            return this.key.compareTo(that.key);
        }
    }

    private TreeNode root;

    public RedBlackBST() {
        root = null;
    }

    public boolean isRed(TreeNode treeNode) {
        return treeNode != null && (treeNode.colour == Colour.RED);
    }

    private void updateCount(TreeNode treeNode) {
        treeNode.count = 1 + size(treeNode.left) + size(treeNode.right);
    }

    // if there is a right-leaning red link then we rotate it to left-leaning
    private TreeNode rotateLeft(TreeNode first) {
        assert isRed(first.right);
        TreeNode second = first.right;
        first.right = second.left;
        second.left = first;
        second.colour = first.colour;
        first.colour = Colour.RED;
        updateCount(first);
        updateCount(second);
        return second;
    }

    // Sometimes, we require to make a left-leaning red link to temporarily transform into a right-leaning link
    private TreeNode rotateRight(TreeNode first) {
        assert isRed(first.left);
        TreeNode second = first.left;
        first.left = second.right;
        second.right = first;
        second.colour = first.colour;
        first.colour = Colour.RED;
        updateCount(first);
        updateCount(second);
        return second;
    }

    private void flipColour(TreeNode treeNode) {
//        assert !isRed(treeNode);
        assert isRed(treeNode.left);
        assert isRed(treeNode.right);
        treeNode.colour = Colour.RED;
        treeNode.left.colour = Colour.BLACK;
        treeNode.right.colour = Colour.BLACK;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(TreeNode root, Key key) {
        if (root == null)
            return null;
        int compareTo = key.compareTo(root.key);
        if (compareTo == 0)
            return root.value;
        else if (compareTo < 0)
            return get(root.left, key);
        else //if (compareTo > 0)
            return get(root.right, key);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private TreeNode put(TreeNode root, Key key, Value value) {
        if (root == null)
            root = new TreeNode(key, value);
        else {
            int compareTo = key.compareTo(root.key);
            if (compareTo == 0)
                root.value = value;
            else if (compareTo < 0)
                root.left = put(root.left, key, value);
            else //if (compareTo > 0)
                root.right = put(root.right, key, value);
            if (!isRed(root.left) && isRed(root.right))
                root = rotateLeft(root);
            if (isRed(root.left) && isRed(root.left.left))
                root = rotateRight(root);
            if (isRed(root.left) && isRed(root.right))
                flipColour(root);
        }
        updateCount(root);
        return root;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode treeNode) {
        return (treeNode != null) ? treeNode.count : 0;
    }

    @Override
    public Key getMinimum() {
        TreeNode treeNode = getMinimum(root);
        return (treeNode != null) ? treeNode.key : null;
    }

    private TreeNode getMinimum(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return getMinimum(root.left);
    }

    @Override
    public Key getMaximum() {
        TreeNode treeNode = getMaximum(root);
        return (treeNode != null) ? treeNode.key : null;
    }

    private TreeNode getMaximum(TreeNode root) {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return getMaximum(root.right);
    }

    @Override
    public Key floor(Key key) {
        TreeNode treeNode = floor(root, key);
        return (treeNode != null) ? treeNode.key : null;
    }

    private TreeNode floor(TreeNode root, Key key) {
        if (root == null)
            return null;
        int compareTo = key.compareTo(root.key);
        if (compareTo == 0)
            return root;
        else if (compareTo < 0)
            return floor(root.left, key);
        else { //if(compareTo > 0)
            TreeNode floor = floor(root.right, key);
            return (floor != null) ? floor : root;
        }
    }

    @Override
    public Key ceil(Key key) {
        TreeNode treeNode = ceil(root, key);
        return (treeNode != null) ? treeNode.key : null;
    }

    private TreeNode ceil(TreeNode root, Key key) {
        if (root == null)
            return null;
        int compareTo = key.compareTo(root.key);
        if (compareTo == 0)
            return root;
        else if (compareTo > 0)
            return ceil(root.right, key);
        else { // if(compareTo > 0)
            TreeNode ceil = ceil(root.left, key);
            return (ceil != null) ? ceil : root;
        }
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(TreeNode root, Key key) {
        if (root == null)
            return 0;
        int compareTo = key.compareTo(root.key);
        if (compareTo == 0)
            return size(root.left);
        else if (compareTo < 0)
            return rank(root.left, key);
        else // if (compareTo > 0)
            return 1 + size(root.left) + rank(root.right, key);
    }

    @Override
    public Iterable<Key> keys() {
        ArrayList<Key> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, ArrayList<Key> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.key);
        inorder(root.right, list);
    }

    @Override
    public Iterable<Key> keys(Key start, Key end) {
        ArrayList<Key> list = new ArrayList<>();
        keys(root, list, start, end);
        return list;
    }

    private void keys(TreeNode root, ArrayList<Key> list, Key start, Key end) {
        if (root == null)
            return;
        int startCompareTo = start.compareTo(root.key);
        int endCompareTo = end.compareTo(root.key);
        if (startCompareTo < 0)
            keys(root.left, list, start, end);
        if (startCompareTo <= 0 && endCompareTo >= 0)
            list.add(root.key);
        if (endCompareTo > 0)
            keys(root.right, list, start, end);
    }

    @Override
    public int countKeys(Key start, Key end) {
        return rank(end) - rank(start) + (containsKey(end) ? 1 : 0);
    }

    @Override
    public boolean containsKey(Key key) {
        return get(root, key) != null;
    }

    public void printSizeLeftAndRightSubtrees() {
        System.out.println("RedBlack BST");
        System.out.println("Tres size           : " + size());
        System.out.println("left sub-tree size  : " + size(root.left));
        System.out.println("right sub-tree size : " + size(root.right));
    }

}
