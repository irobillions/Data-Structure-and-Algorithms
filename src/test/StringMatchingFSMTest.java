package test;
import main.StringMatchingFSM;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class StringMatchingFSMTest {

    @Test
    public void input1Test() {

        String  P = "bebe";
        String T = "beebbebebeeb";
        char[] alphabet = {'b', 'e'};
        Integer[][] transitions = StringMatchingFSM.computeTransitionFunction(P,alphabet );
        StringMatchingFSM.printTransitionTable(transitions, alphabet);
        ArrayList<Integer> res = StringMatchingFSM.finiteAutomatonMatchers(T, transitions, alphabet, P.length());

        System.out.println(res);
    }
}
