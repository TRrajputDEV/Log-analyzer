import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String logFilePath = "server_logs.txt";

        // 1. Create our objects
        LogFileReader reader = new LogFileReader();
        LogAnalyzerService service = new LogAnalyzerService();
        ReportGenerator reportGenerator = new ReportGenerator(); // New!

        // 2. Execute the data pipeline
        reader.readLogFile(logFilePath, service);

        // 3. Get the raw data from memory
        Map<Integer, Integer> finalResults = service.getErrorCounts();

        // 4. Pass the data to the presentation layer
        reportGenerator.printReport(finalResults);
    }
}