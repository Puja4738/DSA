public class Recurr_LastOccurElem_Arr {
    public static int lastOccurance(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isfound=lastOccurance(arr, key, i+2);
        if(isfound==-1 && arr[i]==key){
            return i;
        }
        return isfound;
    }
    public static void main(String[] args) {
        int arr[]={3,5,7,3,8,5,9,8,3,8,9,7};
        int key=9;
        int Lastoccurance=lastOccurance(arr,key,0);
        System.out.println("The last occurance of " +key + ":" +Lastoccurance);
    }
    
}
