class Solution{
    private int fib(int index,int []dp, int []arr){
        // no cost from 0 to 0
        if(index==0){
            return 0;
        }

        // subproblem already solved and stored ?
        if(dp[index] != -1){
            return dp[index];
        }

        int left = fib(index-1,dp)+ Math.abs(arr[index]-arr[index-1]);
        
        int right = Integer.MAX_VALUE;
        if(index>1){
            int right = fib(index-2,dp)+ Math.abs(arr[index]-arr[index-2]);
        }
        // save the result in dp array before returning
         dp[index]=Math.min(left,right);
         return dp[index];
    }
}

class Memorization{
    public static void main(String args[]){
        int index = 5;
        int arr[]= {30,10, 60, 10, 60, 50};
        int []dp = new int[index+1];
        Arrays.fill(dp,-1);
        Solution sol = new Solution();
        System.out.println(sol.fib(index,dp,arr));
    }
}