package hust.soict.elitech.aims.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Spinner;
import javafx.event.ActionEvent;
import hust.soict.elitech.aims.media.Media;

/**
 * Controller for Item details view
 * Section 5.2: Code ItemController.java
 */
public class ItemController {
    
    @FXML
    private Label itemTitleLabel;
    
    @FXML
    private Label itemIdLabel;
    
    @FXML
    private Label itemTitleValueLabel;
    
    @FXML
    private Label itemCategoryLabel;
    
    @FXML
    private Label itemPriceLabel;
    
    @FXML
    private Label itemQuantityLabel;
    
    @FXML
    private TextArea itemDescriptionArea;
    
    @FXML
    private Spinner<Integer> quantitySpinner;
    
    private Media currentItem;
    private ViewStoreController parentController;
    
    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        // Initialize spinner
        if (quantitySpinner != null) {
            quantitySpinner.setStyle("-fx-font-size: 12;");
        }
    }
    
    /**
     * Set the item to display
     */
    public void setItem(Media item, ViewStoreController parent) {
        this.currentItem = item;
        this.parentController = parent;
        
        if (item != null) {
            itemTitleLabel.setText(item.getTitle() + " - Details");
            itemIdLabel.setText(String.valueOf(item.getId()));
            itemTitleValueLabel.setText(item.getTitle());
            itemCategoryLabel.setText(item.getClass().getSimpleName());
            itemPriceLabel.setText(String.format("$%.2f", item.getPrice()));
            itemQuantityLabel.setText(String.valueOf(item.getQuantityAvailable()));
            
            // Set description based on item type
            String description = "Title: " + item.getTitle() + "\n";
            description += "Price: $" + String.format("%.2f", item.getPrice()) + "\n";
            description += "Quantity Available: " + item.getQuantityAvailable() + "\n";
            description += "\nThis is a " + item.getClass().getSimpleName() + " item from AIMS store.";
            
            itemDescriptionArea.setText(description);
        }
    }
    
    /**
     * Handle add to cart button
     */
    @FXML
    void addToCart(ActionEvent event) {
        if (currentItem != null && parentController != null) {
            int quantity = quantitySpinner.getValue();
            parentController.addItemToCart(currentItem, quantity);
            back(event);
        }
    }
    
    /**
     * Handle back button
     */
    @FXML
    void back(ActionEvent event) {
        if (parentController != null) {
            parentController.showStoreView();
        }
    }
}
