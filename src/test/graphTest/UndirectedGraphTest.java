package test.graphTest;
import main.graph.DirectedGraph;
import main.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;
public class UndirectedGraphTest {

    @Test
    public void input1Test() {
        UndirectedGraph g = new UndirectedGraph(7);

        g.connect(1, 5);
        g.connect(1, 3);
        g.connect(1, 4);
        g.connect(0, 1);
        g.connect(3, 4);
        g.connect(2, 4);
        g.connect(2, 0);
        g.connect(2, 6);
        g.connect(5, 6);

        System.out.print(g.toString());;
    }
}
