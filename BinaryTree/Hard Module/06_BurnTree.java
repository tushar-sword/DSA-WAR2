// ek target dia hoga btao kab sara burn ho jaega kitna time lagega
// last question ke trh he toh hai hrr bar out move krte hue count krege jab queue pore empty ho jae toh return krdo count
// isme visisted will be used to tell kon already burn ho chuka hoga and kon next burn hone wala hoga


// tuf pe ek graph solution bhi hai eska using adjancy list bna ke bfs krlo but usme space complexity jyada ho jaegi isliye tree ke trh parent map bna ke bfs krna better hoga
write the code 

import java.util.*;
public class BurnTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Main method to find time taken to burn the entire tree from target node
    public int burnTree(TreeNode root, TreeNode target) {
        if (root == null) return 0;

        // Step 1: Build parent references using BFS
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        // Step 2: Perform BFS from target to find time taken to burn the entire tree
        return bfsBurnTime(target, parentMap);
    }

    private void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Record left child's parent
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            // Record right child's parent
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    private int bfsBurnTime(TreeNode target, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnedThisLevel = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Explore left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                    burnedThisLevel = true;
                }

                // Explore right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                    burnedThisLevel = true;
                }

                // Explore parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                    burnedThisLevel = true;
                }
            }           

            // Increment time only if at least one new node was burned in this level
            if (burnedThisLevel) {
                time++;
            }
        }

        return time;
    }
}


