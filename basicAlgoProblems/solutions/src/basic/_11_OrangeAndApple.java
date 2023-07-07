package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _11_OrangeAndApple {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] houseParams = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int houseStart = houseParams[0];
        int houseEnd = houseParams[1];

        int[] treeLocation = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int appleTreeLoc = treeLocation[0];
        int orangeTreeLoc = treeLocation[1];

        int[] fruitsCnt = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> apples = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        List<Integer> oranges = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        countApplesAndOranges(houseStart, houseEnd, appleTreeLoc, orangeTreeLoc, apples, oranges);
    }


    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        String fruit = "apples";
        checkRange(s, t, a, apples, fruit);
        fruit = "oranges";
        checkRange(s, t, b, oranges, fruit);

    }

    private static void checkRange(int s, int t, int treePosition, List<Integer> fruits, String type) {
        int fruitCnt = 0;

        for (Integer currFruit : fruits) {
            if (checkBounds(s, t, treePosition, currFruit, type)) {
                fruitCnt = fruitCnt + 1;
            }
        }


        System.out.println(fruitCnt);
    }

    private static boolean checkBounds(int s, int t, int treePosition, int element, String fruit) {
        int position = 0;
        if (fruit.equals("apples")) {
            position = element + treePosition;
        } else {
            position = treePosition + element;
        }
        return position >= s && position <= t;
    }
}

