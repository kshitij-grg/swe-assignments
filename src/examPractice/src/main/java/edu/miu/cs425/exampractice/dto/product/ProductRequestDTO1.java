package edu.miu.cs425.exampractice.dto.product;

import edu.miu.cs425.exampractice.dto.supplier.SupplierRequestDTO1;

import java.time.LocalDate;

public record ProductRequestDTO1 (
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied,
        SupplierRequestDTO1 supplierRequest
){
}
