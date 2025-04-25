public class CharAt_String {
    public static void printCharacter(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i) +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str="Puja Kumari";
        printCharacter(str);
    }
    
}
