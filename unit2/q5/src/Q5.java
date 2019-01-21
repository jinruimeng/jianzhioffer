public class Q5 {
    public static void main(String[] args) {
        String str1 = "We are happy.";
        String str2 = " Wearehappy.";
        String str3 = "Wearehappy. ";
        String str4 = "We   are   happy  .";
        String str5 = "Wearehappy.";
        String str6 = "    ";
        String str7 = " ";
        String str8 = null;
        String str9 = "";
        String resultStr1 = replaceSpace(str1);
        String resultStr2 = replaceSpace(str2);
        String resultStr3 = replaceSpace(str3);
        String resultStr4 = replaceSpace(str4);
        String resultStr5 = replaceSpace(str5);
        String resultStr6 = replaceSpace(str6);
        String resultStr7 = replaceSpace(str7);
        String resultStr8 = replaceSpace(str8);
        String resultStr9 = replaceSpace(str9);
        System.out.println(resultStr1);
        System.out.println(resultStr2);
        System.out.println(resultStr3);
        System.out.println(resultStr4);
        System.out.println(resultStr5);
        System.out.println(resultStr6);
        System.out.println(resultStr7);
        System.out.println(resultStr8);
        System.out.println(resultStr9);
    }

    public static String replaceSpace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                strBuilder.append("%20");
            } else {
                strBuilder.append(str.charAt(i));
            }
        }
        return strBuilder.toString();
    }
}
