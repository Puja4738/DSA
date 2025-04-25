// import java.util.*;
public class Recurr_DesOrder {
    public static void printDes(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDes(n-1);
    }
    public static void main(String[] args) {
        int n=10;
        printDes(n);
    }
    
}
