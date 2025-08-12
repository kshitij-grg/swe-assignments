package edu.miu.cs425.exampractice.dto.product;

import java.time.LocalDate;

public record ProductResponseDTO1(
        Long productId,
        String name,
        Double unitPrice,
        Integer quantityInStock,
        LocalDate dateSupplied
) {
}
