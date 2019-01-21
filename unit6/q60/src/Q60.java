import org.ietf.jgss.Oid;

public class Q60 {
    private static int maxVaule = 6;

    public void probability(int n) {
        if (n <= 0)
            return;

        int[][] tmp = new int[2][maxVaule * n];
        for (int j = 0; j < maxVaule; j++)
            tmp[0][j] = 1;

        int flag = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= (maxVaule - 1) * i + 1; j++)
                for (int k = 1; k <= maxVaule && j - k >= 0; k++)
                    tmp[flag][j] += tmp[1 - flag][j - k];

            flag = 1 - flag;
        }

        int[] sum = new int[(maxVaule - 1) * n + 1];
        for (int i = 0; i < sum.length; i++){
            sum[i] = tmp[1 - flag][n - 1 + i];
            System.out.println(sum[i]);
        }

        double[] probability = new double[(maxVaule - 1) * n + 1];
        double count = Math.pow(maxVaule, n);
        for (int i = 0; i < probability.length; i++){
            probability[i] = sum[i] / count;
            System.out.println(probability[i]);
        }
    }

    public static void main(String[] args) {
        Q60 test = new Q60();
        test.probability(1);
    }
}
