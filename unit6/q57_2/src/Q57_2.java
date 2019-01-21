import java.util.ArrayList;

public class Q57_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 0)
            return result;

        int left = 1;
        int right = 2;
        int tmpSum;

        while (left <= (sum >> 1)) {
            tmpSum = sum(left, right);
            if (tmpSum > sum)
                left++;
            else if (tmpSum < sum)
                right++;
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmp.add(i);
                }
                result.add(tmp);
                left++;
                right++;
            }
        }
        return result;
    }

    public int sum(int a, int b) {
        return ((a + b) * (b - a + 1)) >> 1;
    }

    public static void main(String[] args) {
        Q57_2 test = new Q57_2();
        int sum = 3;
        System.out.println(test.FindContinuousSequence(sum));
    }
}
