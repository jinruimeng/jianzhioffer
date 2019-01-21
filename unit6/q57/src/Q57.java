import java.util.ArrayList;

public class Q57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0)
            return result;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] > sum)
                right--;
            else if (array[left] + array[right] < sum)
                left++;
            else {
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
        }
        return result;
    }
}
