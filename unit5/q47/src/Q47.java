public class Q47 {
    public int getMaxValue(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int rows = arr.length;
        int cols = arr[0].length;

        int[] maxValue = new int[cols];

        //初始化礼物矩阵
        maxValue[0] = arr[0][0];
        for (int col = 1; col < cols; col++) {
            maxValue[col] = maxValue[col - 1] + arr[0][col];
        }

        for (int row = 1; row < rows; row++)
            for (int col = 0; col < cols; col++) {
                if (col == 0)
                    maxValue[col] = maxValue[col] + arr[row][col];
                else
                    maxValue[col] = arr[row][col] + (maxValue[col] > maxValue[col - 1] ? maxValue[col] : maxValue[col - 1]);
            }

        return maxValue[cols - 1];
    }

    public static void main(String[] args) {
        Q47 test = new Q47();
        int[][] arr = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(test.getMaxValue(arr));
    }

}
