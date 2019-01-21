public class Q19 {
    public static void main(String[] args) {
        String str = "a";
        String pattern = ".*";

        boolean result = match(str.toCharArray(), pattern.toCharArray());
        System.out.println(result);
    }

    public static boolean match(char[] str, char[] pattern) {
        //参数校验
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0) {
            if (pattern.length == 0)
                return true;
            else {
                int n = 1;
                while (n < pattern.length) {
                    if (pattern[n] == '*')
                        n += 2;
                    else
                        return false;
                }
                if (n - pattern.length == 1)
                    return true;
                else
                    return false;
            }
        }

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int pIndex) {
        //字符串和模式都已操作完，返回true
        if (strIndex >= str.length && pIndex >= pattern.length)
            return true;
        //字符串没有操作完，模式操作完，返回false
        if (strIndex < str.length && pIndex >= pattern.length)
            return false;
        //字符串操作完，模式没有操作完
        if (strIndex >= str.length && pIndex < pattern.length) {
            if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, pIndex + 2);
            else
                return false;
        }
        /**
         * 字符串没有操作完，模式没有操作完
         */
        //如果模式的下一个字符为*
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            //字符串和模式的当前字符能够匹配
            if (str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                return matchCore(str, strIndex, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex);
            } else {
                return matchCore(str, strIndex, pattern, pIndex + 2);
            }
        } else {
            if (str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                return matchCore(str, strIndex + 1, pattern, pIndex + 1);
            } else {
                return false;
            }
        }
    }
}
