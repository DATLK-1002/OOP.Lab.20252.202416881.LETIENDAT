package hust.soict.hedspi.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        // Create a temporary file to read
        File tempFile = File.createTempFile("nogarbage_test", ".txt");
        try (PrintWriter pw = new PrintWriter(tempFile)) {
            for (int i = 0; i < 5000; i++) {
                pw.println("This is line number " + i + " of data for testing memory efficiency.");
            }
        }

        System.out.println("Reading file using StringBuffer (no garbage)...");
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n"); // Reuses same StringBuffer object
            }
        }
        String result = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("Done. Time: " + (end - start) + " ms, Length: " + result.length());
        tempFile.delete();
    }
}
