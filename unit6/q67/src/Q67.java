public class Q67 {
    public static boolean statu = false;

    public int StrToInt(String str) {
        int result = 0;
        if (str == null || str.length() == 0)
            return result;

        int index = 0;
        int flag = 0;
        if (str.charAt(index) > '9' || str.charAt(index) < '0') {
            if (str.charAt(index) != '+' && str.charAt(index) != '-')
                return result;
            else if (str.length() < 2 || str.charAt(index + 1) > '9' || str.charAt(index + 1) < '0')
                return result;
            else if (str.charAt(index++) == '-')
                flag = 1;
        }

        while (index < str.length()) {
            if (str.charAt(index) > '9' || str.charAt(index) < '0')
                return 0;

            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }

        statu = true;
        if (flag == 1)
            result = 0 - result;

        return result;
    }
}
