package edu.miu.cs425.exampractice.advice;

import edu.miu.cs425.exampractice.error.ErrorResponse;
import edu.miu.cs425.exampractice.exception.SupplierNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SRMWebAPIErrorHandler {
    @ExceptionHandler(SupplierNotFoundException.class)
    public ErrorResponse handleSupplierNotFoundException(SupplierNotFoundException e) {
        return new ErrorResponse(e.getMessage(), "404");
    }
}
