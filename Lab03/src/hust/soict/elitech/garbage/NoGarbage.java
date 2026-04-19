package hust.soict.elitech.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("nogarbage_test", ".txt");
        try (PrintWriter pw = new PrintWriter(tempFile)) {
            for (int i = 0; i < 5000; i++) {
                pw.println("This is line number " + i);
            }
        }

        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        String result = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms, Length: " + result.length());
        tempFile.delete();
    }
}
