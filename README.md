# Clone a LinkedList with Random Pointers for each Node
This is a simple Java program to clone a linked list which has both a next
pointer and a random pointer. 

## Input

Input to this program is a linked list which is as shown below. This is 
hard-coded in the `App.java` class.

```shell script
Current: 1
Next: 2
Random: 3
-----------------------------
Current: 2
Next: 3
Random: 4
-----------------------------
Current: 3
Next: 4
Random: 1
-----------------------------
Current: 4
Random: 2
-----------------------------
```

As can be seen, there are random pointers from node 1 to node 3, node 2 to node 4,
node 3 to node 1, and node 4 to node 2. The head of the linked list is node 1. 
And the last node is node 4. 

The aim of this program is to clone this linked list while maintaining the same
random pointers. For example, even in the cloned linked list, the random pointer
from node 1 should be pointing to the node 3 in the same cloned linked list.

## Output

```shell script
Traversing cloned list
-----------------------------
-----------------------------
Current: 1
Next: 2
Random: 3
-----------------------------
Current: 2
Next: 3
Random: 4
-----------------------------
Current: 3
Next: 4
Random: 1
-----------------------------
Current: 4
Random: 2
-----------------------------
``` 