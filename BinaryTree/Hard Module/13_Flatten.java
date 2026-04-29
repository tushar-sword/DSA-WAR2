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

     public void InOrder(TreeNode root , List<Integer> ans){
        TreeNode curr = root;
        if(root == null){
            return ;
        }
        
        
        InOrder(curr.left,ans);
        ans.add(curr.val);
        InOrder(curr.right,ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();

        InOrder(root,ans);
        return ans;
    }
}