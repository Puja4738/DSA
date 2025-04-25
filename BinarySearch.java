import java.util.*;
public class BinarySearch {
    public static int binarysrch(int arr[],int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            } 
            else if(arr[mid]<key){
                start=mid+1;
            } else{
                end=mid-1;
             }

        }
        return -1;
    }
 public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("ENter the size of the array :");
        int arr_size=sc.nextInt();
        int arr[]=new int[arr_size];
        System.out.print("Enter the element of the array: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("ENter the searched key element : ");
        int key=sc.nextInt();

        int index=binarysrch(arr, key);
        if(index==-1){
            System.out.println("Element Not Found ! ");
        } else{
            System.out.println("Element is the found at index : " +index);
        }
        sc.close();
    }
}

// time complexity=O(logn)
