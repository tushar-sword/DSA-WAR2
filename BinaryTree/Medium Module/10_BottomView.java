class Solution{
    public bottomView ( Node root) {
        java.util.Map<Integer, Integer> mpp = new java.util.TreeMap<>();
        java.util.Queue<java.util.AbstractMap.SimpleEntry<Node, Integer>> q = new java.util.LinkedList<>();

        q.add(new java.util.AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            // Get the front element of the queue
            java.util.AbstractMap.SimpleEntry<Node, Integer> entry = q.poll();
            Node node = entry.getKey();
            int line = entry.getValue();

            // Update the value for the vertical position
            // kuki we need the last value for that vertical position
            mpp.put(line, node.data);

            // If left child exists, push it with vertical level - 1
            if (node.left != null) {
                q.add(new java.util.AbstractMap.SimpleEntry<>(node.left, line - 1));
            }

            // If right child exists, push it with vertical level + 1
            if (node.right != null) {
                q.add(new java.util.AbstractMap.SimpleEntry<>(node.right, line + 1));
            }

            for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;


        }
}