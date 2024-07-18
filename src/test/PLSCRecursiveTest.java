package test;
import org.junit.jupiter.api.Test;
import main.PLSCRecursive;

public class PLSCRecursiveTest {
    @Test
    public void input1Test() {
        String s1 = "BRIQUETAGES";
        String s2 = "ALGEBRIQUEMENT";
        PLSCRecursive plsc = new PLSCRecursive();

        int res = plsc.findPLSC(0,0 , s1, s2);
        System.out.println(res);
    }
}
