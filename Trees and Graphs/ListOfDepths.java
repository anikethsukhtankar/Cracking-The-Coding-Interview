package treesandgraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepths {
    private static int V;
    private static LinkedList<Integer>[] adj;

    public ListOfDepths(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    public static ArrayList<LinkedList<Integer>> depthList(int u){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        int depth = 0;
        res.add(new LinkedList<>());
        res.get(depth).add(u);
        depth++;
        res.add(new LinkedList<>());
        visited[u]=true;
        q.add(u);
        while(!q.isEmpty()){
            u = q.poll();
            Iterator<Integer> li = adj[u].listIterator();
            while(li.hasNext()){
                int j = li.next();
                if(!visited[j]){
                    visited[j] = true;
                    res.get(depth).add(j);
                }
            }
            if(q.isEmpty() && !res.get(depth).isEmpty()) {
                q.addAll(res.get(depth));
                res.add(new LinkedList<>());
                depth++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListOfDepths g = new ListOfDepths(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        ArrayList<LinkedList<Integer>> res = depthList(2);
        for(LinkedList<Integer> u : res){
            Iterator<Integer> li = u.listIterator();
            while(li.hasNext()){
                System.out.print(li.next());
            }
            System.out.println();
        }
    }
}
