public class Q58 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return str;
        char[] strChar = str.toCharArray();
        reverse(strChar, 0, str.length() - 1);

        int left = 0;
        int right = 1;
        while (right < strChar.length) {
            if (strChar[right] == ' ' || right == strChar.length - 1) {
                if (strChar[right] == ' ')
                    reverse(strChar, left, right - 1);
                else
                    reverse(strChar, left, right);
                left = right + 1;
                right = left + 1;
            } else {
                right++;
            }
        }
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

    public static void main(String[] args) {
        Q58 test = new Q58();
        String str = "Windows";
        System.out.println(test.ReverseSentence(str));
    }
}
