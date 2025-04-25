public class DP_CountingTrees {
    public static int countBSTs(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int leftBSTs=dp[j];
                int rightBSTs=dp[i-j-1];
                dp[i]+= leftBSTs*rightBSTs;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(countBSTs(n));
    }
    
}
