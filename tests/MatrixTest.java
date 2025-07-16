import core.Matrix;

/**
 * Manual tests for the Matrix class.
 * Run this to verify core matrix operations.
 *
 * 2025
 */
public class MatrixTest {
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 2);
        a.data[0][0] = 1;
        a.data[0][1] = 2;
        a.data[1][0] = 3;
        a.data[1][1] = 4;

        Matrix b = a.transpose();

        System.out.println("Original:");
        a.print();

        System.out.println("Transposed:");
        b.print();

        Matrix added = Matrix.add(a, b);
        System.out.println("A + Aᵀ:");
        added.print();

        Matrix multiplied = Matrix.multiply(a, b);
        System.out.println("A * Aᵀ:");
        multiplied.print();
    }
}
