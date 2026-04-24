class Solution{

    public void printLeftBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        System.out.println(root.val);
        if(root.left != null){
            printLeftBoundary(root.left);
        }else{
            printLeftBoundary(root.right);
        }
    }

    public void printLeafNodes(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            System.out.println(root.val);
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    public void printRightBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        if(root.right != null){
            printRightBoundary(root.right);
        }else{
            printRightBoundary(root.left);
        }
        System.out.println(root.val);  //  Reverse order me print karna hai right boundary ko

    }



    public Traversal(TreeNode root){

        System.out.println(root.val);
        printLeftBoundary(root.left);
        printLeafNodes(root.left);
        printLeafNodes(root.right);
        printRightBoundary(root.right);
    }
}