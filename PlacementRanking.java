import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    double cgpa;
    int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Eligibility using only CGPA
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Eligibility using CGPA and coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculate composite score
    double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // Compare candidates by composite score in descending order
    public int compareTo(Candidate other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    String getName() {
        return name;
    }
}

public class PlacementRanking {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        // Shortlisting
        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(
                    candidates[i].cgpa,
                    candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Make array of exact size
        shortlisted = Arrays.copyOf(shortlisted, count);

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        // Create output
        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result + (i + 1) + ". "
                    + shortlisted[i].getName()
                    + " (" + shortlisted[i].getCompositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nFinal Ranking:");
        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}