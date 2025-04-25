import java.util.*;
public class BubbleSort {
    public static void sortedArrBubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            // for sorted array
            // int swap=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    // swap++;
                }
            }
            // System.out.println("Total no. of swaps : " +swap);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the size of the array :");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of teh array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        sortedArrBubbleSort(arr);
        // print sorted array
        System.out.println("The Sorted array : "); 
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" " );
        }
        sc.close();
    }
}

// Time complexity = O(n2)
