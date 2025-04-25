// import java.util.*;
public class DP_LCS {
    // Longest Common Subsequense Using Recursion   ->  O(2^n)
    public static int recurrLCS(String str1,String str2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return recurrLCS(str1, str2, n-1, m-1)+1;
        }else{
            return Math.max(recurrLCS(str1, str2, n-1, m),recurrLCS(str1, str2, n, m-1));
        }
    }

    // Longest Common Subsequense Using Memoization   ->  O(n)
    public static int memoizLCS(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!= -1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            dp[n][m]= memoizLCS(str1, str2, n-1, m-1, dp)+1;
            return dp[n][m];
        }else{
            int ans1=memoizLCS(str1, str2, n-1, m, dp);
            int ans2=memoizLCS(str1, str2, ans1, m-1, dp);
            dp[n][m]= Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    // Longest Common Subsequense Using Tabulation   ->  O(n)
    public static int tabuLCS(String str1,String str2,int n,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }



    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        int n=str1.length();
        int m=str2.length();

        // System.out.println(recurrLCS(str1, str2, n, m));

        // int dp[][]=new int[n+1][m+1];
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(memoizLCS(str1, str2, n, m, dp));

        System.out.println(tabuLCS(str1, str2, n, m));
    }
    
}
