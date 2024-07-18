package main;

public class DisjointsSets {

    public DisjointsSets(int size) {
        s = new int[size];
        for (int i = 0 ; i <size; ++i) {
            s[i] = -1;
        }
    }

    public void union(int a , int b) {
        int roota = find(a);
        int rootb = find(b);

        if (roota == rootb) {
            return;
        }

        if (s[rootb] < s[roota]) {
            s[roota] = rootb;
        } else {
            if (s[rootb] == s[roota]) {
                --s[roota];
            }
            s[rootb] = roota;
        }
    }

    public int find(int x) {
        if (s[x] < 0) {
            return x;
        }else {
            s[x] = find(s[x]);
            return s[x];
        }
    }

    public int size() {
        return s.length;
    }
    public void print(){
        for(int i = 0; i < size(); ++i){
            System.out.print(s[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private int[] s;

}
