import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_aVeryBigSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Long> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .toList();

        System.out.println(aVeryBigSum(numbers));

    }


    public static long aVeryBigSum(List<Long> ar) {
        return getRecursiveSum(ar, 0);
    }

    private static long getRecursiveSum(List<Long> ar, int index) {
        if (index == ar.size()) {
            return 0;
        }

        return ar.get(index) + getRecursiveSum(ar, index + 1);
    }
}
