import java.util.Scanner;

public class _6_Staircase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        staircase(n);
        
    }

    public static void staircase(int n) {
        int spaceCnt = n;
        getStaircase(spaceCnt, n);

    }

    private static void getStaircase(int spaceCnt, int n) {
        if (spaceCnt < 1) {
            return;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i < spaceCnt) {
                result.append(" ");
            } else {
                result.append("#");
            }
        }
        System.out.println(result.toString());
        getStaircase(spaceCnt - 1, n);
        
    }

}
