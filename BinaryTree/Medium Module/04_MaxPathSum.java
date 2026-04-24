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
    int sum = Integer.MIN_VALUE;

    public int solution(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = Math.max(solution(root.left),0);
        int rh = Math.max(solution(root.right),0);

        sum = Math.max(sum , lh +rh + root.val);

        return root.val + Math.max(lh,rh);
    }
    public int maxPathSum(TreeNode root) {

         solution(root);

        return sum;
        
    }
}