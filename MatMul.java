import java.util.Random;

// Single row multiplier
class Multiplier implements Runnable {

    public static int[][] matA;
    public static int[][] matB;

    public static int[][] res;

    private int rowNum;
    private int n;

    public Multiplier(int rowNum, int n) {
        // which row in the result matrix to fill
        this.rowNum = rowNum;
        // size of the result matrix
        this.n = n;
    }

    @Override
    public void run() {
        // fill row `rowNum` in the result matrix
        int j, k;
        for (j = 0; j < n; j++) {
            for (k = 0; k < n; k++) {
                res[rowNum][j] = matA[rowNum][k] * matB[k][j];
            }
        }
    }

}

public class MatMul {

    // helper funtion for debugging
    public static void print_mat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // populate input matrices and result with
        // random numbers
        Random random = new Random();
        final int N = 2000;

        Multiplier.matA = new int[N][N];
        Multiplier.matB = new int[N][N];
        Multiplier.res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Multiplier.matA[i][j] = random.nextInt(5);
                Multiplier.matB[i][j] = random.nextInt(5);
                Multiplier.res[i][j] = 0;
            }
        }

        // start one thread per row of the result matrix
        for (int i = 0; i < N; i++) {
            new Thread(new Multiplier(i, N)).start();
        }

        // caution!!
        // Multiplier.res may not contain the final result yet
        // because the last few threads may still be working

        // only after all threads have executed, i.e. the program
        // has terminated, Multiplier.res will contain the correct
        // result
    }
}
