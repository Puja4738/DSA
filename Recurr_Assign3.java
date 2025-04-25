public class Recurr_Assign3 {
    public static int printLengthOfStr(String str){
        if(str.length()==0){
            return 0;
        }
        return printLengthOfStr(str.substring(1))+1;
    }
    public static void main(String[] args) {
        String str="abcde";
        System.out.println("The length of string : " +printLengthOfStr(str));
    }
    
}
