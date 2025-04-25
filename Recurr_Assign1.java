public class Recurr_Assign1 {
    public static void findOccurances(int arr[],int i,int key){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.println(i +" ");
        }
        findOccurances(arr, i+1, key);
    }
    public static void main(String[] args) {
        int arr[]={3,2,4,5,6,2,7,2,2};
        int key =2;
        findOccurances(arr, 0, key);
    }
    
}
