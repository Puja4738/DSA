public class REcurr_Friends_Pairing {
    public static int friendspairing(int n){
        if(n==1 || n==2){
            return n;
        }
        // choics - single
        int fnm1 = friendspairing(n-1);
        // Pair
        int fnm2 = friendspairing(n-2);
        int pairways = (n-1) * fnm2;
        // total ways
        int totWays=fnm1+pairways;
        return totWays;
        
        // or second ways
        // return friendspairing(n-1)+(n-1)*friendspairing(n-2);
    }
    public static void main(String[] args) {
        System.out.println("The total no of ways friends can remain single or pair : " +friendspairing(7));
        
    }
    
}
