package hust.soict.elitech.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Painter Application - Main entry point for the GUI Painter application
 * Section 3.3: Painter application
 */
public class Painter extends Application {
    
    /**
     * Start method - called when the application is launched
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Painter.fxml"));
        BorderPane root = loader.load();
        
        // Create scene
        Scene scene = new Scene(root, 800, 600);
        
        // Set stage properties
        primaryStage.setScene(scene);
        primaryStage.setTitle("Painter Application");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        
        // Show the stage
        primaryStage.show();
    }
    
    /**
     * Main method - entry point for the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
