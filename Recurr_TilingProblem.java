public class Recurr_TilingProblem {
    public static int tilingProblem(int n){
        // basecase
        if (n==0 || n==1) {
            return 1;
        }
        // vertical choice
        int fnm1=tilingProblem(n-1);
        // horizontal choice
        int fnm2=tilingProblem(n-2);
        // total ways
        int totalways=fnm1+fnm2;
        return totalways;
    }

    // public static int placeTiles(int n,int m){
    //     if(n==m){
    //         return 2;
    //     }
    //     if(n<m){
    //         return 1;
    //     }
    //     int verPlacements=placeTiles(n-m, m);
    //     int horPlacements=placeTiles(n-1, m);
    //     return verPlacements+horPlacements;
    // }
    
    public static void main(String[] args) {
        System.out.println("The total no. of ways of tiling board : " +tilingProblem(4));
        
    }
    
}
