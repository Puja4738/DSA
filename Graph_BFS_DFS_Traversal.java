import java.util.*;
import java.util.LinkedList;
public class Graph_BFS_DFS_Traversal {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    // function to create graph
    static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // 0 -> vertex
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 5));
        // 1 -> vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 5));
        // 2 -> vertex
        graph[2].add(new Edge(2, 0, 5));
        graph[2].add(new Edge(2, 4, 5));
        // 3 -> vertex
        graph[3].add(new Edge(3, 1, 5));
        graph[3].add(new Edge(3, 4, 5));
        graph[3].add(new Edge(3, 5, 5));
        // 4 -> vertex
        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 5));
        graph[4].add(new Edge(4, 5, 5));
        // 5 -> vertex
        graph[5].add(new Edge(5, 3, 5));
        graph[5].add(new Edge(5, 4, 5));
        graph[5].add(new Edge(5, 6, 5));
        // 6 -> vertex
        graph[6].add(new Edge(6, 5, 5));
    }

    // function of bfs
    public static void bfs(ArrayList<Edge>graph[]){
        boolean visit[]=new boolean[graph.length];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visit[curr]){
                System.out.print(curr+" ");
                visit[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Finction of dfs
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean visit[]){
        
        System.out.print(curr+" "); 
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                dfs(graph,e.dest,visit);
            }
        }
    }

    // HasPath function
    public static boolean hasPath(ArrayList<Edge>graph[],int src,int dest,boolean visit[]){
        if(src==dest){
            return true;
        }
        visit[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visit[e.dest] && hasPath(graph, e.dest, dest, visit)){
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        int V=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // bfs(graph);

        // dfs(graph, 0,new boolean[V]);

        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
        
    }
    
}
