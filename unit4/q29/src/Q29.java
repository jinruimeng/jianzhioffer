import java.util.ArrayList;

public class Q29 {
    public static void main(String[] args) {
        Q29 test = new Q29();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        test.printMatrix(matrix);
    }

    public ArrayList<Integer> printMatrix(int[][] array) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (array == null) return result;
        if (array.length == 0) return result;

        int rows = array.length, columns = array[0].length;

        if (columns == 0) return result;

        int layers = (Math.min(rows, columns) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < columns - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < rows - i; j++) result.add(array[j][columns - i - 1]);//右上至右下
            for (int k = columns - i - 2; (k >= i) && (rows - i - 1 != i); k--) result.add(array[rows - i - 1][k]);//右至左
            for (int j = rows - i - 2; (j > i) && (columns - i - 1 != i); j--) result.add(array[j][i]);//左下至左上
        }
        //第二种
/*        for (int i = 0; i < layers; i++) {
            for (int k = i; k < columns - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < rows - i; j++) result.add(array[j][columns - i - 1]);//右上至右下
            for (int k = columns - i - 2; (k > i) && (rows - i - 1 != i); k--) result.add(array[rows - i - 1][k]);//右至左
            for (int j = rows - i - 1; (j > i) && (columns - i - 1 != i); j--) result.add(array[j][i]);//左下至左上
        }*/
        return result;
    }
}
