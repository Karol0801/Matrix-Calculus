import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // 3.
       gaussianElimination(9, false);

        // 6.
        gaussianElimination(9, true);

        // 9.
        luDecomposition(9, false);

        // 12.
        luDecomposition(9, true);

    }
    private static void luDecomposition(int n, boolean pivoting){
        double[][] A = generateRandomMatrix(n);
        double[] b = generateRandomVector(n);

        System.out.println("A matrix:");
        printMatrix(A);
        System.out.println("b vector:");
        printVector(b);

        double[][] U = new double[n][n];
        double[] y;
        double[] x;
        if (pivoting) {
            double[][] L = identityMatrix(n);
            double[][] P = identityMatrix(n);


            LUDecomposition.luDecompositionWithPivoting(A, U, L, P);
            System.out.println("L matrix: ");
            printMatrix(L);
            System.out.println("U matrix: ");
            printMatrix(U);
            System.out.println("P matrix: ");
            printMatrix(P);

            y  = forwardSubstitution(L, b);
            System.out.println("y: ");
            printVector(y);
            x = backwardSubstitution(U, y);
            System.out.println("x: ");
            printVector(x);
        }
        else{
            double[][] L = new double[n][n];
            LUDecomposition.luDecomposition(A, U, L);
            System.out.println("L matrix: ");
            printMatrix(L);
            System.out.println("U matrix: ");
            printMatrix(U);

            y  = forwardSubstitution(L, b);
            System.out.println("y: ");
            printVector(y);
            x = backwardSubstitution(U, y);
            System.out.println("x: ");
            printVector(x);
        }
    }

    private static void gaussianElimination(int n, boolean pivoting){
        double[][] A = generateRandomMatrix(n);
        double[] b = generateRandomVector(n);

        System.out.println("A matrix: ");
        printMatrix(A);
        System.out.println("b vector: ");
        printVector(b);

        if(pivoting)
            GaussianElimination.gaussianEliminationWithPivoting(A,b);
        else
            GaussianElimination.gaussianElimination(A, b);
        System.out.println("A matrix [After gaussian elimination]:");
        printMatrix(A);
        System.out.println("b vector [After gaussian elimination]: ");
        printVector(b);

        System.out.println("Solution:");
        double[] solution = solveEquations(A, b);
        printVector(solution);
    }

    public static double[][] identityMatrix(int size){
        double[][] identityMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    identityMatrix[i][j] = 1.0;
                } else {
                    identityMatrix[i][j] = 0.0;
                }
            }
        }
        return identityMatrix;
    }

    private static double[] solveEquations(double[][] A, double[] b){
        int n = b.length;
        double[] result = new double[n];

        result[n-1] = b[n-1];

        for(int i=n-2; i>= 0; i--){
            double sum = b[i];
            for(int j=i+1; j<n; j++){
                sum -= A[i][j] * result[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public static double[] forwardSubstitution(double[][] L, double[] b) {
        int n = L.length;
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += L[i][j] * y[j];
            }
            y[i] = (b[i] - sum) / L[i][i];
        }
        return y;
    }

    public static double[] backwardSubstitution(double[][] U, double[] y) {
        int n = U.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += U[i][j] * x[j];
            }
            x[i] = (y[i] - sum) / U[i][i];
        }
        return x;
    }


    public static double[][] generateRandomMatrix(int size) {
        double[][] matrix = new double[size][size];
        Random random = new Random();

        // Wypełniamy losowymi wartościami z przedziału (-10, 10)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextDouble() * 20 - 10;
            }
        }
        return matrix;
    }

    public static double[] generateRandomVector(int size){
        double[] vector = new double[size];
        Random random = new Random();

        for(int i=0; i<size; i++){
            vector[i] = random.nextDouble() * 20 - 10;
        }
        return vector;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printVector(double[] vector) {
        for (double val : vector) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println();
    }

}

