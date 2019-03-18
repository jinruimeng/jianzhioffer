import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //读取数组长度n
        int n = sc.nextInt();
        //读取a，b数组
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        sc.close();

        int min = countMin(a, b, n);
        System.out.println(min);
    }

    public static int countMin(int[] a, int[] b, int n) {
        int min = 0;
        if (a == null || a.length == 0 || b == null || b.length == 0 || n <= 0)
            System.out.println(min);;
        Arrays.sort(a);
        quickSort(b,0,b.length-1);

        for (int i = 0; i < n; i++) {
            min += a[i] * b[i];
        }
        return min;
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partition = partition(a, left, right);
            quickSort(a, left, partition - 1);
            quickSort(a, partition + 1, right);
        }
    }

    public static int partition(int[] a, int left, int right) {
        int val = a[left];
        while (left < right) {
            while (left < right && a[right] <= val)
                right--;
            a[left] = a[right];

            while (left < right && a[right] >= val)
                left++;
            a[right] = a[left];
        }
        a[left] = val;
        return left;
    }
}

