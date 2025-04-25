import java.util.*;
public class BRUTE_SubArraySum {
    public static void printSubArrMaxSum(int arr[]){
        int currsum=0;
        int tsp=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currsum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k] +" ");
                    currsum+=arr[k];
                }
                tsp++;
                System.out.println();
                System.out.println("The sum of subArray is : " +currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }
            System.out.println();
        }
        System.out.println("The maximun sum among all the subArray is : "+maxsum);
        System.out.println("The total no. of sunArray pair is : " +tsp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the Array :");
        int arr_size=sc.nextInt();
        int arr[]=new int[arr_size];
        System.out.print("ENter the element of the Array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        printSubArrMaxSum(arr);
        sc.close();
    }
    
}
