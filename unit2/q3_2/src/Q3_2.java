public class Q3_2 {
    public static void main(String[] args) {

        int[] number = {2, 3, 1, 0, 2, 5, 3};
        int result = duplicate(number);
        System.out.println(result);
    }

    public static int duplication;

    public static int duplicate(int[] number) {
        if (number == null || number.length == 0) {
            return -1;
        }

        for (int num : number
        ) {
            if (num < 0 || num >= number.length)
                return -1;
        }

        int start = 1;
        int end = number.length - 1;
        int mid = 0;
        int count = 0;

        while (start <= end) {
            if (start == end) {
                count = countRange(number, start, end);
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            mid = (start + end) / 2;
            count = countRange(number, start, mid);
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] number, int start, int end) {
        int count = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= start && number[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
