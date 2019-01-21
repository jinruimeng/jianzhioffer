public class Q65 {
    public int Add(int num1, int num2) {
        int result1 = num1 ^ num2;
        int result2 = (num1 & num2) << 1;

        //循环
        while (result2 != 0) {
            int tmp = result1;
            result1 = tmp ^ result2;
            result2 = (tmp & result2) << 1;
        }

        return result1;

        //递归
//        if (result2 != 0) {
//            return Add(result1, result2 << 1);
//        } else
//            return result1;
    }
}
