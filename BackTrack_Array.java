public class BackTrack_Array {
    public static void changeArr(int arr[],int idx,int value){
        if(idx==arr.length){
            printArr(arr);
            return;
        }
        arr[idx]=value;
        changeArr(arr, idx+1, value+1);
        arr[idx]=arr[idx]-2;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
    
}
