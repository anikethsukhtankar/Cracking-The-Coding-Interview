package treesandgraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    public Graph(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    public void DFS(){
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                DFSUtil(i,visited);
            }
        }
    }

    public void DFS(int u){
        boolean[] visited = new boolean[V];
        DFSUtil(u,visited);
        for(int i=0; i<V; i++){
            if(!visited[i]){
                DFSUtil(i,visited);
            }
        }
    }

    private void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i+" ");

        Iterator<Integer> li = adj[i].listIterator();
        while(li.hasNext()){
            int n = li.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }

    public void BFS(int u){
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[u] = true;
        q.add(u);
        while(!q.isEmpty()){
            u = q.poll();
            System.out.print(u+" ");
            Iterator<Integer> li = adj[u].listIterator();
            while(li.hasNext()){
                int n = li.next();
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.BFS(2);
        System.out.println();
        g.DFS(2);
    }
}
