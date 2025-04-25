import java.util.*;
public class Arr2D_Assign1 {
    public static int printCountIn2D(int matrix[][],int target){
        int count =0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int matrix[][]=new int [2][3];
        int n=matrix.length;
        int m=matrix[0].length;
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the element of the array : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the search key element : ");
        int target=sc.nextInt();
        int count=printCountIn2D(matrix,target);
        System.out.println("No. of "+target + "in 2D array :"+count);
        sc.close();
    }
    
}
