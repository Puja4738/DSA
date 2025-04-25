public class DP_MountainRanges {
    public static int mountainRanges(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int insiderange=dp[j];
                int outsiderange=dp[i-j-1];
                dp[i]+=insiderange*outsiderange;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(mountainRanges(n));
        
    }
    
}
