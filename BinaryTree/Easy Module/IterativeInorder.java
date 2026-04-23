// Iterative Inorder mei root lo fir uska left niaklte rho jab na bache tab usko pop krke result mei daldo aur right pe jao fir wapis se left nikalte rho jab na bache tab usko pop krke result mei daldo aur right pe jao

class Solution{
    public void IterativeInorder(Node node){
        if(node == null){
            return ;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = node;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data); // at this place you can also add the data to a list and return the list instead of printing it
            curr = curr.right;
        }
    }
}