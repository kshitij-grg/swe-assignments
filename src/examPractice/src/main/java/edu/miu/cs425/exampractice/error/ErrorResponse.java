package edu.miu.cs425.exampractice.error;

import edu.miu.cs425.exampractice.exception.SupplierNotFoundException;

public record ErrorResponse(String message, String error) {
}
