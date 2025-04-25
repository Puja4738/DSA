import java.util.*;
public class HashMap_HashSet {
    public static void main(String[] args) {
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(2);
        set.add(4);
        set.add(1);

        System.out.println(set);
// contains
        if(set.contains(2)){
            System.out.println("Set contains 2");
        }
        if(set.contains(3)){
            System.out.println("Set contain 3");
        }
// remove
        set.remove(2);
        if(set.contains(2)){
            System.out.println("Set contains 2");
        }
// clear
        set.clear();
// size
        System.out.println(set.size());
// isEmpty
        System.out.println(set.isEmpty());


    }
    
}
