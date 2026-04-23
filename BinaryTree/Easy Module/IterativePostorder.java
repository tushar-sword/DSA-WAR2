// DO Stack lo root element ko push kro pop and push in stack2 then fir uska left right child push krte rho stack 1 
// ese he stack 1 empty hone tak fir stack 2 se pop krke print krte rho

class Solution{
    public void IterativePostorder(Node node){
        if(node == null){
            return ;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty()){
            Node temp = s1.pop();
            s2.push(temp);

            if(temp.left != null){
                s1.push(temp.left);
            }
            if(temp.right != null){
                s1.push(temp.right);
            }
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().data);
        }
    }
}