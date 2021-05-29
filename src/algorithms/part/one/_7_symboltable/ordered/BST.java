package algorithms.part.one._7_symboltable.ordered;

import java.util.ArrayList;

/**
 * A type of Ordered Symbol Table which is used to store the data in form of a special tree
 * where every element to the left of the node is smaller than the node,
 * and every element to the right of the node is larger than the node.
 * This type of Tree's are called Binary Search Tree which is abbreviated to BST
 **/
public class BST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    // to store the root of the tree
    private TreeNode root;

    // to initialise an empty tree
    public BST() {
        root = null;
    }

    // set the value in the symbol table for the given key, to update or create a new entry
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // helper recursive function to put the key, value pair in the Symbol Table with the given root
    private TreeNode put(TreeNode root, Key key, Value value) {
        if (root == null)
            root = new TreeNode(key, value);
        else {
            int compareTo = key.compareTo(root.key);
            if (compareTo < 0)
                root.left = put(root.left, key, value);
            else if (compareTo > 0)
                root.right = put(root.right, key, value);
            else
                root.value = value;
        }
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    // get the value from the symbol table for the given key
    @Override
    public Value get(Key key) {
        if (key == null)
            return null;
        return get(root, key);
    }

    // helper recursive function to get the value for the given key in the Symbol Table with the given root
    private Value get(TreeNode root, Key key) {
        if (root == null)
            return null;
        int compareTo = key.compareTo(root.key);
        if (compareTo < 0)
            return get(root.left, key);
        else if (compareTo > 0)
            return get(root.right, key);
        else //if(compareTo == 0)
            return root.value;
    }

    // to delete the key value pair from the symbol table corresponding to the given key
    @Override
    public Value delete(Key key) {
        Value deletedValue = get(root, key);
        if (deletedValue == null)
            return null;
        root = delete(root, key);
        return deletedValue;
    }

    // helper recursive function to delete the key, value pair from the Symbol Table with the given root
    private TreeNode delete(TreeNode root, Key key) {
        if (root == null)
            return null;
        int compareTo = key.compareTo(root.key);
        if (compareTo < 0)
            root.left = delete(root.left, key);
        else if (compareTo > 0)
            root.right = delete(root.right, key);
        else { //if(compareTo == 0)
            if (root.left == null)
                return root.right;  // if both null, it'll return null
            if (root.right == null)
                return root.left;
            TreeNode treeNode = root;
            root = getMinimum(root.right);
            root.right = deleteMinimum(treeNode.right);
            root.left = treeNode.left;
        }
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    // recursive function to delete the key, value pair with the minimum key in the Symbol Table
    // to help the delete operation in case of key with two children needs to be deleted
    private TreeNode deleteMinimum(TreeNode root) {
        if (root.left == null)
            return root.right;
        root.left = deleteMinimum(root.left);
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    // to get the minimum key from the Symbol Table
    @Override
    public Key getMinimum() {
        TreeNode treeNode = getMinimum(root);
        return (treeNode != null) ? treeNode.key : null;
    }

    // to get the minimum key from the Symbol Table with the given root
    private TreeNode getMinimum(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return getMinimum(root.left);
    }

    // to get the minimum key from the Symbol Table
    @Override
    public Key getMaximum() {
        TreeNode treeNode = getMaximum(root);
        return (treeNode != null) ? treeNode.key : null;
    }

    // to get the maximum key from the Symbol Table with the given root
    private TreeNode getMaximum(TreeNode root) {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return getMaximum(root.right);
    }

    // to get the largest key smaller than the given key
    @Override
    public Key floor(Key key) {
        TreeNode treeNode = floor(root, key);
        return (treeNode != null) ? treeNode.key : null;
    }

    // to get the largest key smaller than the given key with the given root
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

    // to get the smallest key larger than the given key
    @Override
    public Key ceil(Key key) {
        TreeNode treeNode = ceil(root, key);
        return (treeNode != null) ? treeNode.key : null;
    }

    // to get the smallest key larger than the given key with the given root
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

    // to give the size of the symbol table
    @Override
    public int size() {
        return size(root);
    }

    // to give the size of the symbol table with the given root
    private int size(TreeNode treeNode) {
        return (treeNode == null) ? 0 : treeNode.count;
    }

    // to give the rank of the given key i.e. number of keys which are smaller than the current key in Symbol Table
    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    // to give the rank of the given key i.e. number of keys which are smaller than the current key in Symbol Table with the given root
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

    // to get the list of the keys in ascending order with the help of inorder traversal in the tree
    @Override
    public Iterable<Key> keys() {
        ArrayList<Key> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    // to do inorder traversal of the tree
    private void inorder(TreeNode root, ArrayList<Key> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.key);
        inorder(root.right, list);
    }

    // to get the list of the keys in ascending order in the given range in the symbol table
    @Override
    public Iterable<Key> keys(Key start, Key end) {
        ArrayList<Key> list = new ArrayList<>();
        keys(root, list, start, end);
        return list;
    }

    // helper recursive function to get the list of the keys in ascending order
    // in the given range, for the tree with the given root
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

    // to count the number of keys in the given range
    @Override
    public int countKeys(Key start, Key end) {
        return rank(end) - rank(start) + ((get(end) != null) ? 1 : 0);
    }

    // to check if there exists a Key, Value pair for the given key
    @Override
    public boolean containsKey(Key key) {
        return get(root, key) != null;
    }

    // Just to print the size of the Tree, It's left sub tree, and it's right subtree
    // just to test how balanced is the tree
    public void printSizeLeftAndRightSubtrees() {
        System.out.println("BST");
        System.out.println("Tres size           : " + size());
        System.out.println("left sub-tree size  : " + size(root.left));
        System.out.println("right sub-tree size : " + size(root.right));
    }

    // Tree Node which defines the node in a tree to store the Symbol Table Key Value Pair
    private class TreeNode implements Comparable<TreeNode> {
        Key key; // key of the symbol table pair
        Value value; // value of the symbol table pair
        TreeNode left; // to store the node on the left of current node
        TreeNode right; // to store the node on the right of current node
        int count; // the count of nodes present in the subtree (including self) i.e. left.count + right.count + 1

        // to initialise the Tree Node
        public TreeNode(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        // to compare the Tree Node based on the Key
        @Override
        public int compareTo(TreeNode that) {
            return this.key.compareTo(that.key);
        }

    }

}
