class Solution{

     private int k;
    private int result;

    public void Inorder(TreeNode node){
        if(node != null){
            Inorder(root.left);

            if(--k == 0){
                result = node.data;
                return;
            }

            Inorder(node.right);
        }
    }
    public int kthElement(TreeNode root , int k){
        // make k universal 
        this.k = k;
        this.result = -1;   
        inorder(root);
        return result;
    }
}