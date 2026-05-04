// The key is to do this without storing the Inorder part vrna usko store krke toh krte rho next has next wala kaam

// toh ek stack loo Inorder way he follow krege but without store sare left daloo fir , right ke sare ese krke
public class BSTinterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTinterator(TreeNode root){
        
        pushAll(root);
    }


    public void pushAll(TreeNode node){

        while(node != null){
            stack.push(node);

            node = node.left;
            // dal diye sare left element 
        }
    }

    public int next(){
        TreeNode tempNode = stack.pop();

        // next wale element ke right ko capture krne ko kosis usko print krke
        pushAll(tempNode.right);

        return tempNode.val;
    }

    public boolean HasNext(){
        return !stack.isEmpty();
    }
}