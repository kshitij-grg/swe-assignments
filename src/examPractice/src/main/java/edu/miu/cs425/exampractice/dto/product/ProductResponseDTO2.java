package edu.miu.cs425.exampractice.dto.product;

import edu.miu.cs425.exampractice.dto.supplier.SupplierResponseDTO2;

import java.time.LocalDate;

public record ProductResponseDTO2(
        Long productId,
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied,
        SupplierResponseDTO2 supplier
) {
}
