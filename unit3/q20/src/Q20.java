public class Q20 {
    public static void main(String[] args) {
        String str = "+500";
        boolean result = isNumber(str.toCharArray());
        System.out.println(result);
    }

    static int index = 0;

 /*   public static boolean isNumber(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int temp;

        //扫描是否有符号
        if (str[index] == '+' || str[index] == '-')
            index++;

        //扫描整数部分
        boolean hasZhengshu = false;
        temp = index;

        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        if (temp < index)
            hasZhengshu = true;

        //扫描小数部分
        boolean hasXiaoshu = false;
        if (str[index] == '.' && index < str.length - 1)
            index++;

        temp = index;

        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }

        if (temp < index)
            hasXiaoshu = true;

        //扫描指数部分
        boolean zhishuhefa = true;
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            zhishuhefa = false;
        }

        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;

        temp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        if (temp < index)
            zhishuhefa = true;

        if (index >= str.length && (hasZhengshu || hasXiaoshu) && zhishuhefa)
            return true;
        else
            return false;
    }*/

    public static boolean isNumber(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int temp;

        //扫描是有/无符号整数
        boolean hasZhengshu = scanInteger(str);

        //扫描小数部分
        boolean hasXiaoshu = false;
        if (index < str.length - 1 && str[index] == '.'){
            index++;
            hasXiaoshu = scanUnsignedInteger(str);
        }

        //扫描指数部分
        boolean zhishuhefa = true;

        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            zhishuhefa = scanInteger(str);
        }

        if (index >= str.length && (hasZhengshu || hasXiaoshu) && zhishuhefa)
            return true;
        else
            return false;
    }

    //扫描整数部分
    public static boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    //扫描无符号整数部分
    public static boolean scanUnsignedInteger(char[] str) {
        int temp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > temp;
    }
}
