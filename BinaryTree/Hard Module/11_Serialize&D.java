class Solution{
    public string serialize(TreeNode root){
        if(root == null){
            return " ";

            Queue<TreeNode> q = new LinkedList<>();

            StringBuilder res = new StringBuilder();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode node = q.poll();

                if(node == null){
                    res.append("#");
                    continue;
                }

                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);

            }

            return res.toString();
        }
    }

    public TreeNode deserialize(String data){
        if(data == " "){
            return null;
        }

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        int i=1;

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(!values[i].equals("#")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.left);
            }
            i++;

            if(!nodes[i].equals("#")){
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }
}