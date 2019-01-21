public class Q44 {
/*    public int digitAtIndex(int index) {
        if (index < 0)
            throw new RuntimeException("输入的参数有误！");

        int result;

        int position = 1;

        while (index > lengthSum(position)) {
            position++;
        }

        int digit = (index - lengthSum(position - 1)) / position;
        index = index - lengthSum(position - 1) - digit * position;

        result = String.valueOf(digit - 1 + (int) Math.pow(10, position - 1)).charAt(index) - '0';
        return result;
    }


    // n位数的长度
    public int lengthSum(int digit) {
        if (digit <= 0)
            return 0;

        int cur = 1;
        int result = 0;
        for (int i = 1; i <= digit; i++) {
            result += 9 * cur;
            cur *= 10;
        }
        return result - 1;
    }*/

    public int digitAtIndex(int index) {
        if (index < 0) return -1;
        if (index <= 9) return index;
        int curIndex = 10;
        int boundNum = 10;
        int digit = 2;
        while (index > curIndex + lengthSum(digit)) {
            curIndex += lengthSum(digit);
            boundNum += lengthSum(digit) / digit;
            digit++;
        }
        int addNum = (index - curIndex) / digit;
        int tempIndex = (index - curIndex) % digit;
        boundNum = boundNum + addNum;
        int result = boundNum;
        for (int i = 1; i < digit - tempIndex; i++) {
            result = result / 10;
        }
        result = result % 10;
        return result;
    }

    // n位数的长度
    public int lengthSum(int digit) {
        if (digit == 1) return 10;
        int temp = 9;
        for (int i = 1; i < digit; i++) {
            temp = temp * 10;
        }
        return digit * temp;
    }

    public static void main(String[] args) {
        Q44 test = new Q44();
        System.out.println(test.digitAtIndex(19));
    }
}
