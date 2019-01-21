public class Q39_2 {
    public static void main(String[] args) {
        Q39_2 test = new Q39_2();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(test.MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("输入参数有误！");

        int num = array[0];
        int time = 1;

        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                num = array[i];
                time = 1;
                continue;
            }
            if (array[i] == num)
                time++;
            else time--;
        }

        time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                time++;
        }
        if (time > (array.length >> 1))
            return num;
        else
            return 0;
    }
}
