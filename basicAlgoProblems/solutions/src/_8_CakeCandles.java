import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _8_CakeCandles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] input = scan.nextLine().split("\\s+");

        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            candles.add(Integer.parseInt(input[i]));
        }

        System.out.println(birthdayCakeCandles(candles));

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int tallest = 0;
        int cnt = 0;

        int[] result = getTallestCnt(candles, 0, tallest, cnt);
        return result[1];
    }

    private static int[] getTallestCnt(List<Integer> candles, int start, int tallest, int cnt) {
        if (start == candles.size()) {
            int[] result = new int[2];
            result[0] = tallest;
            result[1] = cnt;
            return result;
        }

        Integer curr = candles.get(start);

        if (curr > tallest) {
            tallest = curr;
            cnt = 1;
        } else if (curr == tallest) {
            cnt = cnt + 1;
        }

        return getTallestCnt(candles, ++start, tallest, cnt);
    }
}
