package test;
import main.PLSCProgDynamique;
import org.junit.jupiter.api.Test;

public class PLSCProgDynamiqueTest {

    @Test
    void input1Test() {
        String Y =  "aabccabcba";
        String X = "abcbaccbaa";
        PLSCProgDynamique.Result result = PLSCProgDynamique.lcsLength(X, Y);


        PLSCProgDynamique.printMatrixWithBorders(result.c);
        PLSCProgDynamique.printMatrixWithBorders(result.b);

        int i = result.b.length;
        int j = i > 0 ? result.b[0].length : 0;
        PLSCProgDynamique.printLCS(result.b, X, i-1, j-1);
    }

}
