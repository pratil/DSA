# Unordered Symbol Table

This is a form of symbol table where the way we store the data is independent of the Keys. Here just use the basic
operation of put and get in a Symbol Table.

Some concepts:

- Hashing: to get an integer value corresponding to the Key
- Collision: Two or more Keys give the same integer value

I have implemented Unordered Symbol Table using two different Collision Resolution Techniques

- [Linear Probing](LinearProbing.java)
- [Separate Chaining](SeparateChaining.java)