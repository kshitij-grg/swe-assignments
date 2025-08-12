package edu.miu.cs425.exampractice.dto.supplier;

import edu.miu.cs425.exampractice.dto.product.ProductResponseDTO1;

import java.util.List;

public record SupplierResponseDTO1(
        Integer supplierId,
        String name,
        List<ProductResponseDTO1> products
) {
}
