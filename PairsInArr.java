import java .util.*;
public class PairsInArr {
    public static void printPairsInArr(int arr[]){
        int tp=0;
        System.out.println("The pairs In Array is : ");
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("(" + arr[i] + "," +arr[j] +")");
                tp++;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Total pairs in array is : " +tp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int arr_size=sc.nextInt();
        int arr[]=new int[arr_size];
        System.out.print("Enter the element of the array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printPairsInArr(arr);
        sc.close();

    }
    
}
