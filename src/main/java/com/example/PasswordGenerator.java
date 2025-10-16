package com.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                   boolean includeDigits, boolean includeSymbols) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive");
        }

        StringBuilder charPool = new StringBuilder();
        if (includeLowercase) charPool.append(LOWERCASE);
        if (includeUppercase) charPool.append(UPPERCASE);
        if (includeDigits) charPool.append(DIGITS);
        if (includeSymbols) charPool.append(SYMBOLS);

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }
}
