import java.util.Arrays;
import java.util.Scanner;

public class _9_TimeConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        System.out.println(timeConversion(input));
    }

    public static String timeConversion(String time) {

        String result = "";

        String[] tokens = time.split(":");

        String ampm = tokens[tokens.length - 1].substring(2);

        StringBuilder output = new StringBuilder();

        int hours = Integer.parseInt(tokens[0]);

        String hoursFormatted = "";

        if (ampm.equals("PM")) {

            if (hours == 12) {
                hoursFormatted = "12";
            } else {
                hoursFormatted = String.valueOf(hours + 12);
            }
        } else {
            if (hours == 12) {
                hoursFormatted = "00";
            } else {
                hoursFormatted = String.valueOf(hours);
            }
        }

        String seconds = tokens[tokens.length - 1].substring(0, 2);

        tokens[0] = String.valueOf(hoursFormatted);

        for (int i = 0; i < tokens.length; i++) {
            if (i == tokens.length - 1) {
                output.append(seconds);
            } else {
                output.append(tokens[i]).append(":");
            }
        }
        return output.toString();
    }
}

