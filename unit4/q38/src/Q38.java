import java.util.ArrayList;

public class Q38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();

        if (str == null || str.length() == 0)
            return result;
        char[] arr = str.toCharArray();

        return PermutationCore(0, arr, result);
    }

    public ArrayList<String> PermutationCore(int index, char[] arr, ArrayList<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return result;
        }

        PermutationCore(index + 1, arr, result);
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                swap(arr, index, i);
                result = PermutationCore(index + 1, arr, result);
                swap(arr, index, i);
            }
        }
        return result;
    }

    public void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
