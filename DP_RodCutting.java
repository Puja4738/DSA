public class DP_RodCutting {
    public static int rodCutting(int len[],int price[],int L){
        int n=len.length;
        int dp[][]=new int[n+1][L+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<L+1;j++){
                dp[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<L+1;j++){
                if(len[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][L];
    }
    public static void main(String[] args) {
        int len[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int rodlength=8;
        System.out.println(rodCutting(len, price, rodlength));
    }
    
}
