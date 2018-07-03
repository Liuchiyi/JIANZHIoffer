import java.util.ArrayList;

public class multiply_Test {

    public int[] multiply(int[] A) {
        int [] B = new int[A.length];
        if(A == null || A.length == 0) return B;
        B[0]=1;
        for (int i = 0; i < A.length; i++) {
            B[i] = A[0];
            for (int j = 0; j < A.length; j++) {
                if(j == i) continue;
                B[i] *= A[j];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        multiply_Test test= new multiply_Test();
        int [] A = new int[]{1,2,3,4,5};
        System.out.println(test.multiply(A));
    }

}
