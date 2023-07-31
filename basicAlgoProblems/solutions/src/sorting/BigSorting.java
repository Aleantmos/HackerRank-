package sorting;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class BigSorting {

    /// todo: Totally not working... DEBUG or die

    public static List<BigInteger> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> unsorted = new ArrayList<>();

        int inputCnt = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < inputCnt; i++) {
            String num = scan.nextLine();
            unsorted.add(num);
        }

        /*unsorted.sort((a,b) -> a.compareTo(b));

        List<String> sorted = new ArrayList<>();

        for (BigInteger bigInteger : unsorted) {
            sorted.add(bigInteger.toString());
        }*/


        /*for (int i = 0; i < inputCnt; i++) {
            Random random = new Random();
            String randomNumber = String.valueOf(random.nextInt(inputCnt));
            unsorted.add(randomNumber);
        }*/

        List<String> result = bigSorting(unsorted);

        for (String s : unsorted) {
            System.out.println(s.toString());
        }

    }


    public static List<String> bigSorting(List<String> unsorted) {

        List<BigInteger> arr = new ArrayList<>();

        for (String element : unsorted) {
            arr.add(new BigInteger(element));
        }
        /*
        for (int i = 0; i < unsorted.size(); i++) {
            arr.set(i, new BigInteger(unsorted.get(i)));
        }
        */
        sort(arr);

        List<String> sorted = new ArrayList<>();

        for (BigInteger bigInteger : arr) {
            sorted.add(bigInteger.toString());
        }

        return sorted;
    }

    private static void sort(List<BigInteger> arr) {
        int arrSize = arr.size();

        if (arrSize < 2) {
            return;
        }

        int mid = arrSize / 2;
        List<BigInteger> left = new ArrayList<>();
        List<BigInteger> right = new ArrayList<>();


        for (int i = 0; i < mid; i++) {
            left.add(i, arr.get(i));
        }

        for (int i = mid; i < arrSize; i++) {
            right.add(i - mid, arr.get(i));
        }

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    private static void merge(List<BigInteger> arr, List<BigInteger> left, List<BigInteger> right) {
        int leftSize = left.size();
        int rightSize = right.size();

        int l = 0;
        int r = 0;
        int k = 0;

        while (l < leftSize && r < rightSize) {
            BigInteger first = left.get(l);
            BigInteger second = right.get(r);
            if (first.compareTo(second) < 0) {
                result.set(k, first);
                l++;
            } else {
                result.set(k, second);
                r++;
            }
            k++;
        }
        while (l < leftSize) {
            result.set(k, left.get(l));
            l++;
            k++;
        }

        while (r < rightSize) {
            result.set(k, right.get(r));
            r++;
            k++;
        }
    }
}
    /*private static void sort(List<String> arr) {
        int arrSize = arr.size();

        for (int i = 0; i <= arrSize - 2; i++) {
            int k = i + 1;
            while (k <= arrSize - 1) {
                BigInteger first = new BigInteger(arr.get(i));
                BigInteger second = new BigInteger(arr.get(k));
                if (first.compareTo(second) > 0) {
                    swapNums(arr, i, k);
                }
                k++;
            }
        }
    }

    private static void swapNums(List<String> arr, int i, int k) {
        String temp = arr.get(i);
        arr.set(i, arr.get(k));
        arr.set(k, temp);
    }*/


