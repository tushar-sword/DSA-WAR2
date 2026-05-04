class Solution{
    public TreeNode Insert(TreeNode root , int val){
        TreeNode curr = root;
        if(curr.val <= val){

            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr.right = new TreeNode(val);
                break;
            }

            else{

                if(curr.left != null){
                    curr = curr.left;
                }
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
    }
}

//koi node mile agar uski value hamare insert value se agar choti ho ya barabar ho toh uske right side ham apne node ko
// insert kr skte hai so before insert it we check right side khali hai agar nahi hai we make that right node current 
// aur agar khali hai toh ek new node banao insert maroo aur agge badho