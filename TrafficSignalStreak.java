import java.util.Scanner;

public class TrafficSignalStreak {

    static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;

        int currentCount = 1;
        int longestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {

                currentCount++;

            } else {

                currentColor = signalLog.charAt(i);
                currentCount = 1;
            }

            if (currentCount > longestCount) {

                longestCount = currentCount;
                longestColor = currentColor;
            }
        }

        System.out.println(
                "Longest Streak: '"
                + longestColor
                + "' repeated "
                + longestCount
                + " times"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log (R/Y/G): ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}