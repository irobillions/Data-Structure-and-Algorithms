package main;

public class FIbonacciProgDynamic {

    public static int fibonacciV1(int n) {
        if (n == 0) {
            return 0;
        }

        int[] T = new int[n+1];
        T[0] = 0;
        T[1] = 1;

        for (int i = 2 ; i <= n; ++i) {
            T[i] = T[i-1] + T[i-2];
        }

        return T[n];
    }

    public static int fibonacciRecu(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacciRecu(n-1) + fibonacciRecu(n-2);
    }

    public static int fibonacciV2(int n) {
        int p = 1;
        int c = 1;

        if ( n == 0 ){
            return 0;
        } else if ( n == 1 ) {
            return 1;
        } else {
            for ( int i = 2 ; i < n; ++i) {
                int t = p + c;
                p = c;
                c = t;
            }
        }

        return c;
    }
}
