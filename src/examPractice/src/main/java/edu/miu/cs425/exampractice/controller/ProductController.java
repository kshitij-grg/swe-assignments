package edu.miu.cs425.exampractice.controller;

import edu.miu.cs425.exampractice.dto.product.ProductRequestDTO1;
import edu.miu.cs425.exampractice.dto.product.ProductResponseDTO2;
import edu.miu.cs425.exampractice.exception.SupplierNotFoundException;
import edu.miu.cs425.exampractice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/srm/api/v1/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ProductResponseDTO2>> listProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(value = "/get/supplier/{supplierId}")
    public ResponseEntity<List<ProductResponseDTO2>> getProductsBySupplierId(@PathVariable Integer supplierId) throws SupplierNotFoundException {
        return ResponseEntity.ok(productService.getProductsBySupplierId(supplierId));
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductResponseDTO2> addNewProduct(@Valid @RequestBody ProductRequestDTO1 newProduct) {
        return new ResponseEntity<>(productService.addNewProduct(newProduct), HttpStatus.CREATED);
    }
}
