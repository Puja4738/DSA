import java.util.*;
public class Greedy_JobSequencing {
    static class job{
        int deadline;
        int profit;
        int id;
        public job(int i,int d,int p){
            this.id=i;
            this.deadline=d;
            this.profit=p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<job>newJobs=new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++){
            newJobs.add(new job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        Collections.sort(newJobs,(obj1,obj2) -> obj2.profit-obj1.profit);
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<newJobs.size();i++){
            job curr=newJobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Max job : " +seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print("Job " +seq.get(i) +" ");
        }
        System.out.println();
        
    }
    
}
