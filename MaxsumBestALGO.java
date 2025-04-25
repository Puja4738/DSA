import java.util.Scanner;

public class MaxsumBestALGO {
    public static void kadanesSubArrMaxSum(int arr[]){
        int tsp=0;
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum<0){
                currsum=0;
            }
            if(maxsum<currsum){
                maxsum=currsum;
            }
            tsp++;
            System.out.println("The sum of subarray : " +currsum);
            System.out.println("The current maxsum : " +maxsum);
        }
        System.out.println("The maximum sum of the subarray : " +maxsum);
        System.out.println("Total no. of subarray : " +tsp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the size of the array :");
        int arr_size=sc.nextInt();
        int arr[]=new int[arr_size];
        System.out.print("Enter the element of the array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        kadanesSubArrMaxSum(arr);
        sc.close();
        
    }
    
}
