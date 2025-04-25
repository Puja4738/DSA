import java .util.*;
public class SubArray {
    public static void printSubArr(int arr[]) {
        int ts=0;
        System.out.println("The subarray of the array is : ");
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k] +" ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total no. of subarray is : " +ts);
    }   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the Array :");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of the array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printSubArr(arr);
        sc.close();

    }
    
}
