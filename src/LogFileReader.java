import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogFileReader {

    // Notice we now pass the analyzer service into this method!
    public void readLogFile(String filePath, LogAnalyzerService service) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("--- System Pipeline Initialized: Processing Logs ---");
            
            while ((line = br.readLine()) != null) {
                // Pass the raw line directly to the service's memory pipeline
                service.processLine(line);
            }
            
            System.out.println("--- System Pipeline Finished Execution ---");
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}