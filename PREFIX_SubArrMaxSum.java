import java.util.*;
public class PREFIX_SubArrMaxSum {
    public static void printMaxSubArrSum(int arr[]){
        int tsp=0;
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        int prefix[]=new int [arr.length];
        prefix[0]=arr[0];
        // calculate prefix array 
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                 // calculate prefix sum
                currsum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                System.out.println("The sum of subarray : " +currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
                System.out.println();
                tsp++;
            }
        }
        System.out.println("The maximum sum of the subarray : " +maxsum);
        System.out.println("Total no. of subarray : " +tsp );
     }
    
 public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array  :");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the element of the array : ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printMaxSubArrSum(arr);
        sc.close();

    }
}
