public class BackTrack_N_Queen {

    public static boolean isSafe(char board[][],int row,int col){
        // vertical up check
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // Left diagonal up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Right diagonal up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][],int row){
        // Basecase
        if(row==board.length){
            count ++;
            printBoard(board);
            return;
        }
        // Column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                nQueens(board, row+1);
                board[row][j]='X';
            }
        }
    }   
    
    // Problem can be solved or not & print 1 soln:-----

    // public static boolean nQueen(char board[][],int row){
    //     // Basecase
    //     if(row==board.length){
    //         count ++;
    //         return true;
    //     }
    //     // Column loop
    //     for(int j=0;j<board.length;j++){
    //         if(isSafe(board, row, j)){
    //             board[row][j]='Q';
    //             if(nQueen(board, row+1)) {
    //                 return true;
    //             }
    //             board[row][j]='X';
    //         }
    //     }
    //     return false;
    // }

    public static void printBoard(char board[][]){
        System.out.println("--------Chess Board ---------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
    // To count total ways to solve nQueen Problem
    static int count =0;
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char[n][n];
        // initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        nQueens(board, 0);
        System.out.println("Total ways to solve nQueen Problem : " +count);

        // if(nQueen(board,0)){
        //     System.out.println("Solution is possible ");
        //     printBoard(board);
        // } else{
        //     System.out.println("Solution is not possible");
        // }
    }
}

// Time complexity =O(n!)
