public class Q5_2 {
    public static void main(String[] args) {
        String str = "We   are   happy  .";
        int length = str.length();
        char[] olderArray = str.toCharArray();
        // 为简单起见，我们假设给它一个新的空间，空间的大小足以存下替换后的字符
        char[] newArray = new char[100];
        for (int i = 0; i < olderArray.length; i++) {
            newArray[i] = olderArray[i];
        }
        String resultStr = replaceSpace(newArray, length);
        System.out.println(resultStr);
    }

    public static String replaceSpace(char[] c, int length) {
        // 查询空格的个数
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (c[i] == ' ') {
                count++;
            }
        }
        // 重新计算新数组的大小
        int newLength = length + count * 2;
        // 从尾到头查找
        int i = length - 1;
        int j = newLength - 1;
        while (i >= 0 && j >= i) {
            if (c[i] == ' ') {
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';
            } else {
                c[j--] = c[i];
            }
            i--;
        }
        return new String(c);
    }
}
