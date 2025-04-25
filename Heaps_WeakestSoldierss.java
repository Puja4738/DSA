import java.util.PriorityQueue;

public class Heaps_WeakestSoldierss {
    static class Rows implements Comparable<Rows>{
        int soldiers;
        int idx;
        public Rows(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }
        public int compareTo(Rows R2){
            if(this.soldiers==R2.soldiers){
                return this.idx-R2.idx;
            }else{
                return this.soldiers-R2.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int army[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0},
        };
        int k=2;
        PriorityQueue<Rows>pq=new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army.length;j++){
                count+=army[i][j]==1 ? 1 : 0;
            }
            pq.add(new Rows(count, i));
        }
        for(int i=0;i<k;i++){
            System.out.println(("R"+pq.remove().idx));
        }
    }
    
}
