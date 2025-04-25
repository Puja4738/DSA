public class Recurr_Optimized_x_Power_n {
    public static int optimizedPower(int a,int n){
        if(n==0){
            return 1;
        }
        // when this line used time complexity O(n)
        // int halfPowerSq=optimizedPower(a, n/2)*optimizedPower(a, n/2);

        int halfPower=optimizedPower(a, n/2);
        // time complexityO(log n)
        int halfPowerSq=halfPower*halfPower;  

        // when  powern is odd 
        if(n%2!=0){
            return a*halfPowerSq;
        }
        // for even 
        return halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println("The x to power n is : "+optimizedPower(2, 5));
        
    }
    
}
