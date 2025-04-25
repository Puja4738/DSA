import java.util.*;
public class Graph_KruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
        public int compareTo (Edge e2){
            return this.wt-e2.wt;
        }
    }
    static void craeteGraph(ArrayList<Edge>edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 0, 10));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 0, 15));
        edges.add(new Edge(2, 3, 50));
        edges.add(new Edge(3, 0, 30));
        edges.add(new Edge(3, 1, 40));
        edges.add(new Edge(3, 2, 50));

    }
    static int n=4;
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

    public static void kruskalsAlgo(ArrayList<Edge>edges,int V){
        init();
        Collections.sort(edges);
        int mstCost=0;
        int count=0;
        for(int i=0;count<V-1;i++){
            Edge e=edges.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){
                union(e.src, e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    } 

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>edges= new ArrayList<>();
        craeteGraph(edges);
        kruskalsAlgo(edges, V);

    }
    
}
