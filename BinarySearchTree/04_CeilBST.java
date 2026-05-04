class Solution {
    public int findCeil(TreeNode root, int value) {
        int ceil = -1;

        while (root != null) {
            if (root.val == value) {
                return root.val;
            }

            if (root.val > value) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }
}