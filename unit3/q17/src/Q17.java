public class Q17 {

    public static void main(String[] args) {
        int n = 0;
        printToMaxOfDigits(n);
    }

    public static void printToMaxOfDigits(int n) {
        if (n <= 0) {
            System.out.println("输入不合法");
        } else {
            //使用数组来模拟大数
            int[] number = new int[n];
            while (!increment(number)) {
                print(number);
            }
        }
    }

    // 使用数组实现对数进行+1操作
    public static boolean increment(int[] number) {
        // 最高位产生进位标志
        boolean isOverFlow = false;

        // 进位
        int carry = 0;
        int sum = 1;
        for (int i = number.length - 1; i >= 0; i--) {
            sum += number[i] + carry;
            carry = 0;
            if (i == 0 && sum > 9) {
                isOverFlow = true;
                number[i] = sum - 10;
            } else if (sum > 9) {
                number[i] = sum - 10;
                carry = 1;
            } else {
                number[i] = sum;
            }
            sum = 0;
        }
        return isOverFlow;
    }

    // 打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
    public static void print(int[] number) {
        int i = 0;
        for (; i < number.length; i++) {
            if (number[i] != 0)
                break;
        }
        for (; i < number.length; i++)
            System.out.print(number[i]);
        System.out.println();
    }
}
