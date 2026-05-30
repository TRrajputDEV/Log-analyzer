# Log Analyzer

A small Java console app that reads a server log file and prints a summary of HTTP error status codes (4xx and 5xx).

## Features
- Reads a plain-text log file line by line.
- Extracts the HTTP status code from each line.
- Counts only client and server errors (>= 400).
- Prints a formatted report with totals.

## Project Structure
- src/Main.java - application entry point and pipeline wiring.
- src/LogFileReader.java - reads the log file and streams lines.
- src/LogAnalyzerService.java - parses status codes and aggregates counts.
- src/ReportGenerator.java - renders the console report.
- src/server_logs.txt - sample log data.

## Requirements
- Java 8+ (JDK).

## Run
From the project root:

```bash
cd src
javac *.java
java Main
```

The program reads `server_logs.txt` from the current working directory (`src`). If you want to run it from a different directory, update `logFilePath` in `Main.java` or pass an absolute path.

## Notes
- Lines with missing or malformed status codes are ignored.
- Counts are stored in memory and printed at the end.
