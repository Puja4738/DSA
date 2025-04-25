public class Recurr_SortedArr {
    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
        
    }
    public static void main(String[] args) {
        int arr[]={1,2,8,4,5};
        int i=arr[0];
        boolean sorted=isSorted(arr, i);
        System.out.println("The given array is " +sorted);
    }
    
}
