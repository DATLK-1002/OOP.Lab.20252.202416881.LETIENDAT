package hust.soict.elitech.aims.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import hust.soict.elitech.aims.store.Store;
import hust.soict.elitech.aims.media.Media;
import hust.soict.elitech.aims.cart.Cart;

/**
 * Controller for Store view
 * Section 5.3: Code ViewStoreController.java
 */
public class ViewStoreController {
    
    @FXML
    private TableView<Media> itemTableView;
    
    @FXML
    private TableColumn<Media, Integer> idColumn;
    
    @FXML
    private TableColumn<Media, String> titleColumn;
    
    @FXML
    private TableColumn<Media, String> categoryColumn;
    
    @FXML
    private TableColumn<Media, Float> priceColumn;
    
    @FXML
    private TableColumn<Media, Integer> quantityColumn;
    
    private Store store;
    private Cart cart;
    private Stage primaryStage;
    private ItemController itemController;
    
    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        // Initialize store and cart
        store = new Store();
        cart = new Cart();
        
        // Setup table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantityAvailable"));
        
        // Load items from store
        loadStoreItems();
    }
    
    /**
     * Load items from store into the table
     */
    private void loadStoreItems() {
        ObservableList<Media> items = FXCollections.observableArrayList(store.getItemsInStore());
        itemTableView.setItems(items);
    }
    
    /**
     * Set the primary stage
     */
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    
    /**
     * Handle view item details button
     */
    @FXML
    void viewItemDetails(ActionEvent event) {
        Media selectedItem = itemTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            showItemDetails(selectedItem);
        } else {
            System.out.println("Please select an item first!");
        }
    }
    
    /**
     * Show item details in a new window
     */
    private void showItemDetails(Media item) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Item.fxml"));
            BorderPane root = loader.load();
            itemController = loader.getController();
            itemController.setItem(item, this);
            
            Stage itemStage = new Stage();
            itemStage.setScene(new Scene(root, 600, 500));
            itemStage.setTitle("Item Details - " + item.getTitle());
            itemStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Show store view (called from ItemController)
     */
    public void showStoreView() {
        // This method can be used to refresh or return to store view
        loadStoreItems();
    }
    
    /**
     * Add item to cart
     */
    public void addItemToCart(Media item, int quantity) {
        try {
            // Create a copy of the item with specified quantity
            Media cartItem = item.clone();
            for (int i = 0; i < quantity - 1; i++) {
                cart.addMedia(cartItem.clone());
            }
            cart.addMedia(cartItem);
            System.out.println("Added " + quantity + " x " + item.getTitle() + " to cart");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Handle add to cart button
     */
    @FXML
    void addToCart(ActionEvent event) {
        Media selectedItem = itemTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                cart.addMedia(selectedItem.clone());
                System.out.println("Added " + selectedItem.getTitle() + " to cart");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please select an item first!");
        }
    }
    
    /**
     * Handle view cart button
     */
    @FXML
    void viewCart(ActionEvent event) {
        System.out.println("Cart contains " + cart.getQuantity() + " items");
        System.out.println("Total cost: $" + String.format("%.2f", cart.getTotalCost()));
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
