class Solution{
    public int changeTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int child = 0;

        // childrens ka sum nikal liya 
        if(root.left != null){
            child += root.left.val;
    }
    if(root.right != null){
        child += root.right.val;
    }

    // root se compare krke bda wala implement kiya 
    if(child >= root.val){
        return child;
    }
    else{
        if(root.left != null){
            root.left.val = root.val;
        }
        if(root.right != null){
            root.right.val = root.val;
        }
    }

    changeTree(root.left);
    changeTree(root.right);

    // yha tkk neche jate hue value update ho gae ab upper move krege


    // childrens ka sum nikal liya aur usko root mei update krdia
    int total = 0;
    if(root.left != null){
        total += root.left.val;
    }
    if(root.right != null){
        total += root.right.val;
    }

    if(root.left != null || root.right != null){
        root.val = total;
    }

    return root.val;
    }





}