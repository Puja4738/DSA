import java .util.*;
public class Arr2D_Assign2 {
    public static int sum2ndRowIn2D(int matrix[][]){
        int sum=0;
        for(int j=0;j<matrix[0].length;j++){
            sum+=matrix[1][j];
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][]=new int [3][3];
        int n=matrix.length;
        int m=matrix[0].length;
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the element of the array : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int sum=sum2ndRowIn2D(matrix);
        System.out.println("The sum of 2nd Row in 2D array : " +sum);
        sc.close();
    }
    
}
