class Solution{

    public TreeNode buildTree(int preorder[], int inorder[]){

        <HashMap<Integer, Integer> map = new HashMap<>();

        // we made this map because we want to find the index of the root in the inorder array in O(1) time.
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;
    }

    public TreeNode buildTreeHelper(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, HashMap<Integer, Integer> map){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        // The first element of the preorder array is the root of the tree.
        TreeNode root = new TreeNode(preorder[preStart]); // pre se element leke 

        // find the index of the root in the inorder array using the map.
        int inRoot = map.get(root.val);  // usse check kiya inorder me kaha hai
        int numsLeft = inRoot - inStart; // uske left me kitne elements hai inorder me

        // recursively build the left and right subtrees.
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map); // pre se next element leke left subtree banayenge, aur inorder me uske left me jitne elements hai utne elements leke left subtree banayenge
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);  // pre se next element leke right subtree banayenge, aur inorder me uske right me jitne elements hai utne elements leke right subtree banayenge

        return root;
    }
}

