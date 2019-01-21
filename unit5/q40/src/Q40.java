import java.util.ArrayList;

public class Q40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (input == null || input.length == 0 || k <= 0 || input.length < k)
            return result;

        int left = 0;
        int right = input.length - 1;
        int j = getLeastNumbersCore(input, left, right);

        while (j != k - 1) {
            if (j < k - 1) {
                left = j + 1;
            } else {
                right = j - 1;
            }
            j = getLeastNumbersCore(input, left, right);
        }

        for (int i = 0; i < k; i++)
            result.add(input[i]);

        return result;
    }

    public int getLeastNumbersCore(int[] input, int left, int right) {
        int small = left;
        int big = right;
        int tmp = input[left];

        while (small < big) {
            while (small < big && input[big] >= tmp)
                big--;
            if (small < big) {
                input[small] = input[big];
                small++;
            }

            while (small < big && input[small] <= tmp)
                small++;
            if (small < big) {
                input[big] = input[small];
                big--;
            }
        }

        input[small] = tmp;
        return small;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};

        Q40 test = new Q40();
        System.out.println(test.GetLeastNumbers_Solution(input, 0));
    }

}
