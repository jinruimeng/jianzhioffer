public class Q3 {

    public static void main(String[] args) {

        int[] number = {2, 3, 1, 0, 2, 5, 3};
        boolean result = duplicate(number);
        System.out.println(result);
    }

    public static int duplication;

    public static boolean duplicate(int[] number) {
        if (number == null || number.length == 0) {
            return false;
        }

        for (int num : number) {
            if (num < 0 || num >= number.length)
                return false;
        }

        for (int i = 0; i < number.length; i++) {
            while (number[i] != i) {
                if (number[i] != number[number[i]]) {
                    int temp = number[i];
                    number[i] = number[temp];
                    number[temp] = temp;
                } else {
                    duplication = number[i];
                    System.out.println(duplication);
                    return true;
                }
            }
        }

        return false;
    }
}
