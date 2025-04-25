public class Recurr_XtoPower_n {
    public static int printXtoPowN(int x,int n){
        if(n==1){
            return x;
        }
        int xnm1=printXtoPowN(x,n-1);
        int xn=x*xnm1;
        return xn;

    }
    public static void main(String[] args) {
        int base=2;
        int power=5;
        int x_power_n=printXtoPowN(base, power);
        System.out.println("The x to power n " +x_power_n);
        }
    
}
