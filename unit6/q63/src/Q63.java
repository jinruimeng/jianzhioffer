public class Q63 {
    public int maxDiff(int[] price) {
        int maxDiff = 0;
        if (price == null || price.length < 2)
            return maxDiff;

        int min = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] < min)
                min = price[i];

            int curDiff = price[i] - min;
            if (curDiff > maxDiff)
                maxDiff = curDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Q63 test = new Q63();
        int[] price = {9,11,8,5,7,12,16,14};
        System.out.println(test.maxDiff(price));
    }
}
