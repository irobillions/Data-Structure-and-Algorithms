package test.graphTest;
import main.graph.DirectedGraph;
import main.graph.TopologicalOrder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class DirectedGraphTest {

    @Test
    public void input1Test() {

        DirectedGraph g = new DirectedGraph(7);
        g.connect(1, 2);
        g.connect(1, 3);
        g.connect(1, 4);
        g.connect(2, 4);
        g.connect(2, 5);
        g.connect(3, 6);
        g.connect(4, 6);
        g.connect(4, 3);
        g.connect(4, 7);
        g.connect(5, 7);
        g.connect(5, 4);
        g.connect(7, 6);
        System.out.print(g);;
        TopologicalOrder topologicalOrder = new TopologicalOrder(g);

        System.out.println(Arrays.toString(topologicalOrder.findTopologicalOrder()));


    }
}
