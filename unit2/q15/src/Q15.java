public class Q15 {
    public static void main(String[] args) {
        int num = 10;
        int count = NumberOf1(num);
        System.out.println(count);
    }

    public static int NumberOf1(int num){
        int count = 0;
        while(num != 0){
            count++;
            //num & (num - 1) ： 可以将num二进制表示中最右边的1变为0
            num = num & (num - 1);
        }
        return count;
    }
}
