public class Recurr_Binary_String {
    public static void printBinStrings(int n , int lastvalue,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        if(lastvalue==0){
            printBinStrings(n-1, 0, str+"0");
            printBinStrings(n-1, 1, str+"1");
        } else{
            printBinStrings(n-1, 0, str+"0");
        }

        // second method
        // printBinStrings(n-1, 0, str+"0");
        // if(lastvalue==0){
        //     printBinStrings(n-1, 1, str+"1");
        // }
    }
    public static void main(String[] args) {
        printBinStrings(3, 0, "");
        
    }
    
}
