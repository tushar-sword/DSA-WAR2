class Solution{

    // simple story pehle parent mark kro by a queue root dalna uske child dal jab dale vo jiske vjh se aae vo uska parent record in a map
    // Ab apne Target Node pe jao aur bfs traversal kro mtlb left right parent teeno ko explore krna hai  and add only if not visited yet  this is to make sure koi distance travel krne ke bad jha se aya hai vha vapis na jae
    // gae bhar ke trf krlia explore currentdistance - 1 krdo
    // jab current distance 0 bach jae jo us queue mei pda hoga jisse tum next explore krne wale the but nahi kiya because you are already at k distance from target node
    // usko khali krlo aur bna doo answer list and return krdo

    
    // Main method to find nodes at distance K from target node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();

        // Step 1: Build parent references using BFS
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        // Step 2: Perform BFS from target to find all nodes at distance K
        return bfsFromTarget(target, parentMap, k);
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
    }|


     // BFS starting from the target node to collect nodes at distance K
    private List<Integer> bfsFromTarget(TreeNode target, Map<TreeNode, TreeNode> parentMap, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int currentLevel = 0;

        // Standard level-order BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Stop traversal once we reach distance K
            if (currentLevel++ == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // left right parent teeno ko explore krna hai  and add only if not visited yet  this is to make sure koi distance travel krne ke bad jha se aya hai vha vapis na jae

                // Explore left child add only if not visited yet  this is to make sure koi distance travel krne ke bad jha se aya hai vha vapis na jae 
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Explore right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // Explore parent from map
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
        }

        // All nodes left in queue are exactly K distance from target
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}

