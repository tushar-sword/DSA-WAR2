// The concept is that you either take 1 step or 2 steps, 
// so the number of ways to climb n steps is the 
// sum of the ways to climb n-1 steps and n-2 steps. 
// This is similar to the Fibonacci sequence.

class Solution{
    public static void main(String []args){
        int n=5;
        int []dp = int new[n+1];
        Arrays.fill(dp,-1);

        // This is the most optimal way to solve the problem, as it uses 
        // dynamic programming to store previously computed results and 
        // avoid redundant calculations.
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}