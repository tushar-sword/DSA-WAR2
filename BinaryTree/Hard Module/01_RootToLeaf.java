class Solution {

    public List<Integer> binaryTreePaths(TreeNode root, int B) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) {
            return null;
        }
        findPath(root,arr, B);
        return arr;
    }

    public boolean fintPath(TreeNode root , List<Integer> arr , int B){
        if(root == null){
            return ;
        }

        arr.add(root.val);

        if(root.val == B){
            return true;
        }

        if(fintPath(root.left, arr, B) || fintPath(root.right, arr, B)){
            return true;
        }

        arr.remove(arr.size() - 1); // Backtrack if not found
        return false;
    }
}