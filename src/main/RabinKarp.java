package main;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class RabinKarp {

    public static ArrayList<Integer> rabinKarpMatcher(String T, String P, int base, int mod) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = T.length();
        int m = P.length();
        int h = (int) Math.pow(base, m - 1) % mod;
        int p = 0;
        int t_0 = 0;

        // Preprocessing
        for (int i = 0; i < m; ++i) {
            p = (base * p + P.charAt(i)) % mod;
            t_0 = (base * t_0 + T.charAt(i)) % mod;
        }

        // Matching
        for (int s = 0; s <= n - m; s++) {
            if (p == t_0) {
                if (P.equals(T.substring(s, s + m))) {
                    res.add(s);
                }
            }

            if (s < n - m) {
                t_0 = (base * (t_0 - T.charAt(s) * h) + T.charAt(s + m)) % mod;
                if (t_0 < 0) t_0 += mod; // rassurer que t_0 reste positif
            }
        }

        return res;
    }
}
