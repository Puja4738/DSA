import java.util.*;
public class HashMap_JCF {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        // Insert  ->O(1)
        map.put("China", 150);
        map.put("India", 100);
        map.put("Us", 50);

        System.out.println(map);

        // Get  ->O(1)
        int population=map.get("India");
        System.out.println(population);
        System.out.println(map.get("Indonesia"));

        // ContainsKey  ->O(1);
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Indonesia"));

        // Remove  -> O(1)
        System.out.println(map.remove("China"));
        System.out.println(map);
        System.out.println(map.remove("Indonesia"));
        System.out.println(map);

        // size  -> O(1)
        System.out.println(map.size());

        // IsEmpty  -> O(1)
        System.out.println(map.isEmpty());

        // clear  -> O(1)
        map.clear();
        System.out.println(map.isEmpty());


    }
    
}
