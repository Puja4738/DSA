// import java .util.*;
public class Graph_DisJointSetDS {
    static int n=8;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(parA==parB){
            return;
        }
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        } else if(rank[parB]<rank[parA]){
            par[parB]=parA;
        }else{
            par[parA]=parB;
        }
    }

    public static void printParents() {
        System.out.print("Parents: ");
        for (int i = 0; i < n; i++) {
            System.out.print(par[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        init();
        union(1, 3);
        printParents();
        find(3);
        printParents();
        union(2, 4);
        printParents();
        union(3, 6);
        printParents();
        union(1, 4);
        printParents();
        find(3);
        printParents();
        union(1, 5);
        printParents();
    }
    
}
