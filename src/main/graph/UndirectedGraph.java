package main.graph;

import java.security.InvalidParameterException;
import java.util.HashSet;

public class UndirectedGraph implements Graph {

    private HashSet<Integer>[] neighbors; // listes d’adjacences
    private  int V, E; // cardinal de V et cardinal de E
    public UndirectedGraph (int V){
        initialize(V);
    }

    public void initialize( int V){
        if(V < 0)
            throw new InvalidParameterException();

        E = 0;
        this.V = V;
        neighbors = new HashSet[V];
        for(int v=0; v<V; v++)
             neighbors[v] = new HashSet<Integer>();

    }
    public int V(){ return V;}
    public int E(){ return E;}

    public void connect( int v1, int v2){
        if(v1<0 || v1>=V) return;
        if(v2<0 || v2>=V) return;
        if( neighbors[v1].contains(v2) ) return;
        neighbors[v1].add(v2);
        neighbors[v2].add(v1);
        E++;
    }

    public HashSet <Integer> adj( int v){
// check parameters
        if (v<0 || v>=V) return null;
        return neighbors[v];
    }

    public String toString() {
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(V).append(ln).append(E).append(ln);
        for(int v=0; v<V; v++)
            for (int w : neighbors[v])
                o.append(v).append("--").append(w).append(ln);
        return o.toString();
    }
}
