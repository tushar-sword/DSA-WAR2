class Solution {
    
    void inorderTraversal(Node root, List<Integer> arr) {
        
        if (root == null) return;
        inorderTraversal(root.left, arr);
        arr.add(root.data);
        inorderTraversal(root.right, arr);
    }

    // Function to merge two sorted lists
    List<Integer> mergeArrays(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> merged = new ArrayList<>();
        // Initialize pointers
        int i = 0, j = 0;
        // Merge until one list ends
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) merged.add(arr1.get(i++));
            else merged.add(arr2.get(j++));
        }
        // Add remaining elements
        while (i < arr1.size()) merged.add(arr1.get(i++));
        while (j < arr2.size()) merged.add(arr2.get(j++));
        return merged;
    }

    // Function to merge two BSTs
    List<Integer> mergeBSTs(Node root1, Node root2) {
        // Lists to store inorder traversals
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inorderTraversal(root1, arr1);
        inorderTraversal(root2, arr2);
        // Merge and return
        return mergeArrays(arr1, arr2);
    }
}