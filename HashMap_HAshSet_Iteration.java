import java.util.*;
public class HashMap_HAshSet_Iteration {
    public static void main(String[] args) {
        HashSet<String>cities=new HashSet<>();
        cities.add("Delhi");
        cities.add("Chennai");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Bihar");
        cities.add("Asam");
     
        // using iterartor
        // Iterator itr=cities.iterator();
        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }

        // or ,  using advanced for loop
        for(String city : cities){
            System.out.println(city);
        }



        // LINKed HAshSet
        LinkedHashSet<String>lhs=new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Chennai");
        lhs.add("Mumbai");
        lhs.add("Kolkata");
        lhs.add("Bihar");
        lhs.add("Asam");

        System.out.println(lhs);

        lhs.remove("Kolkata");
        System.out.println(lhs);


        // Tree HashSet
        TreeSet<String>ts=new TreeSet<>();
        ts.add("Delhi");
        ts.add("Chennai");
        ts.add("Mumbai");
        ts.add("Kolkata");
        ts.add("Bihar");
        ts.add("Asam");

        System.out.println(ts);

    }
    

    
}
