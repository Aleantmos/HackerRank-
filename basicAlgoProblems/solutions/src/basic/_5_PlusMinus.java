import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _5_PlusMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());

        List<Integer> arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        double[] cnt = new double[3];
        getCounts(arr, cnt, 0);

        for (double v : cnt) {
            double result = v /arr.size();
            System.out.printf("%.5f%n", result);
        }
    }

    private static void getCounts(List<Integer> arr, double[] cnt, int start) {
        if (start == arr.size()) {
            return;
        }
        Integer curr = arr.get(start);

        if (curr > 0) {
            cnt[0] += 1;
        } else if (curr < 0) {
            cnt[1] += 1;
        } else {
            cnt[2] += 1;
        }

        getCounts(arr, cnt,start + 1);
    }
}
