public class Recurr_Assign4 {
    // Recursive function to count valid substrings
    public static int countSubstrings(String S, int start, int end) {
        if (start == S.length()) {
            return 0;
        }
        if (end == S.length()) {
            return countSubstrings(S, start + 1, start + 1);
        }
        int count = 0;
        if (S.charAt(start) == S.charAt(end)) {
            System.out.println(S.substring(start, end + 1) +" ");
            count++;
        }
        return count + countSubstrings(S, start, end + 1);
    }
    public static void main(String[] args) {
        String str = "abcab";
        System.out.println("THe total valid substring : " +countSubstrings(str, 0, 0));
       
    }
    
}
