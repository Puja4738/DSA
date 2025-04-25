public class Recurr_Assign5 {
    public static void toweerOfHanoi(int n,String src,String Helper ,String Dest){
        if(n==1){
            System.out.println("moves disks" + n  + " from " +src + " to " +Dest);
            return;
        }
        // First moves (n-1) disks from source to helper with dest as helper
        toweerOfHanoi(n-1, src, Dest ,Helper);
        // Aftr that move 1 rest disk from source to dest 
        System.out.println("moves disks " + n + " from " +src +" to " +Dest);
        // After the moves (n-1) diska from helper to dest with src as helper
        toweerOfHanoi(n-1,Helper,src, Dest);
    }
    public static void main(String[] args) {
        toweerOfHanoi(3, "S" , "H" ,"D");
        
    }
}
