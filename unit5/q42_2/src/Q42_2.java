public class Q42_2 {
    /**
     * 利用动态规划求解
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        int curMax = array[0];
        int maxSum = curMax;

        for (int i = 1; i < array.length; i++) {
            if (curMax > 0)
                curMax = curMax + array[i];
            else
                curMax = array[i];

            if (curMax > maxSum)
                maxSum = curMax;
        }

        return maxSum;
    }
}
