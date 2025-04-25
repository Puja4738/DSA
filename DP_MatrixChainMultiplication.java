// import java.util.*;
public class DP_MatrixChainMultiplication {
    // Matrix chain multiplication using Recurrsion
    public static int mcmRecurr(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=mcmRecurr(arr, i, k);
            int cost2=mcmRecurr(arr, k+1, j);
            // Ai=arr[i-1]*arr[i] ; Ak=arr[k-1]*arr[k]   =>   arr[i-1]*arr[k]
            // Ak+1=arr[k]*arr[k+1] ; Aj=arr[j-1]*arr[j]   =>   arr[k]*arr[j]
            //          =>    arr[i-1]*arr[k]*arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;
            ans= Math.min(ans,finalCost);
        }
        return ans;
    }
    // Matrix chain multiplication using Memoization
    public static int mcmMemoi(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=mcmMemoi(arr, i, k, dp);
            int cost2=mcmMemoi(arr, k+1, j, dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans, finalCost);
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
    // Matrix chain multiplication using Tabulation
    public static int mcmTabu(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
    
        // Initialize the diagonal elements to 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
    
        // Tabulation from length 2 to n-1
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
    
        print(dp);
        return dp[1][n - 1];
    }
    
    public static void print(int dp[][]) {
        int n = dp.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " "); // Use print for same-line elements
            }
            System.out.println();
        }
        System.out.println();
    }
    



    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        // int n=arr.length;

        // System.out.println(mcmRecurr(arr, 1, n-1));

        // int dp[][]=new int[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // System.out.println(mcmMemoi(arr, 1, n-1, dp));

        System.out.println(mcmTabu(arr));
    }
    
}
