// The key is to do this without storing the Inorder part vrna usko store krke toh krte rho next has next wala kaam

// toh ek stack loo Inorder way he follow krege but without store sare left daloo fir , right ke sare ese krke
public class BSTinterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTinterator(TreeNode root , boolean isReverse){
        reverse = isReverse;
        
        pushAll(root);
    }


    public void pushAll(TreeNode node){

        while(node != null){
            stack.push(node);

            if(reverse == false){
            node = node.left;
            }
            // dal diye sare left element 


            else{
                node = node.right;
            }
        }
    }

    public int next(){
        TreeNode tempNode = stack.pop();

        if(reverse == false){
        // next wale element ke right ko capture krne ko kosis usko print krke
        pushAll(tempNode.right);
        }

        else{
            pushAll(tempNode.left);
        }

        return tempNode.val;
    }

    public boolean HasNext(){
        return !stack.isEmpty();
    }


    // Main function 
    boolean FindTarget(TreeNode root , int k){
        if(root == null){
            return false;
        }

        // ek element left se liya ek right se 
        BSTinterator l = new BSTinterator(root , false);
         BSTinterator r = new BSTinterator(root , true);

        int i = l.next;
        int j = r.next;

         // ab dono ko check kro 

         while(i<j){ // cross nahi kiya ek dusre ko 
            if(i+j == k){
                return true;
            }

            else if( i+j < k ){
                i = l.next; // value badhao
                        }

                        else{
                            j = r.next; // value kaam kro 
                        }
         }

         return false;
    }
}