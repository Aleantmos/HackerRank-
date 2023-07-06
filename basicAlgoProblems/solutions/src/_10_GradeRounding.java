import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10_GradeRounding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(Integer.parseInt(scan.nextLine()));
        }

        for (Integer grade : gradingStudents(grades)) {
            System.out.println(grade);
        }

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> newGrades = new ArrayList<>();

        grades.forEach(curr -> {
            if (curr > 37) {
                int diff = 5 - (curr % 5);

                int rounded = curr;
                if (diff < 3) {
                    rounded = rounded + diff;
                }
                newGrades.add(rounded);
            } else {
                newGrades.add(curr);
            }
        });
        return newGrades;
    }
}
