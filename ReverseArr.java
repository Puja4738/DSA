import java.util.*;
public class ReverseArr {
    public static void reverseArray(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        start++;
        end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of the array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        } 
        reverseArray(arr);
        System.out.println("Reversed array is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        sc.close();
    }
    
}
