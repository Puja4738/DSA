import java.util.*;
public class Binary_Search_Aggressive_Cows {
    
    public static int findAggressiveCows(int arr[],int cows){
        Arrays.sort(arr);
        int n=arr.length;
        int start=0;
        int end=arr[n-1]-arr[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(canWePlaceCows(arr,mid,cows)==true){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
    public static boolean canWePlaceCows(int arr[],int mindist,int cows){
        int cntCows=1;
        int n=arr.length;
        int lastCowPlace=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-lastCowPlace >= mindist){
                cntCows++;
                lastCowPlace=arr[i];
            }
        }
        if(cntCows >= cows){
            return true;
        }else{
            return false;
        }
    }




    public static void main(String[] args) {
        int stalls[]={0,3,4,7,9,10};
        int cows=4;
        int ans= findAggressiveCows(stalls,cows);
        System.out.println(ans);
    }
}


