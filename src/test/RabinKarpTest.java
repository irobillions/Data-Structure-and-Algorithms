package test;
import main.RabinKarp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RabinKarpTest {

    @Test
    public void input1Test() {

        String P = "1235";
        String T =  "213013201023201321302100321221301213010021302323011032013213 2 1 3 0 2 1 2 0 3 1 1 0 2 1 3 2 0 3 0 0 1 0 2 1 3 0 3 2 1 3 2 1 0 3 1 2 0 2 1 3 0 1 3 0 1 1 2 3 0 2 1 0 3 1 2 3 0 1 0 2 3 0 3 1 1 3 0 1 2 3 1 0 2 1 3 0 1 0 2 1 3 0 1 3 2 0 1 2 3 1 0 3 2 1 0 2 3 3 2 0 2 1 3 0 2 1 1 3 0 1 0 2 3 1 2 3 0 3 2 1 0 0 1 2 3 0 1 2 0 0 2 1 3 3 2 0 1 2";
        int d = 10;
        int q = 11;
        ArrayList<Integer> res = RabinKarp.rabinKarpMatcher(T, P, d, q);

        System.out.println(res);
    }
}
