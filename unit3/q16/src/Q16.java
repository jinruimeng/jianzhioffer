public class Q16 {

    public static void main(String[] args) {
        double result = power(2.0, -1);
        double result2 = power2(2.0, -1);
        System.out.println("是否是非法输入：" + invlidInput);
        System.out.println("结果是：" + result);
        System.out.println("结果是：" + result2);
    }

    static boolean invlidInput = false; //使用全局变量处理错误

    //常规处理方法
    public static double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            invlidInput = true;
            return 0;
        }

        if (exponent == 0)
            return 1;

        int absExponent = exponent > 0 ? exponent : -exponent;  //定义正指数
        double result = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }

        if (exponent < 0)
            result = 1.0 / result;

        return result;
    }

    //时间复杂度为O(logn)的解法
    public static double power2(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            invlidInput = true;
            return 0;
        }

        if (exponent == 0)
            return 1;

        int absExponent = exponent > 0 ? exponent : -exponent;  //定义正指数
        double result = 1.0;

        result = powerWithExponet(base, absExponent);

        if (exponent < 0)
            result = 1.0 / result;

        return result;
    }

    public static double powerWithExponet(double base, int exponent){
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return base;

        double result = powerWithExponet(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1)
            result *= base;

        return result;
    }

    //比较两个小数是否相等
    public static boolean equal(double num1, double num2) {
        double tmp = num1 - num2;
        if (tmp > -0.0000001 && tmp < 0.0000001)
            return true;
        else
            return false;
    }
}
