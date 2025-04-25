public class Recurr_AscOrder {
    public static void printAsc(int n){
        if(n>10){
            return;
        }
        System.out.println(n);
        printAsc(n+1);
        
        // if(n==1){
        //     System.out.println(n);
        //     return;
        // }
        // printAsc(n-1);;
        // System.out.println(n);
    }
    public static void main(String[] args) {
        int n=1;
        printAsc(n);
    }
    
}
