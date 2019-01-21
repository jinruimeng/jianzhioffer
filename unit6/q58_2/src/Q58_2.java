public class Q58_2 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || str.length() < n || n <= 0)
            return str;

        char[] strChar = str.toCharArray();
        reverse(strChar, 0, str.length() - 1);

        reverse(strChar, 0, str.length() - 1 - n);
        reverse(strChar, str.length() - n, str.length() - 1);

        StringBuilder result = new StringBuilder();
        for (char c : strChar) {
            result.append(c);
        }
        return result.toString();
    }

    public void reverse(char[] strChar, int left, int right) {
        char tmp;
        while (left < right) {
            tmp = strChar[left];
            strChar[left] = strChar[right];
            strChar[right] = tmp;
            left++;
            right--;
        }
    }
}
