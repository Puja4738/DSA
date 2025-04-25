import java.util.*;
public class InsertionSort {
    public static void printSelectionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i] ;
        // previous =j
            int prev=i-1; 
        // finding out the currect pos to insert 
        while (prev >= 0 && arr[prev] > curr) {
            arr[prev+1]=arr[prev];
            prev--;
        }
        // insertion or placement of element in correct pos
        arr[prev+1]=curr;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the elemenet of the array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printSelectionSort(arr);
        System.out.print("The sorted array : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        sc.close();
    }
}

// Time complexity = O(n2)
