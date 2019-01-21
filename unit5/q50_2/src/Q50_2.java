public class Q50_2 {
    int[] position = new int[256];
    int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (position[ch] == 0)
            position[ch] = index;
        else
            position[ch] = -1;
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minPosition = index;
        char result = '#';

        for (int i = 0; i < position.length; i++) {
            if (position[i] > 0 && minPosition > position[i]) {
                minPosition = position[i];
                result = (char) i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q50_2 test = new Q50_2();
        String str = "helloworld";

        for (int i = 0; i < str.length(); i++) {
            test.Insert(str.charAt(i));
            System.out.println(test.FirstAppearingOnce());
        }
    }
}
