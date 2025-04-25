import java.util.*;
public class HashMap_LinkedHAshMap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer>lhm=new LinkedHashMap<>();
        lhm.put("China", 150);
        lhm.put("India", 100);
        lhm.put("Us", 50);

        System.out.println(lhm);

        TreeMap<String ,Integer>tm=new TreeMap<>();
        tm.put("China", 150);
        tm.put("Africa", 210);
        tm.put("India", 100);
        tm.put("Us", 50);

        System.out.println(tm);
    }
    
}
