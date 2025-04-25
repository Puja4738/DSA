import java.util.*;
public class Largest {
    public static int largestNo(int arr[]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
             }
            if(arr[i]<smallest){
                smallest=arr[i];
            }
        }
        System.out.println("Smallest value is: " +smallest);
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the sizev of the array : ");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of the array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int Largest=largestNo(arr);
        System.out.println("Largest Value is : " +Largest);
        sc.close();

    }
    
}
