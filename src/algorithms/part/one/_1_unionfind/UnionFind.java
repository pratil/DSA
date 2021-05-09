package algorithms.part.one._1_unionfind;

// a skeleton for different kinds of union find algorithms
public interface UnionFind {

    //    a method which is used to join two objects or group of object to form a group
    void union(int first, int second);

    //    a method to find out if the two objects are connected(or in same group) or not
    boolean find(int first, int second);

}
