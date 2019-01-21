public class Q42 {
    /**
     * 利用数组规律求解
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        int curMax = array[0];
        int sum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (sum < 0)
                sum = array[i];
            else
                sum = sum + array[i];

            if (curMax < sum)
                curMax = sum;
        }

        return curMax;
    }
}
