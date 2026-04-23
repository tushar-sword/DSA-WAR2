public static void main(String args[]){
        int day = 2;
        int last = 3;
        int points[][] = {{1,2,5},{3,1,1},{3,3,3}};
        int dp[][] = new int[day+1][last+1];
        
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        // if only 1 day exist 
        dp[0][3] = Math.max(points[0][0], points[0][1], points[0][2]);

        for(int d = 1 ;i d<day;d++){

            for(int last = 0 ; last <= 3; last++){
                dp[d][last]=0;
                for(int task = 0 ; task<=3;task++){
                    if(task != last){
                        int point = points[d][task] + dp[d-1][task];
                        dp[d][last] = Math.max(dp[d][last], point);
                    }
                }
            }
        }
        return dp[day-1][3];
}
