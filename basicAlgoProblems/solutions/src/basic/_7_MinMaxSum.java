import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _7_MinMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int curr = Integer.parseInt(input[i]);
            arr.add(curr);
        }
        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        mergeSort(arr, 0, arr.size());
        System.out.println();
    }

    private static void mergeSort(List<Integer> arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end)/2;

        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);


        merge(arr, begin, mid, end);
    }

    private static void merge(List<Integer> arr, int begin, int mid, int end) {
        if (mid < 0 || mid >= arr.size() || arr.get(mid) < arr.get(mid + 1)) {
            return;
        }


        int left = begin;
        int right = mid;

        List<Integer> helper = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            helper.add(i, arr.get(i));
        }

        for (int i = begin; i < end; i++) {
            if (left > mid) {
                arr.set(i, helper.get(right++));
            } else if (right > end) {
                arr.set(i, helper.get(left++));
            } else if (helper.get(left) < helper.get(right)) {
                arr.set(i, helper.get(left++));
            } else {
                arr.set(i, helper.get(right++));
            }
        }
    }

}
