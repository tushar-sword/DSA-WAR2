class Solution{
    public ZigZagTraverse(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(leftToRight){
                    level.add(node.val);
                }
                else{
                    level.add(0,node.val); //Start adding from 0th index to reverse the order
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }

               
            }
             ans.add(level);
            leftToRight = !leftToRight; //changing the Direction
        }

        return ans;
    }
}