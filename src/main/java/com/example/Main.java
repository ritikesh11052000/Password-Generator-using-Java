package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private PasswordGenerator passwordGenerator = new PasswordGenerator();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Generator");

        // Create UI components
        Label lengthLabel = new Label("Password Length:");
        TextField lengthField = new TextField("12");
        lengthField.setPrefWidth(100);

        CheckBox lowercaseCheck = new CheckBox("Include Lowercase");
        lowercaseCheck.setSelected(true);

        CheckBox uppercaseCheck = new CheckBox("Include Uppercase");
        uppercaseCheck.setSelected(true);

        CheckBox digitsCheck = new CheckBox("Include Digits");
        digitsCheck.setSelected(true);

        CheckBox symbolsCheck = new CheckBox("Include Symbols");
        symbolsCheck.setSelected(true);

        Button generateButton = new Button("Generate Password");
        TextArea passwordArea = new TextArea();
        passwordArea.setEditable(false);
        passwordArea.setPrefRowCount(3);
        passwordArea.setWrapText(true);

        // Layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);

        grid.add(lengthLabel, 0, 0);
        grid.add(lengthField, 1, 0);
        grid.add(lowercaseCheck, 0, 1, 2, 1);
        grid.add(uppercaseCheck, 0, 2, 2, 1);
        grid.add(digitsCheck, 0, 3, 2, 1);
        grid.add(symbolsCheck, 0, 4, 2, 1);
        grid.add(generateButton, 0, 5, 2, 1);
        grid.add(passwordArea, 0, 6, 2, 1);

        VBox root = new VBox(grid);
        root.setAlignment(Pos.CENTER);

        // Event handling
        generateButton.setOnAction(e -> {
            try {
                int length = Integer.parseInt(lengthField.getText());
                boolean includeLower = lowercaseCheck.isSelected();
                boolean includeUpper = uppercaseCheck.isSelected();
                boolean includeDigits = digitsCheck.isSelected();
                boolean includeSymbols = symbolsCheck.isSelected();

                String password = passwordGenerator.generatePassword(length, includeLower, includeUpper, includeDigits, includeSymbols);
                passwordArea.setText(password);
            } catch (NumberFormatException ex) {
                passwordArea.setText("Invalid length. Please enter a number.");
            } catch (IllegalArgumentException ex) {
                passwordArea.setText(ex.getMessage());
            }
        });

        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
