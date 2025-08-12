package edu.miu.cs425.exampractice.repository;

import edu.miu.cs425.exampractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsBySupplier_SupplierId(Integer supplierId);
}
