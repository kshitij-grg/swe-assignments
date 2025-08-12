package edu.miu.cs425.exampractice.service;

import edu.miu.cs425.exampractice.dto.product.ProductResponseDTO1;
import edu.miu.cs425.exampractice.dto.supplier.SupplierResponseDTO1;
import edu.miu.cs425.exampractice.model.Supplier;
import edu.miu.cs425.exampractice.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierResponseDTO1> getAllSuppliers() {
        return supplierRepository.findAll(
                Sort.by("name")
        ).stream().map(
                supplier -> new SupplierResponseDTO1(
                        supplier.getSupplierId(),
                        supplier.getName(),
                        supplier.getProducts().stream()
                                .map(
                                        product -> new ProductResponseDTO1(
                                                product.getProductId(),
                                                product.getName(),
                                                product.getUnitPrice()
                                                , product.getQuantityInStock(),
                                                product.getDateSupplied()

                                        )
                                ).toList()
                )
        ).toList();
    }
}
