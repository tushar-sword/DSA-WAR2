// Two node swapped look for the violation
// first store 1st violation
// medium - adjacent to 1st violation
// last - 2nd violation
// medium is used if no 2nd violation else first and last play


class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        helper(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        helper(node.right);
    }
}