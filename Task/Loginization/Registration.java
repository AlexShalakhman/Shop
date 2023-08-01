package task.Task.Loginization;
import java.io.*;
import java.nio.file.*;

public class Registration {

        public static boolean addNewClientToFile(Path filePath, String login, String password, String firstName, String lastName, double balance) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
                String previousLine = null;
                String newLine;

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        previousLine = line;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (previousLine != null) {
                    String[] lineValues = previousLine.split(",");
                    int previousId = Integer.parseInt(lineValues[0].trim());
                    int newId = previousId + 1;
                    newLine = String.format("%d,%s,%s,%s,%s,%.2f", newId, login, password, firstName, lastName, balance);
                } else {
                    // If the file is empty, start with ID 1
                    newLine = String.format("%d,%s,%s,%s,%s,%.2f", 1, login, password, firstName, lastName, balance);
                }

                writer.newLine();
                writer.write(newLine);
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
    }


