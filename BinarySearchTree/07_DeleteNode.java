class Solution {

    public TreeNode helper(TreeNode root) {
        // case 1: no left child
        if (root.left == null) {
            return root.right;
        }
        // case 2: no right child
        if (root.right == null) {
            return root.left;
        }

        // case 3: both children exist
        TreeNode rightSubtree = root.right;
        TreeNode lastRight = findLastRight(root.left);

        lastRight.right = rightSubtree;

        return root.left;
    }

    public TreeNode findLastRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLastRight(node.right);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // if root itself is the node to delete
        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }
}