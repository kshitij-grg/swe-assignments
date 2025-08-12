package edu.miu.cs425.exampractice.service;

import edu.miu.cs425.exampractice.dto.product.ProductRequestDTO1;
import edu.miu.cs425.exampractice.dto.product.ProductResponseDTO1;
import edu.miu.cs425.exampractice.dto.product.ProductResponseDTO2;
import edu.miu.cs425.exampractice.dto.supplier.SupplierResponseDTO2;
import edu.miu.cs425.exampractice.exception.SupplierNotFoundException;
import edu.miu.cs425.exampractice.model.Product;
import edu.miu.cs425.exampractice.model.Supplier;
import edu.miu.cs425.exampractice.repository.ProductRepository;
import edu.miu.cs425.exampractice.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<ProductResponseDTO2> getProducts() {
        return productRepository.findAll(Sort.by("name"))
                .stream()
                .map(
                        product -> new ProductResponseDTO2(
                                product.getProductId(),
                                product.getName(),
                                product.getUnitPrice(),
                                product.getQuantityInStock(),
                                product.getDateSupplied(),
                                new SupplierResponseDTO2(
                                        product.getSupplier().getSupplierId(),
                                        product.getSupplier().getName(),
                                        product.getSupplier().getContactPhoneNo()
                                )
                        )
                ).toList();
    }

    public List<ProductResponseDTO2> getProductsBySupplierId(Integer supplierId) throws SupplierNotFoundException {
        supplierRepository.findById(supplierId).orElseThrow(()-> new SupplierNotFoundException("Supplier not found " + supplierId + " not found"));
        return productRepository.findProductsBySupplier_SupplierId(supplierId)
                .stream().map(
                        product -> new ProductResponseDTO2(
                                product.getProductId(),
                                product.getName(),
                                product.getUnitPrice(),
                                product.getQuantityInStock(),
                                product.getDateSupplied(),
                                new SupplierResponseDTO2(
                                        product.getSupplier().getSupplierId(),
                                        product.getSupplier().getName(),
                                        product.getSupplier().getContactPhoneNo()
                                )
                        )).toList();
    }

    public ProductResponseDTO2 addNewProduct(ProductRequestDTO1 productRequest){
        var product = new Product(null, productRequest.name(),productRequest.unitPrice(),productRequest.quantityInStock(),productRequest.dateSupplied()
        , new Supplier(null, productRequest.supplierRequest().name(), productRequest.supplierRequest().contactPhoneNo()));

        var saveProduct = productRepository.save(product);

        return new ProductResponseDTO2(
                saveProduct.getProductId(),
                saveProduct.getName(),
                saveProduct.getUnitPrice(),
                saveProduct.getQuantityInStock(),
                saveProduct.getDateSupplied(),
                new SupplierResponseDTO2(
                        saveProduct.getSupplier().getSupplierId(),
                        saveProduct.getSupplier().getName(),
                        saveProduct.getSupplier().getContactPhoneNo()
                )
        );
    }
}
