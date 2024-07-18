package main;

import static java.lang.Math.max;
public class PLSCRecursive {
    public int findPLSC(int i, int j, String s1, String s2) {
        if (i >= s1.length() || j >= s2.length())
            return 0;
        else if (s1.charAt(i) == s2.charAt(j))
            return 1 + findPLSC(i + 1, j + 1, s1, s2);
        else
            return max(findPLSC(i + 1, j, s1, s2), findPLSC(i, j + 1, s1, s2));
    }
}

