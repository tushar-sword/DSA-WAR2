//root uska right then left ko push karna hai stack me taki left pehle pop ho aur print ho

class Solution{
    public IterativePreorder(Node node){
        if(node == null){
            return ;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.data); // at this place you can also add the data to a list and return the list instead of printing it

            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
    }
}