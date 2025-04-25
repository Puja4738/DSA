import java.util.*;
public class Arr_Assign1 {
    public static boolean twicePrintTrue(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the size of the array :");
        int arr_size=sc.nextInt();
        int arr[]=new int [arr_size];
        System.out.print("Enter the elmenent of the array: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        if(twicePrintTrue(arr)){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
        sc.close();
    }
    
}

