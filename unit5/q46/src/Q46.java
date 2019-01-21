public class Q46 {
    public int count(int number) {
        if (number < 0)
            throw new RuntimeException("输入参数有误！");

        String strN = Integer.toString(number);
        if (strN.length() == 1)
            return 1;

        int tmp1 = 1;
        int tmp2 = 1;

        for (int i = 1; i < strN.length(); i++) {
            int tmp;
            if (Integer.parseInt(strN.substring(i - 1, i + 1)) <= 25 && Integer.parseInt(strN.substring(i - 1, i + 1)) >= 10)
                tmp = tmp2 + tmp1;
            else
                tmp = tmp2;

            tmp1 = tmp2;
            tmp2 = tmp;
        }

        return tmp2;
    }

    public static void main(String[] args) {
        Q46 test = new Q46();
        int number = 19951218;
        System.out.println(test.count(number));
    }
}
