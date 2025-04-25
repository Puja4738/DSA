public class DP_KnapSack {
    // 0-1 Knapsack using recursion   ->  O(2^n)
    public static int knapSack(int val[],int wt[],int W,int n){
        if(W==0 || n==0){
            return 0;
        }
        // valid Condition
        if(wt[n-1]<=W){
            // Valid+include
            int max1=val[n-1]+knapSack(val, wt, W-wt[n-1], n-1);
            // Valid  + Exclude
            int max2=knapSack(val, wt, W, n-1);
            return Math.max(max1,max2);
        }else{
            // Invalid + Exclude
            return knapSack(val, wt, W, n-1);
        }
    }
    
    // 0-1 Knapsack using memoization   ->  O(n)
    public static int knapSackMemoi(int val[],int wt[],int W,int n,int dp[][]){
        if(W==0 || n==0){
            return 0;
        }
        // Memoization
        if(dp[n][W]!= -1){
            return dp[n][W];
        }
        // valid+include
        if(wt[n-1]<=W){
            int max1=val[n-1]+knapSackMemoi(val, wt, W-wt[n-1], n-1, dp);
            // valid+Exclude
            int max2=knapSackMemoi(val, wt, W, n-1, dp);
            dp[n][W]=Math.max(max1,max2);
            return dp[n][W];
        }else{
            // Invalid+Exclude
            dp[n][W]=knapSack(val, wt, W, n-1);
            return dp[n][W];
        }
    }
    // 0-1 Knapsack using Tabulation   ->  O(n)
    public static int knapSackTab(int val[],int wt[],int W){
        int n=val.length;
        // Initialization
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp.length;j++){
            dp[0][j]=0;
        }
        // Tabulation
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                // valid+include
                if(wt[i-1]<=j){
                    int ans1=val[i-1]+dp[i-1][j-wt[i-1]];
                    // valid+Exclude
                    int ans2=dp[i-1][j];
                    dp[i][j]= Math.max(ans1,ans2);
                }else{
                    // Invalid+Exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 







    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        // System.out.println(knapSack(val, wt, W, val.length));

        // System.out.println(knapSackMemoi(val, wt, W, val.length, dp));

        System.out.println(knapSackTab(val, wt, W));
    }
    
}
