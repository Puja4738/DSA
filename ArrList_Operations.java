import java.util.ArrayList;
public class ArrList_Operations {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        // Add operation O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
        // O(n)
         list.add(1,8); 

        System.out.println(list);

        // Get operation O(1)
        int element=list.get(2);
        System.out.println(element);

        // Remove operation O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at index O(n)
        list.set(3,9);
        System.out.println(list);

        // contains operation
        System.out.println(list.contains(2));
        System.out.println(list.contains(11));
    }
    
}
