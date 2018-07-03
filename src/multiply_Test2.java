public class multiply_Test2 {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)return null;
        int [] B = new int[A.length];
        B[0] = 1;
        int begin = 1, end = 1;
        for (int i = 0; i < A.length - 1; i++) {
            begin *= A[i];
            B[i+1] = begin;
        }
        for(int i = A.length - 1;i > 0;i--){
            end *= A[i];
            B[i - 1] = B[i -1] * end;
        }
        return B;
    }

    public static void main(String[] args) {
        multiply_Test2 test= new multiply_Test2();
        int [] A = new int[]{1,2,3,4,5};
        System.out.println(test.multiply(A)[0]);
    }

}
