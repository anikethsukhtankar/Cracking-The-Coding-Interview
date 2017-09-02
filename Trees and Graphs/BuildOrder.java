package treesandgraphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BuildOrder {

    static HashMap<Character,LinkedList<Character>> adj = new HashMap<>();

    static class Dependency{
        private Character from;
        private Character to;
        public Dependency( Character a,Character b){
            from = a;
            to = b;
        }
    }

    public static void buildOrder(Character[] project, Dependency[] dependencies){
        HashMap<Character,Character> visited = new HashMap<>();

        for(Character c:project){
            adj.put(c,new LinkedList<>());
            visited.put(c,'w');
        }

        for(Dependency d:dependencies){
            adj.get(d.from).add(d.to);
        }

        Stack<Character> res = new Stack<Character>();
        for(Character c : visited.keySet()){
            if(visited.get(c)!='b')
                buildOrder(c,visited,res);
        }

        while(!res.isEmpty()){
            System.out.print("->"+res.pop());
        }
    }

    public static void buildOrder(Character c, HashMap<Character, Character> visited, Stack<Character> res){
        if(visited.get(c)=='g') throw new RuntimeException("Graph Has A Cycle");
        Character proj;
        Iterator<Character> li = adj.get(c).listIterator();
        visited.put(c,'g');
        while(li.hasNext()){
            proj = li.next();
            if(visited.get(proj)!='b'){
                buildOrder(proj,visited,res);
            }
        }
        visited.put(c,'b');
        res.push(c);
    }

    public static void main(String[] args) {
        Character[] proj = {'a','b','c','d','e','f'};
        Dependency[] dep = {new Dependency('a','d'),
                            new Dependency('f','b'),
                            new Dependency('b','d'),
                            new Dependency('f','a'),
                            new Dependency('d','c')};/*,
                            new Dependency('d','f')};*/
        buildOrder(proj,dep);
    }
}
