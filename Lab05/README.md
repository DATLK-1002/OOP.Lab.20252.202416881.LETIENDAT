# OOP Lab 05: GUI Programming with JavaFX and Exception Handling

## Project Structure

```
Lab05/
├── src/
│   ├── module-info.java                          # JavaFX module configuration
│   ├── hust/soict/elitech/
│   │   ├── gui/
│   │   │   ├── Painter.java                      # Painter Application (Section 3.3)
│   │   │   └── PainterController.java            # Painter Controller (Section 3.2)
│   │   └── aims/
│   │       └── gui/
│   │           ├── AimsStore.java                # AIMS Store Application (Section 4-5)
│   │           └── controller/
│   │               ├── ViewStoreController.java  # Store View Controller (Section 5.3)
│   │               └── ItemController.java       # Item Details Controller (Section 5.2)
├── resources/
│   ├── Painter.fxml                              # Painter UI Layout (Section 3.1)
│   ├── Store.fxml                                # Store UI Layout (Section 5.1)
│   └── Item.fxml                                 # Item Details UI Layout (Section 5.2)
├── bin/                                          # Compiled classes
├── .classpath                                    # Eclipse classpath configuration
├── .project                                      # Eclipse project configuration
├── answers.txt                                   # Answers to lab questions
└── README.md                                     # This file
```

## Requirements

- Java 21 or higher
- JavaFX SDK 21 or higher
- Eclipse IDE with e(fx)clipse plugin (optional, for development)
- JavaFX Scene Builder (optional, for UI design)

## Setup Instructions

### 1. Configure JavaFX in Eclipse

1. Download JavaFX SDK from https://gluonhq.com/products/javafx/
2. In Eclipse: Project → Properties → Java Build Path → Add Library → User Library
3. Create a new user library named "JavaFX" and add the JavaFX SDK jars
4. Add the library to the project's build path

### 2. Configure Module Path

If using Java modules, ensure the `module-info.java` file is in the src folder with:
```java
module Lab05 {
    requires javafx.controls;
    requires javafx.fxml;
    opens hust.soict.elitech.gui to javafx.fxml;
    opens hust.soict.elitech.aims.gui to javafx.fxml;
}
```

## Running the Applications

### Run Painter Application (Section 3)

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml \
     hust.soict.elitech.gui.Painter
```

Or in Eclipse: Right-click Painter.java → Run As → Java Application

### Run AIMS Store Application (Section 4-5)

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml \
     hust.soict.elitech.aims.gui.AimsStore
```

Or in Eclipse: Right-click AimsStore.java → Run As → Java Application

## Features Implemented

### Section 3: Painter Application

- **3.1**: FXML layout with BorderPane (left menu, center drawing area)
- **3.2**: PainterController with drawing functionality
- **3.3**: Painter application class to launch the GUI
- **3.4**: Improvements:
  - Exercise 3.4.1: Draw when mouse is pressed (not just dragged)
  - Exercise 3.4.2: Color picker for drawing with different colors
  - Exercise 3.4.3: Stroke width slider to change brush size
  - Exercise 3.4.4: Undo/Redo functionality using stacks

### Section 4-5: AIMS Customer Application

- **4**: Package structure for AIMS GUI application
- **5.1**: Store.fxml with TableView displaying all items
- **5.2**: Item.fxml with detailed item information and ItemController
- **5.3**: ViewStoreController managing store view and cart operations

## Key JavaFX Concepts Used

1. **FXML**: Declarative XML-based UI definition
2. **Scene Builder**: Visual layout design tool
3. **Containers**: BorderPane, VBox, HBox for layout
4. **Controls**: Button, Label, ColorPicker, Slider, Spinner, TableView
5. **Event Handling**: Mouse events, Action events
6. **Property Binding**: TableView columns bound to object properties
7. **Shapes**: Circle for drawing
8. **Collections**: ObservableList for data binding
9. **Styling**: CSS-like styling for UI controls
10. **Exception Handling**: Try-catch blocks for error handling

## Exception Handling

The application handles the following exceptions:

- **CloneNotSupportedException**: When cloning Media objects
- **NullPointerException**: When accessing null objects
- **IOException**: When loading FXML files
- **FileNotFoundException**: When resources are not found

## Testing

To test the applications:

1. **Painter Application**:
   - Click on the canvas to draw circles
   - Drag the mouse to draw continuous lines
   - Use the color picker to change drawing color
   - Use the slider to adjust brush size
   - Click Undo/Redo to undo/redo drawings
   - Click Clear to clear all drawings

2. **AIMS Store Application**:
   - View all items in the store table
   - Select an item and click "View Item Details" to see details
   - Add items to cart from the details view
   - View cart to see total items and cost
   - Click Exit to close the application

## Notes

- The Painter application stores all drawn shapes in a stack for undo/redo functionality
- The AIMS Store application loads items from the Store class
- FXML files must be placed in the resources folder and properly referenced in the code
- The controller class must be specified in the FXML file using the `fx:controller` attribute

## Author

Student ID: 202416881
Lab: OOP Lab 05 - GUI Programming with JavaFX and Exception Handling
Date: June 2026
