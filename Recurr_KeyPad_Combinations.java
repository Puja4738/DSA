public class Recurr_KeyPad_Combinations {
    public static String keyPad[]={" ", " ", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void  keyPadCombinations(String str,int idx,String combinations){
        
        if(idx==str.length()){
            System.out.println(combinations);
            return;
        }
        char currChar=str.charAt(idx);
        // convert string into int
        String mapping=keyPad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            keyPadCombinations(str, idx+1, combinations+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        String str="23";
        keyPadCombinations(str, 0, "");
    }
    
}
