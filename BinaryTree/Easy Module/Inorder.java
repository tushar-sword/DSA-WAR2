class Solution{
public Inorder(Node node){

    if(node == null){
        return ;
    }

    Inorder(node.left);
    System.out.print(node.data);
    Inorder(node.right);
}

public static void main(String args[]){
    // we got a root right
    Inorder(root);
}
}
