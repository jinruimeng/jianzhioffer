import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
        }
        sc.close();

        long max = core(n, d, a, b);
        System.out.println(max);
    }

    public static long core(int n, long d, long[] a, long[] b) {
        long max = 0;
        for (int left = 0; left < n - 1; left++)
            for (int right = n; right > left && a[right] - a[left] >= d; right--)
                if (a[left] + a[right] > max && b[right] - b[left] > d)
                    max = a[left] + a[right];
//        for (int i = 0; i < n - 1; i++)
//            for (int j = i + 1; j < n; j++) {
//                if (a[i] + a[j] > max && (b[j] - b[i] > d || b[i] - b[j] > d))
//                    max = a[i] + a[j];
//            }
        return max;
    }
}
