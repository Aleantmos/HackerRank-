import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _4_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(bufferedReader.readLine());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            List<Integer> numsLine = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .toList();
            for (int j = 0; j < numsLine.size(); j++) {
                matrix.get(i).add(numsLine.get(j));
            }
        }

        System.out.println(getDiagonalDiff(matrix));
        //sumIterative(n, matrix);
    }

    private static int getDiagonalDiff(List<List<Integer>> matrix) {
      return Math.abs(diagonalSum(matrix, 0 ,0) - reverseDiagonalSum(matrix, 0, matrix.size() - 1));
    }

    private static int reverseDiagonalSum(List<List<Integer>> matrix, int row, int col) {
        if (row == matrix.size() || col < 0) {
            return 0;
        }

        return matrix.get(row).get(col) + reverseDiagonalSum(matrix, row + 1, col - 1);
    }

    private static int diagonalSum(List<List<Integer>> matrix, int row, int col) {
        if (row == matrix.size() || col == matrix.size() ) {
            return 0;
        }
        
        return matrix.get(row).get(col) + diagonalSum(matrix, row + 1, col + 1);
    }

    private static void sumIterative(Integer n, List<List<Integer>> matrix) {
        int upDownSum = 0;
        int downUpSum = 0;

        int helperCnt = n - 1;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (i == j) {
                    upDownSum += matrix.get(i).get(j);
                }
            }

            for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                if (helperCnt == j) {
                    downUpSum += matrix.get(i).get(j);
                }
            }
            helperCnt--;
        }

        System.out.println(Math.abs(upDownSum - downUpSum));
    }
}
