package main;

import java.util.ArrayList;

public class StringMatchingFSM {

    public static Integer[][] computeTransitionFunction(String P, char[] alphabet_p) {
        int m = P.length();
        Integer[][] transitions = new Integer[m + 1][alphabet_p.length];
        for (int q = 0; q <= m; ++q) {
            for (int a = 0; a < alphabet_p.length; a++) {
                char c = alphabet_p[a];
                int k = Math.min(m + 1, q + 2);
                do {
                    k--;
                } while (k > 0 && !isSuffix(P, k, q, c));
                transitions[q][a] = k;
            }
        }
        return transitions;
    }

    public static boolean isSuffix(String P, int k, int q, char a) {
        return P.substring(0, k).equals(P.substring(q - k + 1, q) + a);
    }


    public static ArrayList<Integer> finiteAutomatonMatchers(String T, Integer[][] transitions, char[] alphabet_p, int m) {
        int n = T.length();
        int q = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0 ; i < n; ++i) {
            int charIndex = new String(alphabet_p).indexOf(T.charAt(i)); // Trouve l'index du caractère dans l'alphabet

            if( charIndex != -1){
                q = transitions[q][charIndex];
            }

            if (q == m) {
                res.add(i - m + 1);
            }
        }

        return res;
    }
    public static void printTransitionTable(Integer[][] transitions, char[] alphabet_p) {
        // Print the header
        System.out.print("   ");
        for (char c : alphabet_p) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Print the state transitions
        for (int i = 0; i < transitions.length; i++) {
            System.out.print("q" + i + " ");
            for (int j = 0; j < alphabet_p.length; j++) {
                System.out.print(transitions[i][j] + " ");
            }
            System.out.println();
        }
    }
}
