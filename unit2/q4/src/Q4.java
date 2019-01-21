public class Q4 {
    public static void main(String[] args) {
        // 测试用例
        int arr[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean flag = find(arr, 15);
        System.out.println(flag);
    }

    public static boolean find(int arr[][], int target) {
        boolean flag = false;

        if (arr == null || arr.length == 0)
            return flag;

        int rows = arr.length;
        int colums = arr[0].length;
        int row = 0;
        int colum = colums - 1;

        while (row < rows && colum >= 0) {
            if (arr[row][colum] == target) {
                flag = true;
                break;
            } else if (arr[row][colum] > target) {
                colum--;
            } else {
                row++;
            }
        }
        return flag;
    }
}
