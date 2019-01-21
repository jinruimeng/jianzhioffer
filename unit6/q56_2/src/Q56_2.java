public class Q56_2 {
    public int FindNumsAppearOnce(int[] array) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int i : array) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1&x2);
            x1 &= mask;
            x2 &= mask;
        }
        return  x1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,2,3,4,4,4,5,5,5,6,6,6};
        Q56_2 test = new Q56_2();
        System.out.println(test.FindNumsAppearOnce(array));
    }
}
