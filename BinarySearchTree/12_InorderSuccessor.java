class Solution{
    public TreeNode inOrderSucc(TreeNode root , TreeNode p){

        TreeNode Successor = null;

        if( p.val >= root.val){
            root = root.right;
        }

        // successor se bda hai save and move left 
        else{
            Successor = root;
            root = root.left;
        }


        return Successor;
    }
}