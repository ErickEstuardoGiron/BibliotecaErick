package com.api.biblioteca.exception;

public class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    // Getter y Setter
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
