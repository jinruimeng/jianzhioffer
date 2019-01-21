public class Q53_3 {
    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        int result = getNumberSameAsIndexCore(array, 0, array.length - 1);
        return result;
    }

    public int getNumberSameAsIndexCore(int[] array, int left, int right) {
        int result = -1;

        if (left > right)
            return result;

        if (left == right) {
            if (array[left] == left)
                result = left;
            return result;
        }

        int mid = (left + right) >> 1;
        if (array[mid] > mid)
            result = getNumberSameAsIndexCore(array, left, mid - 1);
        else if (array[mid] < mid)
            result = getNumberSameAsIndexCore(array, mid + 1, right);
        else
            result = mid;

        return result;
    }

    public static void main(String[] args) {
        Q53_3 test = new Q53_3();
        int[] array = {0, 3, 5, 7};
        System.out.println(test.getNumberSameAsIndex(array));
    }
}
