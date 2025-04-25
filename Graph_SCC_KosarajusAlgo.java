import java.util.*;
public class Graph_SCC_KosarajusAlgo {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void craeteGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void topSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer>s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>transpose[],int curr,boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<transpose[curr].size();i++){
            Edge e=transpose[curr].get(i);
            if(!vis[e.dest]){
                dfs(transpose, e.dest, vis);
            }
        }
    }
    public static void kosarajusAlgo(ArrayList<Edge>graph[],int V){
        // Get nodes in stack(topological sort)
        Stack<Integer>s=new Stack<>();
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }
        // Transpose the graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>transpose[]=new ArrayList[V];
        for(int i=0;i<transpose.length;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<transpose[i].size();j++){
                Edge e=transpose[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        // step-3 perform DFS a/t stack nodes on the transpose graph
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.print("SCC: ");
                dfs(transpose, curr, vis);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]=new ArrayList[V];
        craeteGraph(graph);
        kosarajusAlgo(graph, V);
    }
    
}
