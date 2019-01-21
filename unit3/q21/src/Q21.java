import java.util.Arrays;

public class Q21 {
    public static void main(String[] args) {
        int[] array = {1, 2, 1};
        System.out.println(Arrays.toString(array));
        reorderOddEvent(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reorderOddEvent(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int left = 0;
        int right = array.length - 1;
        int temp;

        while (left < right) {
            while (left < array.length && !isEven(array[left]))
                left++;

            while (right >= 0 && isEven(array[right]))
                right--;

            if (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
