package com.sms;

/**
 * Project: Student Management System
 * My names : barinda system sylvere
 * Reg No: 24rp08563
 * Description: Custom exception for handling invalid user input, especially for validation errors.
 */
public class InvalidInputException extends Exception {
    // Simple, short, and clear explanation: Custom exception for invalid data.
    public InvalidInputException(String message) {
        super(message);
    }
}
