public class Q53 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;

        int start = GetNumberOfKStart(array, 0, array.length - 1, k);
        int end = GetNumberOfKEnd(array, 0, array.length - 1, k);

        if (start == -1 || end == -1)
            return 0;
        else
            return end - start + 1;
    }

    public int GetNumberOfKStart(int[] array, int left, int right, int k) {
        int start = -1;

        if (left > right)
            return start;

        if (left == right) {
            if (array[left] == k) {
                if (left == 0 || array[left - 1] != k)
                    start = left;
            }
            return start;
        }


        int mid = (left + right) >> 1;
        if (array[mid] > k)
            start = GetNumberOfKStart(array, left, mid - 1, k);
        else if (array[mid] < k)
            start = GetNumberOfKStart(array, mid + 1, right, k);
        else if (mid != 0 && array[mid - 1] == k)
            start = GetNumberOfKStart(array, left, mid - 1, k);
        else
            start = mid;

        return start;
    }

    public int GetNumberOfKEnd(int[] array, int left, int right, int k) {
        int end = -1;

        if (left > right)
            return end;

        if (left == right) {
            if (array[left] == k) {
                if (left == array.length - 1 || array[left + 1] != k)
                    end = left;
            }
            return end;
        }


        int mid = (left + right) >> 1;
        if (array[mid] > k)
            end = GetNumberOfKEnd(array, left, mid - 1, k);
        else if (array[mid] < k)
            end = GetNumberOfKEnd(array, mid + 1, right, k);
        else if (mid != array.length - 1 && array[mid + 1] == k)
            end = GetNumberOfKEnd(array, mid + 1, right, k);
        else
            end = mid;

        return end;
    }

/*    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;

        int start = GetNumberOfKStart(array, k);
        int end = GetNumberOfKEnd(array, k);

        if (start == -1 || end == -1)
            return 0;
        else
            return end - start + 1;
    }*/

/*    public int GetNumberOfKStart(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) >> 1;
        int start = -1;

        while (left <= right) {
            if (left == right) {
                if (array[left] == k)
                    start = left;
                return start;
            }

            if (array[mid] < k) {
                left = mid + 1;
                mid = (left + right) >> 1;
            } else if (array[mid] > k) {
                right = mid - 1;
                mid = (left + right) >> 1;
            } else if (mid != 0 && array[mid - 1] == k) {
                right = mid - 1;
                mid = (left + right) >> 1;
            } else {
                start = mid;
                break;
            }
        }

        return start;
    }

    public int GetNumberOfKEnd(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) >> 1;
        int end = -1;

        while (left <= right) {
            if (left == right) {
                if (array[left] == k)
                    end = left;
                return end;
            }

            if (array[mid] < k) {
                left = mid + 1;
                mid = (left + right) >> 1;
            } else if (array[mid] > k) {
                right = mid - 1;
                mid = (left + right) >> 1;
            } else if (mid != array.length - 1 && array[mid + 1] == k) {
                left = mid + 1;
                mid = (left + right) >> 1;
            } else {
                end = mid;
                break;
            }
        }

        return end;
    }*/

    public static void main(String[] args) {
        Q53 test = new Q53();
        int[] array = {1, 3, 3, 3, 3, 4, 5};
        int k = 6;
        System.out.println(test.GetNumberOfK(array, k));
    }
}
