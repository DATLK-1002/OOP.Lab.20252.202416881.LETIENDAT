package hust.soict.elitech.garbage;

import java.io.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("garbage_test", ".txt");
        try (PrintWriter pw = new PrintWriter(tempFile)) {
            for (int i = 0; i < 5000; i++) {
                pw.println("This is line number " + i);
            }
        }

        long start = System.currentTimeMillis();
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                result = result + line + "\n";
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms, Length: " + result.length());
        tempFile.delete();
    }
}
