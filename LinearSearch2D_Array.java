import java .util.*;
public class LinearSearch2D_Array {
    public static boolean linearSearch2D_Arr(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("Element is found at index : ( " +i +","+j+ ") " );
                    return true;
                } 
            }
        }
        System.out.println("Element not found : ");
        return false;
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
        System.out.print("Enter the search key element : ");
        int key=sc.nextInt();

        // print array 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix [i][j] + " ");
            }
            System.out.println();
        }
        linearSearch2D_Arr(matrix,key);
        sc.close();
    }
    
}
