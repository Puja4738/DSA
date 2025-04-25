import java.util.*;
public class Input2D_Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        
        //  Ask the user for tre dimension of the array
        System.out.print("Enter the number of rows in 2D array : ");
        int rows=sc.nextInt();
        System.out.print("Enter the number of columns in 2D array : ");
        int columns=sc.nextInt();

        // Create the 2D array 
        int arr[][]=new int [rows] [columns];

        System.out.println("Enter the elements of the 2D array : ");

        //  Input the array 
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                 System.out.print("Enter element at position [ "  +i + "] [ " +j +" ] : ");
                arr[i] [j]=sc.nextInt();
            }
        }
        // output the array 
        System.out.println("The enterd 2D array : ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns ;j++){
                System.out.print(arr[i] [j] +" ");
            }
            System.out.println();
        }
        sc.close();

    }
}
