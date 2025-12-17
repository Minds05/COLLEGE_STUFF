import java.util.*;
class MatrixMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = {{1, 2}, {3, 4}}, b = {{1, 0}, {0, 1}}, c = new int[2][2];
        
        System.out.println("Result:");
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) c[i][j] += a[i][k] * b[k][j];
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}