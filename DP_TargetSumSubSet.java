public class DP_TargetSumSubSet {
    // Target Sum SubSet using Tabulation   ->  O(n)
    public static boolean targetSumSubSet(int num[],int sum){
        int n=num.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]= true;
        }
        for(int j=0;j<sum+1;j++){
            dp[0][j]=false;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(num[i-1]<=j){
                    if(dp[i-1][j-num[i-1]]==true){
                        dp[i][j]=true;
                    }else if(dp[i-1][j]==true) {
                        dp[i][j]=true;
                    }
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num[]={4,2,7,1,3};
        int target=10;
        System.out.println(targetSumSubSet(num, target));
    }
    
}
