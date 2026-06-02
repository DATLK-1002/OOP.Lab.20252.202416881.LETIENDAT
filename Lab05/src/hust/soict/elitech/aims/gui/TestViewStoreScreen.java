package hust.soict.elitech.aims.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import hust.soict.elitech.aims.gui.controller.ViewStoreController;
import hust.soict.elitech.aims.store.Store;

/**
 * Test View Store Screen
 * Section 5.4: Test View Store Screen
 */
public class TestViewStoreScreen extends Application {
    
    private static Store store;
    
    /**
     * Start method - called when the application is launched
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
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
        primaryStage.setTitle("AIMS - Test Store Management System");
        
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
