public class Recurr_Factorial {
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        int Fnm1=factorial(n-1);
        int fn=n*Fnm1;
        return fn;
        
    }
    
    public static void main(String[] args) {
        int n=5;
        int factorial=factorial(n);
        System.out.println("Factorial of " + n + ":" +factorial);
    }
    
}
