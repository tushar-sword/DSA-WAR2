class Solution{

   // what i can think is to get the right view we need left side nodes for sure and in easy way at every horizontal level we want the least vertical element 
   // and for left view we want the right side nodes for sure and in easy way at every horizontal level we want the greatest vertical element

   // but this goona take lot of space so what we do is 
   // we do recurive traversal reverse preorder Root Left Right to root right left 
   // and just keep track of the level and if the level is not visited before then add that node to the answer list
    public function(Node , Level , List<Integer> ans){
        if(node == null){
            return ;
        }

        if(level == ans.size()){
            ans.add(node.data);
        }

        function(node.right, level+1, ans);
        function(node.left, level+1, ans);
    }
}