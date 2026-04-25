class Pair{
    TreeNode node;
    int line;

    public Pair(TreeNode _node, int _num){
        node = _node;
        num = _num;
    }
}

class Solution{
    public int MaxWidth(TreeNode root){

        if(root == null){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){

            int size = q.size();
            int min = q.peek().num; // minimum line number at current level 1st node's line number at current level has the minimum line number at current level

            int first = 0, last = 0;

            for(int i=0;i<size;i++){

                int curr_id = q.peek().num - min; // current line number normalized to prevent overflow // what this mean 
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) first = curr_id; // first node's line number at current level
                if(i == size - 1) last = curr_id; // last node's line number at current level

                if(node.left != null){
                    q.add(new Pair(node.left, 2 * curr_id + 1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, 2 * curr_id + 2));
                }
            }

                maxWidth = Math.max(maxWidth, last - first + 1); // calculate width at current level
        }
        return maxWidth;
    }
}