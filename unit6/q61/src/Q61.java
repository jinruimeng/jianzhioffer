public class Q61 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5)
            return false;

        sort(numbers, 0, numbers.length - 1);

        int count0 = 0;
        int index = 0;

        for (; index < numbers.length; index++) {
            if (numbers[index] == 0)
                count0++;
            else break;
        }

        index++;
        for (; index < numbers.length; index++) {
            if (numbers[index] == numbers[index - 1])
                return false;
            else
                count0 = numbers[index] - numbers[index - 1] - 1;
        }

        if (count0 >= 0)
            return true;
        else
            return false;
    }

    public void sort(int[] numbers, int left, int right) {
        if (left >= right)
            return;

        int key = numbers[left];
        int small = left;
        int big = right;
        while (left < right) {
            while (numbers[right] >= key && left < right)
                right--;

            if (left < right)
                numbers[left] = numbers[right];

            while (numbers[left] < key && left < right)
                left++;

            if (left < right)
                numbers[right] = numbers[left];
        }
        numbers[left] = key;

        sort(numbers, small, left - 1);
        sort(numbers, left + 1, big);
    }

    public static void main(String[] args) {
        Q61 test = new Q61();
        int[] numbers = {1, 3, 2, 5, 4};
//        test.sort(numbers, 0, numbers.length - 1);
//        for (int number : numbers) {
//            System.out.print(number + ",");
//        }
        System.out.println(test.isContinuous(numbers));
    }
}
