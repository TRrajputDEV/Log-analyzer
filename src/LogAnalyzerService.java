import java.util.HashMap;
import java.util.Map;

public class LogAnalyzerService {

    // The 'Memory' of our application: storing code -> count
    private final Map<Integer, Integer> errorCounts = new HashMap<>();

    /**
     * Processes a single log line, extracts the code, and tracks it if it's an error.
     */
    public void processLine(String logLine) {
        int statusCode = extractStatusCode(logLine);

        // We only care about client errors (400s) and server errors (500s)
        if (statusCode >= 400) {
            // getOrDefault handles checking if the key exists yet automatically!
            errorCounts.put(statusCode, errorCounts.getOrDefault(statusCode, 0) + 1);
        }
    }

    /**
     * Helper method to extract the code (from Phase 3)
     */
    private int extractStatusCode(String logLine) {
        if (logLine == null || logLine.trim().isEmpty()) {
            return -1;
        }
        try {
            String[] parts = logLine.split(" ");
            String statusCodeString = parts[parts.length - 1];
            return Integer.parseInt(statusCodeString);
        } catch (Exception e) {
            return -1; 
        }
    }

    /**
     * Exposes the final results map so other classes can read it
     */
    public Map<Integer, Integer> getErrorCounts() {
        return this.errorCounts;
    }
}