package hust.soict.elitech.gui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.util.Stack;

/**
 * Controller for the Painter application
 * Handles drawing, color selection, stroke width, and undo/redo functionality
 */
public class PainterController {
    
    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ColorPicker colorPicker;
    
    @FXML
    private Slider strokeWidthSlider;
    
    @FXML
    private Label strokeWidthLabel;
    
    // Stack for undo/redo functionality
    private Stack<Circle> undoStack;
    private Stack<Circle> redoStack;
    
    // Current drawing state
    private Color currentColor;
    private double currentStrokeWidth;
    
    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        
        // Set default color
        currentColor = Color.BLACK;
        colorPicker.setValue(currentColor);
        
        // Set default stroke width
        currentStrokeWidth = 2.0;
        strokeWidthSlider.setValue(currentStrokeWidth);
        
        // Update stroke width label when slider changes
        strokeWidthSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            currentStrokeWidth = newVal.doubleValue();
            strokeWidthLabel.setText(String.format("%.1f", currentStrokeWidth));
        });
    }
    
    /**
     * Handle clear button pressed - clear all drawings
     */
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
        undoStack.clear();
        redoStack.clear();
    }
    
    /**
     * Handle color picker changed
     */
    @FXML
    void onColorChanged(ActionEvent event) {
        currentColor = colorPicker.getValue();
    }
    
    /**
     * Handle stroke width slider changed
     */
    @FXML
    void onStrokeWidthChanged(MouseEvent event) {
        currentStrokeWidth = strokeWidthSlider.getValue();
        strokeWidthLabel.setText(String.format("%.1f", currentStrokeWidth));
    }
    
    /**
     * Handle mouse pressed on drawing area - draw immediately when mouse down
     * Exercise 3.4.1: Draw when mouse down
     */
    @FXML
    void drawingAreaMousePressed(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        Circle circle = createCircle(x, y);
        drawingAreaPane.getChildren().add(circle);
        undoStack.push(circle);
        redoStack.clear(); // Clear redo stack when new drawing is made
    }
    
    /**
     * Handle mouse dragged on drawing area - draw continuous line
     * Exercise 3.4.2: Draw with different colors
     * Exercise 3.4.3: Draw with different stroke widths
     */
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        Circle circle = createCircle(x, y);
        drawingAreaPane.getChildren().add(circle);
        undoStack.push(circle);
        redoStack.clear(); // Clear redo stack when new drawing is made
    }
    
    /**
     * Handle mouse released on drawing area
     */
    @FXML
    void drawingAreaMouseReleased(MouseEvent event) {
        // Can be used for additional functionality if needed
    }
    
    /**
     * Create a circle at the given coordinates with current color and stroke width
     */
    private Circle createCircle(double x, double y) {
        Circle circle = new Circle(x, y, currentStrokeWidth);
        circle.setFill(currentColor);
        circle.setStroke(currentColor);
        return circle;
    }
    
    /**
     * Exercise 3.4.4: Undo functionality
     * Remove the last drawn circle
     */
    @FXML
    void undoButtonPressed(ActionEvent event) {
        if (!undoStack.isEmpty()) {
            Circle circle = undoStack.pop();
            drawingAreaPane.getChildren().remove(circle);
            redoStack.push(circle);
        }
    }
    
    /**
     * Exercise 3.4.4: Redo functionality
     * Restore the last undone circle
     */
    @FXML
    void redoButtonPressed(ActionEvent event) {
        if (!redoStack.isEmpty()) {
            Circle circle = redoStack.pop();
            drawingAreaPane.getChildren().add(circle);
            undoStack.push(circle);
        }
    }
}
