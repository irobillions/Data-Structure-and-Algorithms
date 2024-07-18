package test;
import main.MatrixChainProgDynamic;
import main.PLSCProgDynamique;
import org.junit.jupiter.api.Test;
public class MatrixChainProgDynamicTest {
    @Test
    public void input1Test() {

        int[] p = {1 , 2 , 3, 3, 4, 1};

        MatrixChainProgDynamic.Result res = MatrixChainProgDynamic.matrixChainMinCost(p);

        PLSCProgDynamique.printMatrixWithBorders(res.m);
        //MatrixChainProgDynamic.printOptimalParenthesisation(res.s, 1, p.length -1);
    }
}
