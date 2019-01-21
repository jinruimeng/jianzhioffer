import com.sun.org.apache.regexp.internal.RE;

public class Q50 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;

        int[] position = new int[256];

        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        for (int j = 0; j < str.length(); j++) {
            int cur = str.charAt(j);
            if (position[cur] == -1)
                position[cur] = j;
            else
                position[cur] = -2;
        }

        int result = str.length();
        for (int curPositopn : position) {
            if (curPositopn >= 0 && result > curPositopn)
                result = curPositopn;
        }

        if (result == str.length())
            return -1;
        else
            return result;
    }
}
