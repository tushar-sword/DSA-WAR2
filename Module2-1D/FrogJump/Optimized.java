class Tabulation{
    public static void main(String args[]){
        int index = 5;
        int arr[]= {30,10, 60, 10, 60, 50};
        
        int prev = 0;
        int prev2=0;

        for(int i=1;i<=idex;i++){
            int left = prev + Math.abs(arr[i]-arr[i-1]);
            int right = Integer.MAX_VALUE;

            if(i>1){
                right = prev2 + Math.abs(arr[i]-arr[i-2]);
            }
            int curr = Math.min(left,right);

            // update prev and prev2 for next iteration
            prev2=prev;
            prev=curr;
        }

        
    }
}