package com.ksoni.javadukes;

public class TwoDimensional {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2},
                {3, 4},
        };
        TwoDimensional twoDimensional = new TwoDimensional();
        twoDimensional.solve(mat);
    }

    public void solve(int[][] mat) {
        int n = mat.length;
        int m = mat.length;

        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {

                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = 0; c2 < m; c2++) {

                        System.out.println(
                                "Submatrix: (" + r1 + "," + c1 +
                                        ") to (" + r2 + "," + c2 + ")"
                        );

                        for (int i = r1; i <= r2 ; i++) {
                            for (int j = c1; j <= c2 ; j++) {
                                System.out.print(mat[i][j] + " ");
                            }
                            System.out.println();
                        }

                        System.out.println("-------------------------------");


                    }
                }
            }
        }

    }
}
