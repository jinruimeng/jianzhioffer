import java.util.Arrays;

public class Q21_2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 5, 6, 6, 7, 4};
        System.out.println(Arrays.toString(array));
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return array;

        int odd = 0;
        int current = 0;

        int length = array.length;
        int even_num = 0;
        int[] even = new int[length];

        while (current < length) {
            if (isEven(array[current])) {
                even[even_num] = array[current];
                even_num++;
            } else {
                array[odd] = array[current];
                odd++;
            }
            current++;
        }
        even_num--;
        current = 0;
        while (even_num >= 0) {
            array[length - 1 - current] = even[even_num];
            even_num--;
            current++;
        }
        return array;
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
