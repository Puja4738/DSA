import java.util.*;
public class Greedy_ActivitySelection {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // End time basis sorted
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();
        // 1st activites
        maxAct=1;  
        ans.add(0);
        int LastEnd=end[0];
        
        for(int i=0;i<end.length;i++){
            if(start[i]>=LastEnd){
                maxAct++;
                ans.add(i);
                LastEnd=end[i];
            }
        }
        System.out.println("Max Activitees performed : " +maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i) +" ");
        }
        System.out.println();
    }
    
}
