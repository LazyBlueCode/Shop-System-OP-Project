package Asaf_Banani_Oz_Yosef_Yochai;

import java.util.InputMismatchException;

public class ExceptionUtill extends Exception {

    public void checkStringInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()|| input.contains(" ")) {
            throw new IllegalArgumentException("Input cannot be null or empty or more than one space");
        }
        if (!input.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Input contains invalid characters");
    }

    public void checkSentenceInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty or more than one space");
        }
        if (!input.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("Input contains invalid characters");
    }
    public void checkPasswordInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()|| input.contains(" ")) {
            throw new IllegalArgumentException("Password cannot be null or empty or more than one space");
        }
        if(input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Password must contain numbers and letters.");
        }
        else if(input.matches("[0-9]+")) {
            throw new IllegalArgumentException("Password must contain numbers and letters.");
        }
    }
    public void checkAddressInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if(!input.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException("Address contains only letters and numbers");
        }
    }
    public void checkAnswerInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Answer cannot be null or empty");
        }
        if(!input.equalsIgnoreCase("n")&!input.equalsIgnoreCase("y")) {
            throw new IllegalArgumentException("Answer must contain y/n");
        }
    }
    public void checkCategoryInput(String input) throws IllegalArgumentException {
        Category.valueOf(input);
    }
    public void checkDoubleInput(String input) throws NumberFormatException {
         Double.parseDouble(input);
    }
    public void checkIntegerInput(String input) throws NumberFormatException {
        Integer.parseInt(input);
    }
    public void checkMenuInput(String input) throws InputMismatchException{
        if(input == null || input.trim().isEmpty()) {
            throw new InputMismatchException("Option cannot empty.");
        }
        else if(!input.matches("[0-9]+")) {
            throw new InputMismatchException("Input must contains only numbers.");
        }
        int number = Integer.parseInt(input);
        if (number < 0 || number > 9) {
            throw new InputMismatchException("Option must be between 0 and 9.");
        }
    }
    public void checkCartInput(Cart input) throws InputMismatchException{
        if(input == null) {
            throw new InputMismatchException("Option cannot empty.");
        }
        else{
            for (int i = 0; i < input.getProducts().length; i++) {
                if (input.getProducts()[i] != null) {
                    return;
                }
            }
            throw new InputMismatchException("Cart is empty.");
        }
    }
    public void checkHistoryCartInput(Buyers buyer, int index) throws IndexOutOfBoundsException {
        if (index < 1 || index > buyer.getHistory().length) {
            throw new IndexOutOfBoundsException("Invalid Cart number. ");
        }
    }




}
