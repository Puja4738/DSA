// import java.util.*;
public class DP_RecurrAllFibonacci {
    // Fibonacci using Recurision   ->   O(2^n)
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    // Fibonacci using Memoization     ->    O(n)
    public static int fibMemo(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fibMemo(n-1, dp)+fibMemo(n-2, dp);
        return dp[n];
    }

    // Fibonacci using Memoization + Iteration    ->    O(n)
    public static int fibTab(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[0]=0;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        // System.out.println(fib(n));

        System.out.println(fibMemo(n, dp));

        // System.out.println(fibTab(n));
    }
    
}
