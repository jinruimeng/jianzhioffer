public class Q39 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        if (array.length == 1)
            return array[0];

        int left = 0;
        int right = array.length - 1;
        int mid = array.length >> 1;

        int index = partition(array, left, right);

        while (index != mid) {
            if (index < mid) {
                left = index + 1;
                index = partition(array, left, right);
            } else {
                right = index - 1;
                index = partition(array, left, index - 1);
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index])
                count++;
        }

        if (count > mid)
            return array[index];
        else
            return 0;
    }

    public int partition(int[] array, int left, int right) {
        int temp = array[left];

        int small = left;
        int big = right;

        while (small < big) {
            while (small < big && array[big] >= temp)
                big--;
            if (small < big) {
                array[small] = array[big];
                small++;
            }

            while (small < big && array[small] <= temp)
                small++;
            if (small < big) {
                array[big] = array[small];
                big--;
            }
        }

        array[small] = temp;
        return small;
    }

    public static void main(String[] args) {
        Q39 test = new Q39();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(test.MoreThanHalfNum_Solution(array));
    }
}
