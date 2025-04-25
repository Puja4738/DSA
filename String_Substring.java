public class String_Substring {
    public static String printSubstring(String str,int si,int ei){
        String substr=" ";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
  
    }
    public static void main(String[] args) {
        String str="HelloWorld";
        System.out.println(printSubstring(str, 0 , 5));

        // INBUILT FUNCTION to print substring 

        // System.out.println(str.substring(0,5));
    }
    
}
