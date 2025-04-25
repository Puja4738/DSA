import java.util.*;
import java.util.LinkedList;

// import javax.swing.event.InternalFrameAdapter;
public class Graph_CycleDetect_UndirectedGr_DFS {
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
    
    // function to create graph  -> V=7
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

    // function to create graph   -> V=6
    static void createGraph2(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // Add edges for vertex 4 (first in topological order)
        graph[4].add(new Edge(4, 0, 5));
        graph[4].add(new Edge(4, 1, 5));
        
        // Add edges for vertex 5 (second in topological order)
        graph[5].add(new Edge(5, 0, 5));
        graph[5].add(new Edge(5, 2, 5));
        
        // Add edges for vertex 0
        graph[0].add(new Edge(0, 2, 5));

        // Add edges for vertex 2
        graph[2].add(new Edge(2, 3, 5));

        // Add edges for vertex 3
        graph[3].add(new Edge(3, 1, 5));
            
        }

// function to create graph  -> V=7
    static void createGraph3(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // 0 -> vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // 1 -> vertex
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        // 2 -> vertex
        graph[2].add(new Edge(2, 4, 3));
        // 3 -> vertex
        graph[3].add(new Edge(3, 5, 1));
        // 4 -> vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        // 5 -> vertex
        graph[5].add(new Edge(5, 5, 0));
        
    }

    // function to create graph  -> V=5
    static void createGraph4(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // 0 -> vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // 1 -> vertex
        graph[1].add(new Edge(1, 2, -4));
        // 2 -> vertex
        graph[2].add(new Edge(2, 3, 2));
        // 3 -> vertex
        graph[3].add(new Edge(3, 4, 4));
        // 4 -> vertex
        graph[4].add(new Edge(4, 1, -1));
        
    }

    // function to create graph  -> V=5
    static void createGraph5(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // 0 -> vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        // 1 -> vertex
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        // 2 -> vertex
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        // 3 -> vertex
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 2, 15));
        
    }

    // DetectCycle function  ->  UnDirected Graph (Using DFS)
    public static boolean detectCycle(ArrayList<Edge>graph[]){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                if(detectCycleUtil(graph,visit,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],boolean visit[],int curr,int par){
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                // case-3
                if(detectCycleUtil(graph, visit, e.dest,curr)){
                    return true;
                } 
                // case-1
                else if(visit[e.dest] && e.dest!=par){
                    return true;
                }
                // case 2 -> do nothing -> continue
            }
        }
        return false;
    }

    // BiPartite Graph  -> (Graph Coloring)
    public static boolean biPartitie(ArrayList<Edge>[] graph){
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
             col[i]=-1;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            // if not visited or not given color
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e=graph[curr].get(i);
                        if(col[e.dest]==-1){
                            int nextCol=col[curr]==0?1:0;
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]) {
                            return false;

                        }
                    }
                }
            }
        }
        return true;
    }

    // DetectCycle function  ->  Directed Graph (Using Modified DFS)  ->  Not similar to UnDirected
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleUtil(graph, e.dest, vis, stack)){
                    return true;
                }
            }
        }
        stack[curr]=false;
        return false;
    }

    // Topological Sort (Using DFS)
    public static void topologicalSort_DFS(ArrayList<Edge>[] graph ){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalSortUtil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge>[] graph , int curr,boolean vis[], Stack<Integer>s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // Topological Sort (Using BFS)
    public static void calcInOrder(ArrayList<Edge>[] graph , int indegree[]){
        for(int i=0;i<graph.length;i++){
            int v=i;
            if (graph[i] != null) {
                for(int j=0;j<graph[v].size();j++){
                    Edge e=graph[v].get(j);
                    indegree[e.dest]++;
                }
            }
        }
    }

    public static void topologicalSort_BFS(ArrayList<Edge>[] graph ){
        int indegree[]=new int[graph.length];
        calcInOrder(graph,indegree);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }

            }
        }
        System.out.println();
    }

    // All Paths from src to target  -> O(V2)
    public static void printAllPaths( ArrayList<Edge>[] graph, int src,int dest,String path){
        if(src==dest){
            System.out.print(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e =graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+src+" -> ");
        }
    }

    // Dijkstra's Alogorithm
    static class Pair implements Comparable <Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }

        public int compareTo(Pair p2){
            return this.path-p2.path;
        }

    }
    public static void dijkastrs(ArrayList<Edge>[] graph,int src){
        int dist[]=new int [graph.length];
        for(int i=0;i<graph.length;i++){
            if(i !=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt < dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    
   // Bellman-Ford Algorithm - Time Complexity: O(V * E)
   public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
    int dist[] = new int[graph.length];

    // Initialize distances to all vertices as infinite except the source
    for (int i = 0; i < dist.length; i++) {
        if (i != src) {
            dist[i] = Integer.MAX_VALUE; 
        } else {
            dist[i] = 0; // Source vertex distance is 0
        }
    }

    int V = graph.length; // Number of vertices

    // Relax all edges |V| - 1 times
    for (int i = 0; i < V - 1; i++) {
        for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Edge e = graph[j].get(k);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relax the edge
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
    }

    // Print the computed shortest distances
    for (int i = 0; i < dist.length; i++) {
        if (dist[i] == Integer.MAX_VALUE) {
            System.out.print("INF ");
        } else {
            System.out.print(dist[i] + " ");
        }
    }
    System.out.println();
}

// Prim's Algorithm
    static class pairs implements Comparable<pairs>{
        int vertex;
        int cost;
        public pairs(int v,int c){
            this.vertex=v;
            this.cost=c;
        }
        public int compareTo (pairs p2){
            return this.cost-p2.cost;
        }
    }
    public static void prims(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pairs>pq= new PriorityQueue<>();
        pq.add(new pairs(0, 0));
        int finalCost=0;
        while(! pq.isEmpty()){
            pairs curr=pq.remove();
            if(! vis[curr.vertex]){
                vis[curr.vertex]=true;
                finalCost+=curr.cost;

                for(int i=0;i<graph[curr.vertex].size();i++){
                    Edge e=graph[curr.vertex].get(i);
                    pq.add(new pairs(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }






    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph5(graph);

// createGraph  -> 1
        // boolean hasCycle = detectCycle(graph);
        // if (hasCycle) {
        //     System.out.println("Cycle detected!");
        // } else {
        //     System.out.println("No cycle detected.");
        // }

// createGraph  -> 1
        // System.out.println(biPartitie(graph));

// createGraph  -> 1
        // System.out.println(isCycle(graph));

// createGraph  -> 2
        // topologicalSort_DFS(graph);

// createGraph  -> 2
        // topologicalSort_BFS(graph);

    // createGraph  -> 2
    //     int src=5;
    //     int dest=1;
    //     printAllPaths(graph, src, dest, "");

// createGraph  -> 3
    //     int src=0;
   //      dijkastrs(graph, V); .

// createGraph  -> 4
           bellmanFord(graph, 0);

// createGraph  -> 5
           prims(graph);
         
            



    }
    
}
