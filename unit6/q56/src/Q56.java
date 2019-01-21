public class Q56 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int result1 = 0;
        int result2 = 0;
        int resultOfXOR = 0;
        for (int i : array) {
            resultOfXOR ^= i;
        }
        int firstBitIs1 = findFirstBitIs1(resultOfXOR);

        for (int i : array) {
            if (judgeBitIs1(i, firstBitIs1))
                result1 ^= i;
            else
                result2 ^= i;
        }
        num1[0] = result1;
        num2[0] = result2;
    }

    public int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    public boolean judgeBitIs1(int num, int indexBit) {
        for (int i = 1; i <= indexBit; i++) {
            num = num >> 1;
        }
        return (num & 1) == 1 ? true : false;
    }

}
