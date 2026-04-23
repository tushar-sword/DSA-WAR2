class Solution{
    private int fib(int n,int []dp){
        if(n<=1){
            return n;
        }
        
        // subproblem already solved and stored ?
        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n]= fib(n-1,dp) + fib{n-2,dp};

    }
}
class FibonacciDP{
    public static void main(String []args){
        int n = 5;
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        Solution sol = new Solution();
        System.out.println(sol.fib(n,dp));
    }
}