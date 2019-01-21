public class Q53_2 {
    public int getMissingNumber(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        int result = getMissingNumberCore(array, 0, array.length - 1);
        return result;
    }

    public int getMissingNumberCore(int[] array, int left, int right) {
        int result = -1;

        if (left > right)
            return result;

        if (left == right) {
            if (array[left] != left) {
                result = left;
            }
            return result;
        }

        int mid = (left + right) >> 1;
        if (array[mid] == mid)
            result = getMissingNumberCore(array, mid + 1, right);
        else if (mid != 0 && array[mid - 1] != mid - 1)
            result = getMissingNumberCore(array, left, mid - 1);
        else
            result = mid;

        return result;
    }

    public static void main(String[] args) {
        Q53_2 test = new Q53_2();
        int[] array = {0,1,3};
        System.out.println(test.getMissingNumber(array));
    }
}
