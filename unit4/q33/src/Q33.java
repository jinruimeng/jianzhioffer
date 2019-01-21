import java.util.ArrayList;

public class Q33 {
    public static void main(String[] args) {
        Q33 test = new Q33();
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        boolean result = test.VerifySquenceOfBST(sequence);
        System.out.println(result);
        ;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        } else
            return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {
        if (start >= end)
            return true;

        int rightStart = start;
        while (sequence[rightStart] < sequence[end]) {
            rightStart++;
        }

        int root = rightStart;
        while (root < end && sequence[root] > sequence[end]) {
            root++;
        }

        if (root == end) {
            return VerifySquenceOfBSTCore(sequence, start, rightStart - 1) && VerifySquenceOfBSTCore(sequence, rightStart, end - 1);
        } else
            return false;
    }
}
