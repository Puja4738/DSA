public class Recurr_Permutation_String {
    public static void printPermutation(String str,String permutation){
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currchar=str.charAt(i);
            String NewStr=str.substring(0, i)+str.substring(i+1, str.length());
            printPermutation(NewStr, permutation+currchar);
        }
    }
    public static void main(String[] args) {
        String str="abc";
        printPermutation(str, "");
    }
    
}

// Time complexity = O(n!)
