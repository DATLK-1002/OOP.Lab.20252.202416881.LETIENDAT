package hust.soict.elitech.aims.exception;

import java.io.IOException;

/**
 * Exception Handler for AIMS application
 * Section 9 + 10 + 11: Handle exception
 */
public class ExceptionHandler {
    
    /**
     * Handle CloneNotSupportedException
     * Occurs when cloning Media objects for cart operations
     */
    public static void handleCloneNotSupportedException(CloneNotSupportedException e) {
        System.err.println("ERROR: CloneNotSupportedException");
        System.err.println("Message: " + e.getMessage());
        System.err.println("Cause: Cannot clone media object");
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Handle NullPointerException
     * Can occur if null items are selected or accessed
     */
    public static void handleNullPointerException(NullPointerException e) {
        System.err.println("ERROR: NullPointerException");
        System.err.println("Message: " + e.getMessage());
        System.err.println("Cause: Attempted to access null object");
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Handle NumberFormatException
     * Can occur when parsing user input
     */
    public static void handleNumberFormatException(NumberFormatException e) {
        System.err.println("ERROR: NumberFormatException");
        System.err.println("Message: " + e.getMessage());
        System.err.println("Cause: Invalid number format in user input");
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Handle FileNotFoundException
     * Can occur when loading FXML files or resources
     */
    public static void handleFileNotFoundException(java.io.FileNotFoundException e) {
        System.err.println("ERROR: FileNotFoundException");
        System.err.println("Message: " + e.getMessage());
        System.err.println("Cause: Required file not found");
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Handle IOException
     * Can occur during file I/O operations
     */
    public static void handleIOException(IOException e) {
        System.err.println("ERROR: IOException");
        System.err.println("Message: " + e.getMessage());
        System.err.println("Cause: I/O operation failed");
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Generic exception handler
     */
    public static void handleException(Exception e) {
        System.err.println("ERROR: " + e.getClass().getSimpleName());
        System.err.println("Message: " + e.getMessage());
        System.err.println("Stack trace:");
        e.printStackTrace();
    }
    
    /**
     * Log error message
     */
    public static void logError(String message) {
        System.err.println("[ERROR] " + message);
    }
    
    /**
     * Log warning message
     */
    public static void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
    
    /**
     * Log info message
     */
    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
}
