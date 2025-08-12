package edu.miu.cs425.exampractice.controller;

import edu.miu.cs425.exampractice.dto.supplier.SupplierResponseDTO1;
import edu.miu.cs425.exampractice.dto.supplier.SupplierResponseDTO2;
import edu.miu.cs425.exampractice.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/srm/api/v1/suppliers")
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<SupplierResponseDTO1>> listSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }
}
