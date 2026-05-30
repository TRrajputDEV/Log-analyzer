import java.util.Map;

public class ReportGenerator {

    /**
     * Takes the populated HashMap and prints a formatted console report.
     */
    public void printReport(Map<Integer, Integer> errorCounts) {
        System.out.println("\n=========================================");
        System.out.println("          SERVER ERROR LOG REPORT        ");
        System.out.println("=========================================");

        if (errorCounts.isEmpty()) {
            System.out.println("No errors found. Server is perfectly healthy!");
            System.out.println("=========================================\n");
            return;
        }

        // %-15s means "Format as a String, and pad with spaces to be 15 characters wide (left-aligned)"
        System.out.printf("%-15s | %-15s%n", "HTTP Status", "Occurrences");
        System.out.println("-----------------------------------------");

        int totalErrors = 0;

        // Loop through the HashMap entries
        for (Map.Entry<Integer, Integer> entry : errorCounts.entrySet()) {
            int statusCode = entry.getKey();
            int count = entry.getValue();
            totalErrors += count;

            // %-15d means "Format as an Integer, pad to 15 characters"
            System.out.printf("%-15d | %-15d%n", statusCode, count);
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total Errors Tracked: " + totalErrors);
        System.out.println("=========================================\n");
    }
}