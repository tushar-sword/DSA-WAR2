class Solution{
    public TreeNode deleteNode(TreeNode root, int key){

        

        if(root == null){
            return null;
        }

        if(root.val = key){
            return helper(root);
        }

        TreeNode dummy = root;
        
        while(root != null){
            if(root.val > key){

                if(root.left != null && root.left == key){
                    return helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right == key){
                    return helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }

        return dummy;
    }
}

public TreeNode helper(TreeNode root){
    // agar left side he null nikal jae
    if(root.left == null){
        return root.right;
    }
    else if(root.right == null){
        return root.left;
    }

    // agar dono na nikle toh niklo left ka Greatest element aur kro connect right subtree se 

    else{

        TreeNode rightsubtree = root.right;
        TreeNode lastRightofLeft = findLastRight(root.left);

        lastRightofLeft.right = rightsubtree;
    }
}

public TreeNode findLastRight(TreeNode left){
    if(root.right == null){
        return root;
    }

    return findLastRight(root.right);
}