/**
 * CSE3040 HW1
 * Level010.java
 * Purpose: Calculating matrix multiplication.
 *
 * @version 1.0 28/9/2019
 * @author Minjun Shin
 */

public class Level010 {
    public static void main(String[] args) {
        final int A[][] = { {1,2}, {3,4}, {5,6} };
        final int B[][] = { {1,2,3,4}, {5,6,7,8} };
        Integer sum;

        System.out.println("A");
        for(int i=0 ; i<A.length ; i++) {
            for(int j=0 ; j<A[i].length ; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("B");
        for(int i=0 ; i<B.length ; i++) {
            for(int j=0 ; j<B[i].length ; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("AxB");
        for(int i=0 ; i<A.length ; i++) {
            for(int j=0 ; j<B[0].length ; j++) {
                sum = 0;
                for(int k=0 ; k<B.length ; k++) {
                    sum += A[i][k] * B[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
