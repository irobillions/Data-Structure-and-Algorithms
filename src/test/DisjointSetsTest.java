package test;
import org.junit.jupiter.api.Test;
import main.DisjointsSets;

public class DisjointSetsTest {
    @Test
    public  void input1Test() {

        // Créer un ensemble disjoint de taille 10
        DisjointsSets ds = new DisjointsSets(8);

        // Effectuer quelques unions
        ds.union(0,1);
        ds.union(2,3);
        ds.union(4,5);
        ds.union(6,7);
        System.out.println(ds.find(7));
        ds.print();

        ds.union(2, 4);

        ds.print();

        ds.union(0, 2);
        ds.print();

        ds.union(6, 2);
        ds.print();

        System.out.println(ds.find(7));
        ds.print();
    }
}
