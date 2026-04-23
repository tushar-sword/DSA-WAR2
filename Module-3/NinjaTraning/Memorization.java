public Solution{
    public int Function(int day, int last,int [][]points,int dp[][]){
        // base case
        if(day==0){
            int maxi=0;
            for(int task=0;task<=3;task++){
                if(task != last){
                   int point = points[day][task];
                }
                maxi = Math.max(maxi, point);
                }
                return maxi;
            }

            if(dp[day][last] != -1){
                return dp[day][last];
            }

            // for rest days
            int maxi=0;
            for(int task=0;task<=3;task++){
                if(task != last){
                     int point = points[day][task] + Function(day-1,task);
                }
                maxi = Math.max(maxi, point);
        }
        return dp[day][last] = maxi;
    }
