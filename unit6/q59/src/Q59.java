import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q59 {
    public ArrayList<Integer> maxInWindows(int[] array, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0 || size < 1 || size > array.length)
            return result;

        Queue<Integer> maxInWindws = new LinkedList<>();

        for (int i = 0; i < size - 1; i++) {
            while (!maxInWindws.isEmpty() && array[i] > ((LinkedList<Integer>) maxInWindws).peekLast())
                ((LinkedList<Integer>) maxInWindws).pollLast();
            maxInWindws.add(array[i]);
        }

        int end = size - 1;
        while (end < array.length) {
            while (!maxInWindws.isEmpty() && array[end] > ((LinkedList<Integer>) maxInWindws).peekLast())
                ((LinkedList<Integer>) maxInWindws).pollLast();
            maxInWindws.add(array[end]);

            int tmpMax = maxInWindws.peek();
            result.add(tmpMax);
            if (!maxInWindws.isEmpty() && array[end - size + 1] == tmpMax)
                maxInWindws.poll();

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        Q59 test = new Q59();
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = test.maxInWindows(array, 4);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

}
