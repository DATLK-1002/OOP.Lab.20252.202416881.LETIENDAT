package hust.soict.elitech.aims.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.Media;

/**
 * Controller for Cart view
 * Section 6: Code CartController.java
 */
public class CartController {
    
    @FXML
    private GridPane cartGridPane;
    
    @FXML
    private VBox cartItemsVBox;
    
    @FXML
    private Label subtotalLabel;
    
    @FXML
    private Label taxLabel;
    
    @FXML
    private Label totalLabel;
    
    private Cart cart;
    private Stage primaryStage;
    private ViewStoreController parentController;
    
    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        cart = new Cart();
        updateCartDisplay();
    }
    
    /**
     * Set cart data
     */
    public void setCart(Cart cart, Stage stage, ViewStoreController parent) {
        this.cart = cart;
        this.primaryStage = stage;
        this.parentController = parent;
        updateCartDisplay();
    }
    
    /**
     * Update cart display with current items
     */
    private void updateCartDisplay() {
        // Clear existing items
        cartGridPane.getChildren().clear();
        
        // Display cart items
        int row = 0;
        for (Media media : cart.getItemsOrdered()) {
            try {
                // Create item display
                Label itemLabel = new Label(media.getTitle() + " - $" + String.format("%.2f", media.getPrice()));
                cartGridPane.add(itemLabel, 0, row);
                
                // Add remove button
                javafx.scene.control.Button removeBtn = new javafx.scene.control.Button("Remove");
                removeBtn.setOnAction(e -> removeItem(media));
                cartGridPane.add(removeBtn, 1, row);
                
                row++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // Update totals
        updateTotals();
    }
    
    /**
     * Update total cost display
     */
    private void updateTotals() {
        double subtotal = cart.getTotalCost();
        double tax = subtotal * 0.1; // 10% tax
        double total = subtotal + tax;
        
        subtotalLabel.setText(String.format("$%.2f", subtotal));
        taxLabel.setText(String.format("$%.2f", tax));
        totalLabel.setText(String.format("$%.2f", total));
    }
    
    /**
     * Remove item from cart
     */
    private void removeItem(Media media) {
        try {
            cart.removeMedia(media);
            updateCartDisplay();
            System.out.println("Removed " + media.getTitle() + " from cart");
        } catch (Exception e) {
            System.err.println("Error removing item from cart: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Handle continue shopping button
     */
    @FXML
    void continueShopping(ActionEvent event) {
        if (primaryStage != null) {
            primaryStage.close();
        }
        if (parentController != null) {
            parentController.showStoreView();
        }
    }
    
    /**
     * Handle clear cart button
     */
    @FXML
    void clearCart(ActionEvent event) {
        cart.removeAllMedia();
        updateCartDisplay();
        System.out.println("Cart cleared");
    }
    
    /**
     * Handle checkout button
     */
    @FXML
    void checkout(ActionEvent event) {
        if (cart.getQuantity() == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        
        double subtotal = cart.getTotalCost();
        double tax = subtotal * 0.1;
        double total = subtotal + tax;
        
        System.out.println("=== CHECKOUT ===");
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Tax (10%): $" + String.format("%.2f", tax));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("Thank you for your purchase!");
        
        // Clear cart after checkout
        cart.removeAllMedia();
        updateCartDisplay();
    }
    
    /**
     * Handle exit button
     */
    @FXML
    void exit(ActionEvent event) {
        if (primaryStage != null) {
            primaryStage.close();
        }
    }
}
