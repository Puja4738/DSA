public class Recurr_Tower_of_Hanoi {
    public static void towerOfHanoi(int n,String src,String Helper,String dest){
        
        if(n==1){
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        // moves (n-1) disks from source to helper with help of destination as helper
        towerOfHanoi(n-1, src, dest, Helper);
        // rest 1 disk moves source to destination
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        // moves (n-1) disks from Helper to destination  with help of source as destination
        towerOfHanoi(n-1, Helper, src, dest);
        
    }
    public static void main(String[] args) {
        towerOfHanoi(3, "S", "H", "D");
        
    }
    
}
