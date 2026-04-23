class Solution{
    public void postorder(Node node){
        if(node == null){
            return ;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}