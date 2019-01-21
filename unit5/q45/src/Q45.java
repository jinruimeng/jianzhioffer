public class Q45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        sort(numbers, 0, numbers.length - 1);

        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            result.append(number);
        }

        return result.toString();
    }

    public void sort(int[] numbers, int left, int right) {
        if (left >= right)
            return;

        int curIndex = Partition(numbers, left, right);
        sort(numbers, left, curIndex - 1);
        sort(numbers, curIndex + 1, right);
    }

    public int Partition(int[] numbers, int left, int right) {
        int tmp = numbers[left];

        while (left < right) {
            while (left < right && isSmall(tmp, numbers[right]))
                right--;
            if (left < right) {
                numbers[left] = numbers[right];
                left++;
            }

            while (left < right && isSmall(numbers[left], tmp))
                left++;
            if(left < right){
                numbers[right] = numbers[left];
                right--;
            }
        }

        numbers[left] = tmp;
        return left;
    }

    public boolean isSmall(int a, int b) {
        String ab = a + "" + b;
        String ba = b + "" + a;

        for (int i = 0; i < ab.length(); i++) {
            if (ab.charAt(i) < ba.charAt(i)) {
                return true;
            } else if (ab.charAt(i) > ba.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
