public class Recurr_FibnoccaiSeries {
    public static int calcFib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int Fnm1=calcFib(n-1);
        int Fnm2=calcFib(n-2);
        int Fn=Fnm1+Fnm2;
        return Fn;
    }
    public static void main(String[] args) {
        int n=8;
        int fibonacci=calcFib(n);
        System.out.println("The Fibonacci of " +n + "th series : " +fibonacci);
    }
}
