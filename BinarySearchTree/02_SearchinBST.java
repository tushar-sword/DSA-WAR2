class Solution {
    public boolean Search(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.val) {
            return true;
        } 
        else if (value < root.val) {
            return Search(root.left, value);
        } 
        else {
            return Search(root.right, value);
        }
    }
}

// // Iterative Solution
// public TreeNode Search(TreeNode root , int value){
//         while(root != null && root.val != value){
//             root = value < root.val ? root.left : root.right;
//         }

//         return root;
//     }
