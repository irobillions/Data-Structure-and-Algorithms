package test;
import org.junit.jupiter.api.Test;

import main.PLSCnaive;

public class PLSCnaiveTest {
    @Test
    public void input1Test() {
        String s1 = "BRIQUETAGES";
        String s2 = "ALGEBRIQUEMENT";
        PLSCnaive plsc = new PLSCnaive();

        String res = plsc.findPLSC(s1, s2);
        System.out.println(res);
    }
}