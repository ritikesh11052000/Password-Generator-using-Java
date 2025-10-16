package com.example;

public class TestPasswordGenerator {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        // Test password generation
        String password = generator.generatePassword(12, true, true, true, true);
        System.out.println("Generated Password: " + password);

        // Test with different options
        String simplePassword = generator.generatePassword(8, true, false, false, false);
        System.out.println("Simple Password (lowercase only): " + simplePassword);
    }
}
