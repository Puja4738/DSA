// import java.lang.reflect.Array;
import java.util.*;
public class Greedy_ActivitySelection_EndTimeNotSorted {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // End time basis not sorted
        int activites[][]=new int[end.length][3];
        for(int i=0;i<end.length;i++){
            activites[i][0]=i;
            activites[i][1]=start[i];
            activites[i][2]=end[i];
        }
        // Lambda funtion to sortbthe array
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
        // End time basis sorted
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();
        // 1st activity seleted
        maxAct=1;
        ans.add(activites[0][0]);
        int lastEnd=activites[0][2];

        for(int i=0;i<end.length;i++){
            if(activites[i][1]>=lastEnd){
                maxAct++;
                ans.add(activites[i][0]);
                lastEnd=activites[i][2];
            }
        }
        System.out.println("Max Activites: " +maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i) +" ");
        }
        System.out.println();
    }
}
