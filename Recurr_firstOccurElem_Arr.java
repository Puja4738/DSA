public class Recurr_firstOccurElem_Arr {
    public static int firstoccurance(int arr[],int key ,int i){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstoccurance(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[]={3,4,6,1,8,4,7,4,5,2,5};
        int key =5;
        int FirstOccur=firstoccurance(arr, key, key);
        System.out.println("The first occurance of " +key + ":" + FirstOccur);
    }
    
}
