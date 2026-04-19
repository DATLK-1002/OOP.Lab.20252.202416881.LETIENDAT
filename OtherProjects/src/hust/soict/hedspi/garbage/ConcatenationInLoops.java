package hust.soict.hedspi.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        int n = 10000;

        // Test 1: String with + operator
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String + operator: " + (end1 - start1) + " ms");

        // Test 2: StringBuffer
        long start2 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end2 - start2) + " ms");

        // Test 3: StringBuilder
        long start3 = System.currentTimeMillis();
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbl.append("a");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end3 - start3) + " ms");
    }
}
