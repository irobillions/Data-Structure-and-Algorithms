package main;

import java.util.ArrayList;

public class PatronSearchNaive {


    public static   ArrayList<Integer> findString(String T, String P) {
        int n = T.length();
        int m = P.length();
        ArrayList<Integer> S = new ArrayList<Integer>();
        for (int s = 0 ; s < n-m ; s++) {

            for (int j = 0 ; j < m; j++) {
                if (T.charAt(s+j) != P.charAt(j)) {
                    break;
                } else if (j == m-1) {
                    S.add(s);
                }

            }
        }

        return S;
    }
}
