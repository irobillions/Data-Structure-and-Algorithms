package main;

public class MatrixChainProgDynamic {

    private static final Integer MAX_INT = Integer.MAX_VALUE;

    public static Result matrixChainMinCost(int[] p) {

        int n = p.length - 1;

        Integer[][] m = new Integer[n+1][n+1];
        Integer[][] s = new Integer[n][n];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        // correspond au nombre de matrice a multiplier le cas de base cest 2
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = MAX_INT;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i - 1][j - 1] = k;
                    }
                }
            }
        }

        return new Result(m , s);
    }

    public static void printOptimalParenthesisation(Integer[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesisation(s, i, s[i-1][j-1]);
            printOptimalParenthesisation(s, s[i-1][j-1] + 1, j);
            System.out.print(")");
        }
    }
    public static class Result {
        public Integer[][] m;
        public Integer[][] s;

        public Result(Integer[][] m, Integer[][] s) {
            this.m = m;
            this.s = s;
        }
    }
}
