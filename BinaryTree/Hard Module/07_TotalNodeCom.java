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

    public int leftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh){
            return (1 << lh) - 1;  // 2^h - 1
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}