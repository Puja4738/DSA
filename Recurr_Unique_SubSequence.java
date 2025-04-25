import java.util.HashSet;

public class Recurr_Unique_SubSequence {
    public static void uniqueSubSequence(String str,int idx,String newStr,HashSet<String>Set){
        if(idx==str.length()){
            if(Set.contains(newStr)){
                return;
            } else{
                System.out.println(newStr);
                Set.add(newStr);
                return;
            }
        }
        char currChar=str.charAt(idx);
        // character to be choose
        uniqueSubSequence(str, idx+1, newStr+currChar, Set);
        // character not to be choose
        uniqueSubSequence(str, idx+1, newStr, Set);
    }
    public static void main(String[] args) {
        String str="aaa";
        HashSet<String> Set =new HashSet<>();
        uniqueSubSequence(str, 0, "",Set);
    }
    
}
