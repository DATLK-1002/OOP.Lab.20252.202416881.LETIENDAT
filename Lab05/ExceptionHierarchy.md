# Exception Hierarchy Tree - OOP Lab05

## Java Exception Hierarchy

```
Throwable
├── Error
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   ├── VirtualMachineError
│   └── ...
│
└── Exception
    ├── Checked Exceptions (Must be caught or declared)
    │   ├── IOException
    │   │   ├── FileNotFoundException
    │   │   ├── EOFException
    │   │   └── ...
    │   ├── ClassNotFoundException
    │   ├── SQLException
    │   ├── InterruptedException
    │   └── ...
    │
    └── Unchecked Exceptions (Runtime Exceptions)
        ├── RuntimeException
        │   ├── NullPointerException
        │   ├── ArrayIndexOutOfBoundsException
        │   ├── ClassCastException
        │   ├── NumberFormatException
        │   ├── IllegalArgumentException
        │   ├── ArithmeticException
        │   └── ...
        │
        └── Other Exceptions
            ├── CloneNotSupportedException
            ├── NoSuchMethodException
            ├── NoSuchFieldException
            └── ...
```

## Exceptions Used in AIMS Application

### 1. CloneNotSupportedException
- **Type**: Checked Exception
- **Hierarchy**: `Throwable → Exception → CloneNotSupportedException`
- **Cause**: Occurs when cloning Media objects for cart operations
- **When Thrown**: When `clone()` method is called on an object that doesn't implement Cloneable
- **Handling**: Wrap in try-catch block

### 2. NullPointerException
- **Type**: Unchecked Exception (RuntimeException)
- **Hierarchy**: `Throwable → Exception → RuntimeException → NullPointerException`
- **Cause**: Attempted to access null object
- **When Thrown**: When accessing properties or methods of null objects
- **Handling**: Use null checks before accessing objects

### 3. NumberFormatException
- **Type**: Unchecked Exception (RuntimeException)
- **Hierarchy**: `Throwable → Exception → RuntimeException → NumberFormatException`
- **Cause**: Invalid number format in user input
- **When Thrown**: When parsing invalid number strings (e.g., `Integer.parseInt("abc")`)
- **Handling**: Validate input before parsing

### 4. FileNotFoundException
- **Type**: Checked Exception
- **Hierarchy**: `Throwable → Exception → IOException → FileNotFoundException`
- **Cause**: Required file not found
- **When Thrown**: When loading FXML files or resources that don't exist
- **Handling**: Wrap in try-catch block or declare in method signature

### 5. IOException
- **Type**: Checked Exception
- **Hierarchy**: `Throwable → Exception → IOException`
- **Cause**: I/O operation failed
- **When Thrown**: During file I/O operations or resource loading
- **Handling**: Wrap in try-catch block or declare in method signature

## Exception Handling Best Practices

### 1. Try-Catch Blocks
```java
try {
    // Code that might throw exception
    Media clonedMedia = media.clone();
} catch (CloneNotSupportedException e) {
    ExceptionHandler.handleCloneNotSupportedException(e);
}
```

### 2. Null Checks
```java
if (selectedItem != null) {
    // Safe to access selectedItem
} else {
    System.out.println("Please select an item first!");
}
```

### 3. Input Validation
```java
try {
    int quantity = Integer.parseInt(userInput);
} catch (NumberFormatException e) {
    ExceptionHandler.handleNumberFormatException(e);
}
```

### 4. Resource Management
```java
try (FXMLLoader loader = new FXMLLoader(resource)) {
    // Use resource
} catch (IOException e) {
    ExceptionHandler.handleIOException(e);
}
```

### 5. Logging and Error Messages
```java
System.err.println("ERROR: " + e.getClass().getSimpleName());
System.err.println("Message: " + e.getMessage());
e.printStackTrace();
```

## Exception Hierarchy Diagram

```
                           Throwable
                          /         \
                      Error          Exception
                     /    \          /    \
                   ...    ...    Checked  Unchecked
                                /        \
                              ...    RuntimeException
                                    /    |    \
                                  ...   ...   ...
                                  
Specific to AIMS Application:

                           Exception
                          /    |    \
                    IOException  CloneNotSupportedException  RuntimeException
                    /                                        /    |    \
        FileNotFoundException                        NullPointerException
                                                    NumberFormatException
                                                    ClassCastException
```

## Summary

- **Total Exception Types in Hierarchy**: 50+
- **Checked Exceptions**: Must be caught or declared
- **Unchecked Exceptions**: Optional to catch
- **Best Practice**: Always handle exceptions gracefully and provide meaningful error messages
