import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_CompareTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        List<Integer> b = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();


        List<Integer> result = compareTriplets(a, b);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        return recursiveCompare(a, b, 0, 0,0);

    }

    private static List<Integer> recursiveCompare(List<Integer> a, List<Integer> b, int index, int alicePoints, int bobPoints) {
        if (index == a.size()) {
            List<Integer> result = new ArrayList<>();
            result.add(alicePoints);
            result.add(bobPoints);
            return result;
        }

        if (a.get(index) > b.get(index)) {
            alicePoints++;
        } else if (a.get(index) < b.get(index)) {
            bobPoints++;
        }
        return recursiveCompare(a, b, index + 1, alicePoints, bobPoints);
    }


}
