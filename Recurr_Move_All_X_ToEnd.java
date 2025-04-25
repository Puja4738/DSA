public class Recurr_Move_All_X_ToEnd {
    public static void moveAllXtoEnd(String str,int idx,String newStr,int count){
        if(idx==str.length()){
            for(int i=0;i<count;i++){
                newStr+='x';
            }
            System.out.println(newStr);
            return;
        }
        // kaam
        char currChar=str.charAt(idx);
        if(currChar=='x'){
            count ++;
            moveAllXtoEnd(str, idx+1, newStr, count);;
        } else{
            newStr+=currChar;
            moveAllXtoEnd(str, idx+1, newStr, count);;
        }
    }
    public static void main(String[] args) {
        String str="axbcxxd";
        moveAllXtoEnd(str, 0, "", 0);
        
    }
    
}
