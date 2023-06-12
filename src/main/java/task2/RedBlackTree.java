package task2;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    // Implement the required properties of a red-black tree

    // Declare a private instance variable 'root' of type 'Node<Key, Value>' to store the root of the tree
    private Node<Key, Value> root;

    // Track the number of iterations needed for the get() operation to complete
    // Declare a public instance variable 'numSteps' of type 'int'
    public int numSteps = 0;

    // Constructor for RedBlackTree class
    public RedBlackTree() {
        // Initialize the root as null and numSteps as 0
        this.root = null;
        this.numSteps = 0;
    }

    // Get the value associated with the given key
    public Value get(Key key) {
        // Call the  method 'getNode' to find the node with the given key
        Node<Key, Value> node = getNode(root, key);
        // Return the value of the node if found, otherwise return null
        return node != null ? node.getValue() : null;
    }

    // Recursive helper method to find a node with the given key
    private Node<Key, Value> getNode(Node<Key, Value> node, Key key) {
        // Given node is null or the key matches the current node key
        if (node == null || key.compareTo(node.getKey()) == 0) {
            return node;
        }
        // Key is less than the current node key
        else if (key.compareTo(node.getKey()) < 0) {
            numSteps++;
            // Search in the left subtree
            return getNode(node.getLeft(), key);
        }
        // Key is greater than the current node key
        else {
            numSteps++;
            // Search in the right subtree
            return getNode(node.getRight(), key);
        }
    }

    // Insert a key-value pair into the tree
    public void put(Key key, Value value) {
        // Call the private method 'putNode' to recursively insert the node
        root = putNode(root, key, value);
        // Set the color of the root node to black
        root.setRed(false);
    }

    // Recursive method to insert a node into the tree
    private Node<Key, Value> putNode(Node<Key, Value> node, Key key, Value value) {
        // Program found the correct position to insert the node
        if (node == null) {
            return new Node<>(key, value);
        }

        // Compare the key with the current node key
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            // Key is less than the current node key, insert in the left subtree
            node.setLeft(putNode(node.getLeft(), key, value));
        } else if (cmp > 0) {
            // Key is greater than the current node key, insert in the right subtree
            node.setRight(putNode(node.getRight(), key, value));
        } else {
            // Key already exists, update the value
            node.setValue(value);
        }

        // Perform the necessary rotations and color flips to maintain the red-black tree properties
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        return node;
    }

    // Check if a node is red
    private boolean isRed(Node<Key, Value> node) {
        return node != null && node.isRed();
    }

    // Perform a left rotation on a node
    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);
        rightChild.setRed(node.isRed());
        node.setRed(true);
        return rightChild;
    }

    // Perform a right rotation on a node
    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);
        leftChild.setRed(node.isRed());
        node.setRed(true);
        return leftChild;
    }

    // Flip the colors of a node and its children
    private void flipColors(Node<Key, Value> node) {
        node.setRed(true);
        node.getLeft().setRed(false);
        node.getRight().setRed(false);
    }

    // Count the number of red links in the tree
    public int countRedLinks() {
        return countRedLinks(root);
    }

    // Recursive method to count red links in the tree
    private int countRedLinks(Node<Key, Value> node) {
        // If program reaches null node it should return 0
        if (node == null) {
            return 0;
        }

        int count = 0;
        // Check if the left child is red
        if (isRed(node.getLeft())) {
            count++;
        }
        // Check if the right child is red
        if (isRed(node.getRight())) {
            count++;
        }

        // Recursively count the red links in the left and right subtrees
        count += countRedLinks(node.getLeft());
        count += countRedLinks(node.getRight());

        return count;
    }

    // Get the number of steps taken for the get() operation
    public int getNumSteps() {
        return numSteps;
    }
}
