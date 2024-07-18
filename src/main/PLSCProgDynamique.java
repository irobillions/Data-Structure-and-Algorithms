package main;

import java.util.Objects;

import static java.lang.Math.max;

public class PLSCProgDynamique {


    public static Result lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        Integer[][] c = new Integer[m + 1][n + 1]; // +1 car on commence de 0
        String[][] b = new String[m][n];

        // Initialisation de la première colonne et la première ligne à 0
        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }

        // Construction des tableaux c et b
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i-1][j-1] = "↖";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i-1][j-1] = "↑";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i-1][j-1] = "←";
                }
            }
        }

        // Retourner les tableaux c et b pour utilisation ultérieure
        return new Result(c, b);
    }

    public static <T> void printMatrixWithBorders(T[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        // Dessiner la bordure supérieure de la matrice
        printHorizontalBorder(cols);

        // Imprimer les lignes de la matrice
        for (T[] row : matrix) {
            System.out.print("|");
            for (T elem : row) {
                if (elem != null) {
                    System.out.printf(" %2s |", elem.toString());
                } else {
                    System.out.print("     |"); // espace pour les éléments null
                }
            }
            System.out.println();
            // Dessiner une bordure séparatrice entre les lignes
            printHorizontalBorder(cols);
        }

        // Dessiner la bordure inférieure de la matrice
        printHorizontalBorder(cols);
    }

    private static void printHorizontalBorder(int cols) {
        for (int i = 0; i < cols; i++) {
            System.out.print("+----");
        }
        System.out.println("+");
    }

    public static void printLCS(String[][] b,String X, int i,int j) {
        // Vérifiez les indices pour éviter ArrayIndexOutOfBoundsException
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length)
            return;

        if (Objects.equals(b[i][j], "↖")) {
            printLCS(b, X, i-1, j-1);
            // Ajuster l'index pour X car les indices de X commencent à 0
            System.out.print(X.charAt(i));
        } else if (Objects.equals(b[i][j], "↑")) {
            printLCS(b, X, i-1, j);
        } else if (Objects.equals(b[i][j], "←")) {
            printLCS(b, X, i, j-1);
        }
    }
    public static class Result {
        public Integer[][] c;
        public String[][] b;

        public Result(Integer[][] c, String[][] b) {
            this.c = c;
            this.b = b;
        }
    }

}
