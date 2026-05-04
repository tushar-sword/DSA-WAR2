class Solution{
    public int Floor(TreeNode root , int value){
        
        floor = -1;
        while(root != null){
            if(root.val == value){
                floor = root.val;
                return floor;
            }

            if(root.val < value){
                floor = root.val;
                root = root.right;
            }
            else{
                root=root.left;
            }

            return floor ;
        }
    }
}