// import java.util.*;
public class SpiralMatrix {
    public static void printSpiralMatrix(int matrix[][]){
        System.out.println("The key in the form of spiral matrix : ");
        int startrow=0;
        int startcolm=0;
        int endrow=matrix.length-1;
        int endcolm=matrix[0].length-1;

        while(startrow<=endrow && startcolm<=endcolm){
            // top (startrow is fixed)
            for(int j=startcolm;j<=endcolm;j++){
                System.out.print(matrix[startrow][j] +" ");
            }
            // right (endcolm is fixed)
            for(int i=startrow+1;i<=endrow;i++){
                System.out.print(matrix[i][endcolm] + " ");
            }
            // bottom (endrow is fixed)
            for(int j=endcolm-1;j>=startcolm;j--){
                if(startrow==endrow){
                    break;
                }
                System.out.print(matrix[endrow][j]+" ");
            }
            // left (startcolm is fixed)
            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcolm==endcolm){
                    break;
                }
                System.out.print(matrix[i][startcolm] +" ");
            }
            startrow++;
            endrow--;
            startcolm++;
            endcolm--;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiralMatrix(matrix);
    }
    
}
