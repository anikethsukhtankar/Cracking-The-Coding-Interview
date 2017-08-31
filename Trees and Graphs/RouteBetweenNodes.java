package treesandgraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes{
    private int V;
    private LinkedList<Integer>[] adj;

    public RouteBetweenNodes(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    public boolean routeExists(int u, int w){
        if(u==w) return true;
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[u]=true;
        q.add(u);

        while(!q.isEmpty()){
            int n = q.poll();
            Iterator<Integer> li = adj[n].listIterator();
            while(li.hasNext()){
                int j =li.next();
                if(visited[j]==false) {
                    if (j == w) return true;
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RouteBetweenNodes g = new RouteBetweenNodes(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        System.out.println(g.routeExists(2,1));
        System.out.println(g.routeExists(3,1));
    }
}
