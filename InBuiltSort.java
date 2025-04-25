import java .util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class InBuiltSort {
    public static void printArr(Integer arr[]){
        System.out.print("The sorted Array : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int arr_size=sc.nextInt();
        Integer arr[]=new Integer [arr_size];
        System.out.print("ENter the elment of the array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        // to sort array 
        // Arrays.sort(arr);

        // to sort a part of the arr in the arr 
        // Arrays.sort(arr,0,3);

        // to sort arr in reverse order
        // Arrays.sort(arr,Collections.reverseOrder());

        // to sort a part of the arr in the arr in reverseOrder()
        Arrays.sort(arr, 0 ,3 ,Collections.reverseOrder());

        // print array 
        printArr(arr);

        sc.close();

    }
    
}
