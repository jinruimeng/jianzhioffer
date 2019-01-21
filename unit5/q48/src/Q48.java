public class Q48 {
    public int longestSubStringWithout(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        int left = 0;
        int right = 0;
        int result = right - left + 1;

        while (right < str.length()) {
            int curChar = str.charAt(right) - 'a';
            if (position[curChar] != -1) {
                result = (right - left) > result ? right - left : result;

/*
                //把从left到重复位的状态都重置
                for (int i = left; i < position[curChar]; i++)
                    position[str.charAt(i) - 'a'] = -1;
*/

                //判断前一个非重复子字符串中是否出现包含当前字符
                if (position[curChar] >= left)
                    left = position[curChar] + 1;
            }
            position[curChar] = right;
            right++;
        }
        result = (right - left) > result ? right - left : result;

        StringBuilder resultStr = new StringBuilder();
        for (int i = left; i < right; i++)
            resultStr.append(str.charAt(i));
        System.out.println(resultStr);

        return result;
    }

    public static void main(String[] args) {
        Q48 test = new Q48();
        System.out.println(test.longestSubStringWithout("arabcacfr"));
    }

}
