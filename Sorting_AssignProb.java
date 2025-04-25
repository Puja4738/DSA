import java.util.*;
public class Sorting_AssignProb {
    // Bubble sort
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    //Selection Sort
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]<arr[j]){
                    smallest=j;
                }
            }
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
        }
    }
     //Insertion sort
    public static void insertionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]<curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    // Counting sort
    public static void countingSortDescending(int arr[]) {
        // Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
    
        // Initialize count array with size largest+1
        int count[] = new int[largest + 1];
    
        // Populate the count array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
    
        // Sort the array using the count array in descending order
        int j = 0; // index for sorted array
        for (int i = count.length - 1; i >= 0; i--) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arr_size=sc.nextInt();
        int arr[]=new int[arr_size];
        System.out.print("Enter the elementt of the height :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        countingSortDescending(arr);
        System.out.print("The sorted array :");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
    
}
