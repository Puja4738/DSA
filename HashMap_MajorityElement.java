import java.util.*;
public class HashMap_MajorityElement {
    public static void main(String[] args) {
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            //  map.put(arr[i],map.getOrDefault(arr[i],0)+1);      or, 
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        // for(Integer key : map.keySet()){}  or, 
        Set<Integer>keySet=map.keySet();
        for(Integer key: keySet){
            if(map.get(key)>arr.length/3){
                System.out.println("THe majorirty of element : " +key);
            }
        }
    }
    
}
