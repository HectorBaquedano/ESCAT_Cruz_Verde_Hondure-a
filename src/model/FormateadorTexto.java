/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author Hector Baquedano
 */
public class FormateadorTexto {
    
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("\\d{4}-\\d{4}");//\\d{0,4}-\\d{0,4}
    private static final Pattern DNI_PATTERN = Pattern.compile("\\d{0,4}-\\d{0,4}-\\d{0,5}");
    
    public static void setupTextField(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains(" ")) {
                textField.setText(oldValue);
            }
        });
    }

    public static void TelefonoFormatter(TextField textField) {
        
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            System.out.println(newText);
            if (TELEFONO_PATTERN.matcher(newText).matches() || newText.isEmpty()) {
                return change;
            } else {
                return null;
            }
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }
    
   
    public static TextFormatter<String> DniFormatter() {
     
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (isValidInput(newText) || newText.isEmpty()) {
                return change;
            } else {
                return null;
            }
        };

        return new TextFormatter<>(filter);
    }

    private static boolean isValidInput(String newText) {
        return DNI_PATTERN.matcher(newText).matches();
    }    
}
