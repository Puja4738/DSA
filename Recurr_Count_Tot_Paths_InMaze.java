public class Recurr_Count_Tot_Paths_InMaze {
    public static int countPaths(int i,int j,int n,int m){
        // i,j =cell no.    ;  n, m=row conm no.
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i==n||j==m){
            return 0;
        }
        // move downwards or ways1
        int downPaths=countPaths(i+1, j, n, m);
        // move right or ways2
        int rightPaths=countPaths(i, j+1, n, m);
        // count total Paths
        int totalPaths=downPaths+rightPaths;
        return totalPaths;
    }
    public static void main(String[] args) {
        int n=3, m=3;
        System.out.println(countPaths(0, 0, n, m));
    }
    
}
