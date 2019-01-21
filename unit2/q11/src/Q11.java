public class Q11 {
    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 1, 2};
//        int[] array = {1, 1, 1, 1, 1};
//        int[] array = {1, 0, 1, 1, 1};
//        int[] array = {1, 1, 1, 0, 1};
//        int[] array = {1, 2, 3, 4, 5};
//        int[] array = {1, 2};
        int[] array = {2, 1};
        Integer result = findmin(array);
        System.out.println(result);
    }

    public static int findmin(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }

        if (array.length == 1) {
            return array[0];
        }

//        if (array.length == 2) {
//            return array[0] <= array[1] ? array[0] : array[1];
//        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        if (array[left] < array[right])
            return array[left];

        while (array[left] >= array[right] && (right - left) > 1) {
            mid = (left + right) / 2;
            if (array[left] == array[right] && array[left] == array[mid]) {
                int tmp = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (array[i] < tmp)
                        tmp = array[i];
                }
                return tmp;
            }
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return array[right];
    }
}
