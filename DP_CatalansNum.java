// import java.util.*;
public class DP_CatalansNum {
    // Catalan Number using Recurrision
    public static int catalanRecurr(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanRecurr(i)*catalanRecurr(n-i-1);
        }
        return ans;
    }
    // Catalan Number using Memoization
    public static int catalanMemoi(int n , int dp[]){
        if(n==0 || n==1){
            return 1 ;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanMemoi(i, dp)*catalanMemoi(n-i-1,dp);
        }
        return ans;
    }
    // Catalan Number using Tabulation
    public static int catalanTabu(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n=4;

        // System.out.println(catalanRecurr(n));

        // int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMemoi(n, dp));

        System.out.println( catalanTabu(n));
    }
    
}
