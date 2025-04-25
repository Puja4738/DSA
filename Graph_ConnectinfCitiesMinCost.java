import java.util.*;
public class Graph_ConnectinfCitiesMinCost {
    static class  Edge implements Comparable<Edge> {
        int vertex;
        int cost;
        public Edge(int v,int c){
            this.vertex=v;
            this.cost=c;
        }
        public int compareTo (Edge e2){
            return this.cost-e2.cost;
        }
    }
    public static int connectingCities(int cities[][]){
        boolean vis[]=new boolean[cities.length];
        PriorityQueue<Edge>pq=new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        int finalCost=0;
        while(! pq.isEmpty()){
            Edge curr=pq.remove();
            if(! vis[curr.vertex]){
                vis[curr.vertex]=true;
                finalCost+=curr.cost;
                for(int i=0;i<cities[curr.vertex].length;i++){
                    if(cities[curr.vertex][i] != 0){
                        pq.add(new Edge(i, cities[curr.vertex][i]));
                    }
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connectingCities(cities));
    }
    
}
