import java.util.*;
public class Graph_TarjansBridge {
    static class Edge{
        int src;
        int dest;
        public Edge(int s , int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void craeteGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void dfs(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],int time,boolean vis[]){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par){
                continue;
            }else if(!vis[neigh]){
                dfs(graph, neigh, curr, dt, low, time, vis);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("Bridge = " +curr +" ----- " +neigh);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public static void tarjansBridge(ArrayList<Edge>graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<V;i++){
            if(!vis[i]){
               dfs(graph, i, -1, dt, low, time, vis);
            }
        }
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]=new ArrayList[V];
        craeteGraph(graph);
        tarjansBridge(graph, V);
    }
    
}
