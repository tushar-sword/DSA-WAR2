/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);

        if (leftHeight == -1) 
            return -1;

        int rightHeight = dfsHeight(root.right);

        if (rightHeight == -1) 
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  
            return -1;


        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // Check if the tree's height difference between subtrees is less than 2
        // If not, return false; otherwise, return true
        return dfsHeight(root) != -1;


    }
}

// It is optimized because we are calculating the height and checking the balance at the same time, so we are not doing redundant calculations of height for each node.
// Like not doing for each node we are calculating height and checking balance, if we find any node which is not balanced we return -1 and that -1 will be propagated up the call stack, so we can avoid unnecessary calculations for the rest of the tree.