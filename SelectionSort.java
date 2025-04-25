import java.util.*;
public class SelectionSort {
    public static void printSelectionSort(int arr[]){
        // int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int smallest=i;
            for(int j=i+1;j<=arr.length-1;j++){
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the size of the array : ");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of the array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printSelectionSort(arr);
        System.out.print("The sorted array : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
    
}
