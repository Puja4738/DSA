public class BackTrack_GridWays {
    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        } else if(i==n||j==m){
            return 0;
        }
        // Down move
        int ways1=gridWays(i+1, j, n, m);
        // Right move
        int ways2=gridWays(i, j+1, n, m);
        // Total ways
        return ways1+ways2;
    }
    public static void main(String[] args) {
        int n=3,m=3;
        System.out.println("Total ways to count path in maze :");
        System.out.print(gridWays(0, 0, n, m));
    }
    
}
