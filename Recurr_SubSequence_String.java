public class Recurr_SubSequence_String {
    public static void subsequenceOfStr(String str,int idx,String newStr){
        if(idx==str.length()){
            System.out.println(newStr);
            return ;
        }
        char currChar=str.charAt(idx);
        // char to be use
        subsequenceOfStr(str, idx+1, newStr+currChar);
        // char not to be use
        subsequenceOfStr(str, idx+1, newStr);
    }
    public static void main(String[] args) {
        String str="abc";
        subsequenceOfStr(str, 0, "");
    }
    
}
