class Solution{
    public TreeNode  buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }

        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
    }

    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, java.util.Map<Integer, Integer> map){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeHelper(inorder, postorder, inStart, inRoot - 1, postStart, postStart + numsLeft - 1, map);
        root.right = buildTreeHelper(inorder, postorder, inRoot + 1, inEnd, postStart + numsLeft, postEnd - 1, map);

        return root;
    }
}