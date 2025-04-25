public class DP_EditDistance {
    public static int editDistance(String word1,String word2){
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        // Initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                // if str1==0  , insert lengthof str2
                if(i==0){    
                    dp[i][j]=j;
                }
                // if str2==0  , delete lengthof str1
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    // add-> [i][j-1]  ;  delete-> [i-1][j]  ; replace-> [i-1][j-1]
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1="intention";
        String word2="execution";
        System.out.println(editDistance(word1, word2));
    }
    
}
