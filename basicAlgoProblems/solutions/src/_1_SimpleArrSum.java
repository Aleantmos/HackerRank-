import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _1_SimpleArrSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        System.out.println(simpleArraySum(nums));


    }

    public static int simpleArraySum(List<Integer> nums) {
        return getSum(nums, 0);
    }

    private static int getSum(List<Integer> nums, int start) {
        if (start == nums.size()) {
            return 0;
        } else {
            Integer cur = nums.get(start);
            Integer rest = getSum(nums, start + 1);
            return cur + rest;
        }
    }



    /*public static int simpleArraySum(List<Integer> ar) {

        int sum = 0;
        for (int i = 0; i < ar.size(); i++) {
            sum += ar.get(i);
        }
        return sum;
    }*/
}
