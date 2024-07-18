import main.FIbonacciProgDynamic;
import main.graph.DirectedGraph;

public class Main {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(13);
        g.connect(3, 0);
        g.connect(0, 2);
        g.connect(2, 5);
        g.connect(5, 2);
        g.connect(6, 2);
        g.connect(5, 1);
        g.connect(1, 8);
        g.connect(8, 9);
        g.connect(9, 6);
        g.connect(12,9);
        g.connect(10,12);
        g.connect(10,7);
        g.connect(11,7);
        g.connect(4,11);
        g.connect(7,4);
        g.connect(4,3);

        g.dfsPostOrder();

        String p = "213013201023201321302100321221301213010021302323011032013213213021203110213203001021303213210312021301301123021031230102303113012310213010213013201231032102332021302113010231230321001230120021332012";
        System.out.println(p.length());
    }
}
