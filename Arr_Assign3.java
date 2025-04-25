import java.util.*;
public class Arr_Assign3 {
    public static int printMaxPrice(int prices[]){
        int buyprice=Integer.MAX_VALUE;
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                max_profit=Math.max(max_profit,profit);
               
            } else{
                buyprice=prices[i];
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arr_size = sc.nextInt();
        int prices[] = new int[arr_size];
        System.out.println("Enter the elements of the price in array: ");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }
        int maximumprofit = printMaxPrice(prices);
        System.out.println("The Maximum profit is " +maximumprofit);
        sc.close();
    }
    
}
