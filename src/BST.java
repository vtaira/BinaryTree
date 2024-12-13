import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Veronica Taira
 * @version: 12/12/24
 */

public class BST {
    // Instance variables
    private BSTNode root;

    // Method returns root of BST
    public BSTNode getRoot() {
        return this.root;
    }

    // Method sets BSTNode as root
    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
            return searchHelper(root, val);
    }

    // Helper function for search function, uses recursion
    public boolean searchHelper(BSTNode current, int val)
    {
       // If we have reached a node that doesn't exist, return false
        if(current == null)
        {
            return false;
        }

        // If the value we're searching for equals the value of the current node, return true
        if (val == current.getVal())
        {
            return true;
        }

        // If the value is less than the current node value, recursively traverse down the left side of the tree
        else if (val < current.getVal()){
            return searchHelper(current.getLeft(), val);
        }

        // If the value is greater than the current node value, recursively traverse down the right side of the tree
        else {
            return searchHelper(current.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> inorder = new ArrayList<>();
        getInorderHelper(root, inorder);
        return inorder;

    }

    // Helper function for getInorder function, returns an ArrayList of nodes
    public void getInorderHelper(BSTNode current, ArrayList<BSTNode> inorder){
        // Base case: if the current node doesn't exist, stop recursion
        if (current == null)
        {
            return;
        }

            // Recursively traverses through left side of tree until the leftmost node is reached
            // Adds that node to the inorder ArrayList
            getInorderHelper(current.getLeft(), inorder);
            inorder.add(current);

            // Traverses through the right side of the tree starting at the current node
            getInorderHelper(current.getRight(), inorder);
    }


    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
       ArrayList<BSTNode> preorder = new ArrayList<>();
      preorderHelper(root, preorder);
        return preorder;

    }

    // Helper function for getPreorder(), returns ArrayList of nodes in preorder
    public void preorderHelper(BSTNode current, ArrayList<BSTNode> preorder){
       // Base case: if the current node doesn't exist, stop recursion
        if (current == null)
        {
            return;
        }

        // Add the current node to the preorder array
        preorder.add(current);
        // Recursively traverse down the BST to the furthest left node, add that to the tree
        preorderHelper(current.getLeft(), preorder);
        // Rraverse down the BST on the right, adding each node from the bottom up
        preorderHelper(current.getRight(), preorder);

    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorder = new ArrayList<>();
       postorderHelper(root, postorder);
       return postorder;

    }

    // Helper function for getPostorder(), returns an ArrayList of BSTNodes
    public void postorderHelper(BSTNode current, ArrayList<BSTNode> postorder){
        // Base case: if the current node doesn't exist, stop recursion
        if (current == null)
        {
            return;
        }
        // Recursively traverse the left subtree of the current node
        postorderHelper(current.getLeft(), postorder);
        // Recursively traverse the right subtree of the current node
        postorderHelper(current.getRight(), postorder);
        // Add the current node to the postorder ArrayList
        postorder.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(root, val);


    }
    // Helper function for insert(), inserts specific value into BST
    public void insertHelper (BSTNode current, int val)
    {
        // If the value given is less than the current node value, and the node does not have a right child
        // Set the current node's right child to val
        if(val > current.getVal())
       {
           if(current.getRight() == null)
           {
               current.setRight(new BSTNode(val));
           }
           // If the node has a right child, recursively travel down the right side of the node
           // Until the val can be correctly placed
           else {
               insertHelper(current.getRight(), val);
           }
       }
       // If val is less than the current node's value, and the current node doesn't have a left child
       // Set val as the left child
       if(val < current.getVal())
       {
            if(current.getLeft() == null)
            {
                current.setLeft(new BSTNode(val));
            }
            // Else, recursively traverse down the current node's left subtree until val can be placed
            else{
                insertHelper(current.getLeft(), val);
            }
       }
    }
    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
