public class Q66 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        int[] C = new int[length];
        int[] D = new int[length];

        C[0] = 1;
        D[length - 1] = 1;
        for (int count = 1; count < length; count++) {
            C[count] = C[count - 1] * A[count - 1];
            D[length - 1 - count] = D[length - count] * A[length - count];
        }

        for (int count = 0; count < length; count++) {
            B[count] = C[count]*D[count];
        }

        return B;
    }
}
