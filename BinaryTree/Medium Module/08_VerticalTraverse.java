class Solution{
    // Ok so kaise krege Vertical Traversal make it like a number row jha root 0th point pe hoga jo left mei atta jaega
    // vo -1 hota jaega aur right mei atta jaega vo +1 hota jaega. So we can use a map to store the nodes according to their vertical levels.
    // and also we have to keep their horizontal level too so that we can sort them right 

    // TreeMap keep things sorted and we can use a list to store the nodes at the same vertical level and horizontal level

    class Pair{
        TreeNode node;
        int vertical;
        int horizontal;

        public Pair(TreeNode node , int vertical , int horizontal){
            this.node = node;
            this.vertical = vertical;
            this.horizontal = horizontal;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root){

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair pair = q.poll();  // nikalo element 
            TreeNode node = pair.node; // aur uska node lelo
            int vertical = pair.vertical; // uska vertical level 
            int horizontal = pair.horizontal; // uska horizontal level

            if(!map.containsKey(vertical)){
                map.put(vertical , new TreeMap<>());  // agar vertical level nahi hai to usko add krdo
            }
            if(!map.get(vertical).containsKey(horizontal)){
                map.get(vertical).put(horizontal , new PriorityQueue<>()); // agar horizontal level nahi hai to usko add krdo us vertical level ke andar usko add krdo
            }

            map.get(vertical).get(horizontal).add(node.val); // uske vertical level ke horizontal level pe uska value add krdo

            if(node.left != null){
                q.add(new Pair(node.left , vertical - 1 , horizontal + 1)); // left child ka vertical level -1 hota hai aur horizontal level +1 hota hai
            }
            if(node.right != null){
                q.add(new Pair(node.right , vertical + 1 , horizontal + 1)); // right child ka vertical level +1 hota hai aur horizontal level +1 hota hai
            }
        }

        // esko print kaise krna hai ki vertical level ke hisab se print hoga aur uske ander horizontal level ke hesab se print hoga aur agar same vertical level aur horizontal level hai to usko sort krke print krna hai
        // Toh jaise 

        for(TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values()){ // ab map ke values ko iterate kro jisme vertical level ke hisab se sorted hoga
            List<Integer> level = new ArrayList<>(); // ek list bna lo jisme us vertical level ke nodes ko store kroge

            for(PriorityQueue<Integer> horizontal : vertical.values()){ // ab vertical level ke hisab se horizontal level ke hisab se sorted hoga usme add krna start krdo 
                while(!horizontal.isEmpty()){ // jab tak horizontal level ke nodes khatam nahi ho jate tab tak usko add krte raho
                    level.add(horizontal.poll());
                }
            }
            ans.add(level); // us vertical level ke nodes ko ans me add krdo
        }

        return ans;
    }
}