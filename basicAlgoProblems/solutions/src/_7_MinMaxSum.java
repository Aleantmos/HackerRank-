import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _7_MinMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        mergeSort(arr, arr.size());
        System.out.println();
    }

    private static void mergeSort(List<Integer> arr, int size) {
        if (size < 2) {
            return;
        }

        int mid = size/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(arr.get(i));
        }

        for (int i = mid + 1; i < size; i++) {
            right.add(arr.get(i));
        }
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        merge(arr, left, right, mid, size - mid);
    }

    private static void merge(List<Integer> arr, List<Integer> left, List<Integer> right, int leftIndex, int rightIndex) {

        int i = 0, j = 0, k = 0;

        while (i < leftIndex && j < rightIndex) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }
        while (i < leftIndex) {
            arr.set(k++, left.get(i++));
        }

        while (j < rightIndex) {
            arr.set(k++, right.get(j++));
        }
    }
}
