class Solution{
    public SingleTrans(Node root){

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Pair<Node, Integer>> st = new Stack<>();

        st.push(new Pair(root, 1));


    }hile (!st.empty()) {
            Pair<Node, Integer> it = st.pop();

           // Pre
            if (it.getValue() == 1) {
               
                pre.add(it.getKey().data);
                it.setValue(2);
                st.push(it);

                // add left 

                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            // IN
            else if (it.getValue() == 2) {
                in.add(it.getKey().data);
                it.setValue(3);
                st.push(it);

                // Push right child 
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }

            // this is part of post
            else {
                post.add(it.getKey().data);
            }
        }
}