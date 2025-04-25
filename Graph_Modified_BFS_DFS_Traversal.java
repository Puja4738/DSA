import java.util.*;
public class Graph_Modified_BFS_DFS_Traversal {
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

    // Modified bfs  -> for Disjoint Components
    public static void bfs(ArrayList<Edge>graph[]){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                bfsUtil(graph,visit);
            }
        }
    }
    // Utility function of bfs
    public static void bfsUtil(ArrayList<Edge>graph[],boolean visit[]){
    
        Queue<Integer>q=new ArrayDeque<>();
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

    // Modified dfs -> for Disjoint Components
    public static void dfs(ArrayList<Edge>graph[]){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                dfsUtil(graph,i,visit);
            }
        }
    }
    // Utility function of dfs
    public static void dfsUtil(ArrayList<Edge>graph[],int curr,boolean visit[]){
        
        System.out.print(curr+" "); 
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                dfsUtil(graph,e.dest,visit);
            }
        }
    }


    public static void main(String[] args) {
        int V=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // bfs(graph);

        dfs(graph);
        
    }
    
}
