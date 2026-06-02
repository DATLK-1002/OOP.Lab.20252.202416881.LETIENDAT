package hust.soict.elitech.aims.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import hust.soict.elitech.aims.gui.controller.ViewStoreController;
import hust.soict.elitech.aims.store.Store;

/**
 * AIMS Store Application - Main entry point for the AIMS customer GUI application
 * Section 4-5: AIMS customer application
 * Section 8: Complete AIMS GUI app
 */
public class AimsStore extends Application {
    
    /**
     * Start method - called when the application is launched
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Load FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Store.fxml"));
            BorderPane root = loader.load();
            
            // Get controller and set primary stage
            ViewStoreController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            
            // Create scene
            Scene scene = new Scene(root, 1000, 700);
            
            // Set stage properties
            primaryStage.setScene(scene);
            primaryStage.setTitle("AIMS - Store Management System");
            primaryStage.setOnCloseRequest(e -> {
                System.out.println("AIMS Store application closed");
            });
            
            // Show the stage
            primaryStage.show();
            
            System.out.println("AIMS Store application started successfully");
        } catch (Exception e) {
            System.err.println("Error starting AIMS Store application: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Main method - entry point for the application
     */
    public static void main(String[] args) {
        System.out.println("Launching AIMS Store Application...");
        launch(args);
    }
}
