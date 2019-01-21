public class Q62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }

        return result;
    }
}
