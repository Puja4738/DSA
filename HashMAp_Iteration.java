import java.util.*;
public class HashMAp_Iteration {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("China", 150);
        map.put("India", 100);
        map.put("Us", 50);

        Set<String>Keys=map.keySet();
        System.out.println(Keys);
        for(String K : Keys ){
            System.out.println("Key = " +K +" , value = " +map.get(K));
        }
    }
    
}
