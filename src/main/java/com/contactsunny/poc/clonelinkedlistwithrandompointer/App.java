package com.contactsunny.poc.clonelinkedlistwithrandompointer;

public class App {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>();
        node1.setData(1);

        Node<Integer> node2 = new Node<Integer>();
        node2.setData(2);

        Node<Integer> node3 = new Node<Integer>();
        node3.setData(3);

        Node<Integer> node4 = new Node<Integer>();
        node4.setData(4);

        node1.setNext(node2);
        node1.setRandom(node3);

        node2.setNext(node3);
        node2.setRandom(node4);

        node3.setNext(node4);
        node3.setRandom(node1);

        node4.setNext(null);
        node4.setRandom(node2);

        traverseLinkedList(node1);

        cloneLinkedList(node1);
    }

    private static void traverseLinkedList(Node<Integer> node) {

        while (node != null) {
            System.out.println("Current: " + node.getData());
            if (node.getNext() != null) {
                System.out.println("Next: " + node.getNext().getData());
            }
            if (node.getRandom() != null) {
                System.out.println("Random: " + node.getRandom().getData());
            }
            System.out.println("-----------------------------");
            node = node.getNext();
        }
    }

    private static void cloneLinkedList(Node<Integer> node) {

        Node<Integer> currentNode = node;
        // Creating a pointer to the head node of the clone linked list.
        Node<Integer> cloneNodeHead = null;

        /**
         * Traversing over the linked list to clone a node for each node in the original linked list.
         * During this cloning, I'm also setting the data for the cloned node.
         *
         * Also, I'm inserting the cloned node between the original node and it's next node.
         * This is done to achieve O(1) for space complexity.
         */
        while(currentNode != null) {
            // Creating a node to clone.
            Node<Integer> cloneNode = new Node<Integer>();
            // To keep track of the head of the cloned list, I'm checking this condition
            // in every iteration and assigning the current cloned node as the head if the head pointer is null.
            // The body of this if() block will be executed only the first time.
            if (cloneNodeHead == null) {
                cloneNodeHead = cloneNode;
            }
            // Copying the data over
            cloneNode.setData(currentNode.getData());
            // Setting the next node of the clone node to the next of the current node.
            cloneNode.setNext(currentNode.getNext());
            // Setting the next node of the current node to the cloned node.
            // This way, the cloned node is now right in between the two nodes from the
            // original linked list. We'll use this in the next while loop for the random pointers.
            currentNode.setNext(cloneNode);
            // Setting the current node to the next node to continue with the loop.
            currentNode = cloneNode.getNext();
        }

        // Resetting the current node for the second iteration.
        currentNode = node;

        // In this iteration, I'm assigning the random pointers of the cloned nodes to the correct cloned node.
        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                if (currentNode.getRandom() != null) {
                    // The random pointer of the cloned node will be the next node of the
                    // random pointer of the current node.
                    currentNode.getNext().setRandom(currentNode.getRandom().getNext());
                }
                currentNode = currentNode.getNext().getNext();
            }
        }

        // Resetting the current node for the second iteration.
        currentNode = node;

        // I'm separating the original and the cloned linked lists.
        while (currentNode != null) {
            // In the last iteration, I stitched the cloned nodes in between the original nodes.
            // Here I'm taking a reference to that cloned node.
            Node<Integer> cloneNode = currentNode.getNext();
            if (cloneNode != null) {
                // This next node will be a pointer to the next origin node.
                Node<Integer> nextNode = null;
                if (cloneNode.getNext() != null) {
                    nextNode = cloneNode.getNext();
                    // Here I'm setting the cloned node's next to the next cloned node.
                    if (nextNode != null) {
                        cloneNode.setNext(nextNode.getNext());
                    }
                }
                // Setting the current node's next to the correct next node.
                currentNode.setNext(nextNode);
                currentNode = nextNode;
            }
        }

        System.out.println("Traversing cloned list");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        traverseLinkedList(cloneNodeHead);
    }
}
