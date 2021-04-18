# Union Find

> Different Algorithms using which I have implemented Union-Find are:    
> 👉 Quick Find  
> 👉 Quick Union  
> 👉 Weighted Quick Union  
> 👉 Quick Union with Path Compression

The basic layout for all the union find algorithms is similar:

- A function to Initialize (in Java Constructors)
- A function to join two objects together i.e. union function
- A function to find if two objects are joined/connected or not i.e. find function

_The skeleton to implement any union find algorithm_

```
// java class
public class NameOfAlgorithm {

    // to initialize
    public NameOfAlgorithm() { /* code here */ }
    
    // union function
    public void union() { /* code here */ }
    
    // find function
    public boolean find() { /* code here */ }
    
}
```
