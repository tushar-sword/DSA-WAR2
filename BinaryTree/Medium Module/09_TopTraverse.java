// Same last question jaisa kro but sare vertical level ka Horizontally level ke hisab se 1st element only 


import.java.util.*;
// Class representing a single node of the binary tree
class Node {
    // Value stored in the node
    int data;
    // Reference to the left child
    Node left;
    // Reference to the right child
    Node right;
    // Constructor to initialize a node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Class containing the logic for top view
class Solution {
    // Function to return the top view of the binary tree
    public java.util.List<Integer> topView(Node root) {
        // Create a list to store the final result
        java.util.List<Integer> ans = new java.util.ArrayList<>();

        // If the tree is empty, return empty result
        if (root == null) {
            return ans;
        }

        // Map to store vertical level -> node value (only first encountered)
        java.util.Map<Integer, Integer> mpp = new java.util.TreeMap<>();

        // Queue for BFS storing {node, vertical_level}
        java.util.Queue<java.util.AbstractMap.SimpleEntry<Node, Integer>> q = new java.util.LinkedList<>();

        // Push the root node with vertical level 0
        q.add(new java.util.AbstractMap.SimpleEntry<>(root, 0));

        // Start BFS traversal
        while (!q.isEmpty()) {
            // Get the front element of the queue
            java.util.AbstractMap.SimpleEntry<Node, Integer> entry = q.poll();
            Node node = entry.getKey();
            int line = entry.getValue();


            // This is the Key
            // If vertical position is visited for the first time, store the value
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            if (node.left != null) {
                q.add(new java.util.AbstractMap.SimpleEntry<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new java.util.AbstractMap.SimpleEntry<>(node.right, line + 1));
            }
        }

        // Transfer values from the map to the answer list
        for (int val : mpp.values()) {
            ans.add(val);
        }

        // Return the result
        return ans;
    }
}
