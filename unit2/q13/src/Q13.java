public class Q13 {
    public static void main(String[] args) {
        int count = movingCount(4, 1, 6);
        System.out.println(count);
    }

    public static int movingCount(int threshold, int rows, int cols) {
        //参数校验
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;

        //初始化访问标记矩阵
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    /*
     * 判断从第row行、第col列出发可以到达的格子数
     */
    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;

        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row * cols + col] == true)
            return 0;

        if (getDigitSum(row) + getDigitSum(col) <= threshold) {
            visited[row * cols + col] = true;
            count++;
            count += movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        } else {
            return 0;
        }
        return count;
    }

    //求一个数的各位数和
    public static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
