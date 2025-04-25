public class Recurr_Assign2 {
    public static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void convertNumIntoStr(int num){
        if(num==0){
            return;
        }
        int lastDigit=num%10;
        convertNumIntoStr(num/10);
        System.out.print(digits[lastDigit]+" ");

    }
    public static void main(String[] args) {
        int num=1234;
        convertNumIntoStr(num);

    }
    
}
