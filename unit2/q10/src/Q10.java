public class Q10 {
    public static void main(String[] args) {
        System.out.println(fabonacci(10));
    }

    public static int fabonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int temp1 = 1;
        int temp2 = 1;
        int result = temp1 + temp2;
        for (int i = 3; i <= n; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }
}

