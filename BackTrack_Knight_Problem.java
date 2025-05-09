public class BackTrack_Knight_Problem {
    static int N=8;
    static int xMove[]={2,1,-1,-2,-2,-1,1,2};
    static int yMove[]={1,2,2,1,-1,-2,-2,-1};

    public static boolean issafe(int x,int y,int sol[][]){
        return (x>=0 && x<N &&y >=0 && y<N && sol[x][y]==-1);
    }
    public static void printSolution(int sol[][]){
        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
                System.out.print(sol[x][y] +" ");
            }
            System.out.println();
        }
    }
    public static boolean solveKnight(){
        int sol[][]=new int [N][N];
        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
                sol[x][y]=-1;
            }
        }
            
        sol[0][0]=0;

        if(solveKTUtil(0,0,1,sol,xMove,yMove)){
            printSolution(sol);
            return true;
        } else{
            System.out.println("Solution doesn't exist: ");
            return false;
        }
    }
    public static boolean solveKTUtil(int x,int y,int movei,int sol[][],int xMove[],int yMove[]){
        int k,next_x,next_y;
        if(movei==N*N){
            return true;
        }
        for(k=0;k<8;k++){
            next_x=x+xMove[k];
            next_y=y+yMove[k];
            if(issafe(next_x, next_y, sol)){
                sol[next_x][next_y]=movei;
                if(solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove)){
                    return true;
                }else{
                    sol[next_x][next_y]=-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        solveKnight();
    }
}
