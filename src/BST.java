import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

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
    public boolean searchHelper(BSTNode current, int val)
    {
        if(current == null)
        {
            return false;
        }
        if (val == current.getVal())
        {
            return true;
        }
        else if (val < current.getVal()){
            return searchHelper(current.getLeft(), val);
        }
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
    public ArrayList<BSTNode> getInorderHelper(BSTNode current, ArrayList<BSTNode> inorder){
        if (current == null)
        {
            return null;
        }
            getInorderHelper(current.getLeft(), inorder);
            inorder.add(current);
            getInorderHelper(current.getRight(), inorder);

        return inorder;
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

    public ArrayList<BSTNode> preorderHelper(BSTNode current, ArrayList<BSTNode> preorder){
        if (current == null)
        {
            return null;
        }
        preorder.add(current);
        preorderHelper(current.getLeft(), preorder);
        preorderHelper(current.getRight(), preorder);
        return preorder;
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

    public ArrayList<BSTNode> postorderHelper(BSTNode current, ArrayList<BSTNode> postorder){
        if (current == null)
        {
            return null;
        }
        postorderHelper(current.getLeft(), postorder);
        postorderHelper(current.getRight(), postorder);
        postorder.add(current);
        return postorder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
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
