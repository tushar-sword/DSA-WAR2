class Solution{
    // dono node ya toh left right hoge 
    // ya right right 
    // ya left left 

    // jab left right ho no issue jha khade ho vhe ans hai
    // aur nahi toh vha chle jao jha se ek left ho aur ek right vo lowest common ancestor he hoga


    public TreeNode LCABST(TreeNode root , TreeNode p ,  TreeNode q){
        if(root == null){
            return null;
        }

        int curr = root.val;

        // jab dono left side ho
        if(p.val < curr && q.val< curr ){
            return LCABST(root.left , p , q);
        }

        // jab dono right side ho 
        if(p.val > curr && q.val > curr){
            return LCABST(root.right , p , q);
        }

        return root;
        
    }
}