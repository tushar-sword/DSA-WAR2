public Solution{
    public int MaxBST(TreeNode root){
        int max = -1;
        while(root != null){
           max = root;
           root = root.right;
        }
    }
}