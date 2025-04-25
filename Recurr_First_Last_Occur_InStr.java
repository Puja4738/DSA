public class Recurr_First_Last_Occur_InStr {
    public static int FirstOccur=-1;
    public static int  LastOccur=-1;
    public static void firstLastOccur(String str , char element , int idx){
        if(idx==str.length()){
            System.out.println("First occurance " + element + " is : " +FirstOccur);
            System.out.println("Last occurance " + element + " is : " +LastOccur);
            return ;
        }
        char currchar=str.charAt(idx);
        if(currchar==element){
            if(FirstOccur==-1){
                FirstOccur=idx;
            } else{
                LastOccur=idx;
            }
        }
        firstLastOccur(str, element, idx+1);
    }
    public static void main(String[] args) {
        String str="abaeacdaefaah";
        char element='e';
        firstLastOccur(str, element,0);
    }
    
}
