package main.graph;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Stack;

public class DirectedGraph implements Graph {

    private HashSet<Integer>[] neighbors; // listes d’adjacences
    private  int V, E; // cardinal de V et cardinal de E

    private int [] inDegree ;// membre additionnel
    public DirectedGraph (int V){
        initialize(V);
        inDegree = new int[V];
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
        inDegree[v2]++;
        E++;
    }
    public int[] getInDegree() {
        return inDegree;
    }
    public DirectedGraph transposed(){
        DirectedGraph T = new DirectedGraph (V);
        for (int v=0; v<V; v++){
            for (int w : neighbors[v]) {
                T.connect(w, v);
            }
        }
        return T;
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
                o.append(v).append("-->").append(w).append(ln);
        return o.toString();
    }

    public void dfsPostOrder() {
        boolean[] visited = new boolean[V];
        Stack<Integer> postOrder = new Stack<>();
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, visited, postOrder);
            }
        }
        printPostOrder(postOrder);
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> postOrder) {
        visited[v] = true;
        for (int w : neighbors[v]) {
            if (!visited[w]) {
                dfs(w, visited, postOrder);
            }
        }
        postOrder.push(v);
    }

    private void printPostOrder(Stack<Integer> postOrder) {
        System.out.println("DFS Post-Order:");
        while (!postOrder.isEmpty()) {
            System.out.print(postOrder.pop() + " ");
        }
        System.out.println();
    }
}
