public class Q17_2 {
    public static void main(String[] args) {
        int n = 3;
        printToMaxOfNDigits(n);
    }

    //打印从1到n位的最大数
    public static void printToMaxOfNDigits(int n) {
        if (n <= 0)
            return;

        //初始化数字（用StringBuffer表示）
        StringBuffer sb = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }

        print1ToMaxOfNDigits_Recursely(sb, n, 0);
    }

    public static void print1ToMaxOfNDigits_Recursely(StringBuffer sb, int n, int index) {
        if (index == n) {
            printNumber(sb);
            return;
        }

        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index, (char) (i + '0'));
            print1ToMaxOfNDigits_Recursely(sb, n, index + 1);
        }
    }

    public static void printNumber(StringBuffer sb) {
        int i = 0;
        for (; i < sb.length(); i++) {
            if (sb.charAt(i) >= '1' && sb.charAt(i) <= '9')
                break;
        }
        for (; i < sb.length(); i++)
            System.out.print(sb.charAt(i));
        if (i != 0)
            System.out.println();
    }
}
