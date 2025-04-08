
public class Binarytree {

    // TreeNode class to represent each node of the tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to build the binary tree
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // A helper method that will build the tree using index ranges
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // Helper method that uses indices to track subarrays in preorder and inorder
    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                            int[] inorder, int inStart, int inEnd) {
        // Base case: if there are no elements to process
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root of the current subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of root in inorder traversal
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Calculate the number of nodes in the left subtree
        int leftSize = rootIndexInInorder - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, 
                                    inorder, inStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, 
                                     inorder, rootIndexInInorder + 1, inEnd);

        return root;
    }

    // Helper function to print the tree in inheritor (for testing)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Example input for preorder and inorder traversal
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Build the tree from the traversals
        TreeNode root = buildTree(preorder, inorder);

        // Print the inorder traversal of the constructed tree (should match the given inorder)
        inorderTraversal(root);  // Output should be: 9 3 15 20 7
    }
}


    // TreeNode class to represent each node of the tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    

    // Method to build the binary tree
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // A helper method that will build the tree using index ranges
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // Helper method that uses indices to track subarrays in preorder and inorder
    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                            int[] inorder, int inStart, int inEnd) {
        // Base case: if there are no elements to process
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root of the current subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of root in inorder traversal
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Calculate the number of nodes in the left subtree
        int leftSize = rootIndexInInorder - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, 
                                    inorder, inStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, 
                                     inorder, rootIndexInInorder + 1, inEnd);

        return root;
    }

    // Helper function to print the tree in inorder (for testing)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Example input for preorder and inorder traversal
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Build the tree from the traversals
        TreeNode root = buildTree(preorder, inorder);

        // Print the inorder traversal of the constructed tree (should match the given inorder)
        inorderTraversal(root);  // Output should be: 9 3 15 20 7
    }
}
