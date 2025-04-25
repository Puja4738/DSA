public class Recurr_Sumof_Naturalno {
    public static int printSomofNaturalNo(int n){
        if(n==1){
            return 1;
        }
        int Snm1=printSomofNaturalNo(n-1);
        int Sn=n+Snm1;
        return Sn;

    }
    public static void main(String[] args) {
        int n=5;
        int sum=printSomofNaturalNo(n);
        System.out.println("The sum of first " +n +"natural no. : " +sum);
    }
    
}
