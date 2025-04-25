import java.util.*;
public class BuyAndSellStock {
    public static int maxBuy$SellStock(int prices[]){
        // int buyprice=Integer.MAX_VALUE;
        int buyprice=prices[0];
        int max_profit=0;
        // selling price=prices[i]
        for(int i=0;i<prices.length;i++){
            // profit - case 1
            if(buyprice<prices[i]){  
                // today's profit
               int profit=prices[i]-buyprice;
            //    find maximum profit 
               max_profit=Math.max(max_profit,profit);
            } else{
                // In this day , we didn't sell the stock ;  we buy the stock :
                buyprice=prices[i];
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the price of stock : ");
        int price_size=sc.nextInt();
        int prices[]=new int[price_size];
        System.out.print("ENter the price of stock : ");
        for(int i=0;i<prices.length;i++){
            prices[i]=sc.nextInt();
        }
       int maximumprofit= maxBuy$SellStock(prices);
       System.out.println("The maximum profit of the stock : " +maximumprofit);
       sc.close();
    }

}
// Time complexitiy=O(n)
