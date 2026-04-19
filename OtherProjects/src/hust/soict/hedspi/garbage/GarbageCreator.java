package hust.soict.hedspi.garbage;

import java.io.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        // Create a temporary file to read
        File tempFile = File.createTempFile("garbage_test", ".txt");
        try (PrintWriter pw = new PrintWriter(tempFile)) {
            for (int i = 0; i < 5000; i++) {
                pw.println("This is line number " + i + " of garbage data for testing memory.");
            }
        }

        System.out.println("Reading file using + operator (creates garbage)...");
        long start = System.currentTimeMillis();
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                result = result + line + "\n"; // Creates new String object each iteration
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Done. Time: " + (end - start) + " ms, Length: " + result.length());
        tempFile.delete();
    }
}
