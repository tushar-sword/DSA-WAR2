class Solution{
    public void Preorder(Node node){
        if(node == null){
            return ;
        }
 
        System.out.print(node.data);
        Preorder(node.left);
        Preorder(node.right);
    }
}