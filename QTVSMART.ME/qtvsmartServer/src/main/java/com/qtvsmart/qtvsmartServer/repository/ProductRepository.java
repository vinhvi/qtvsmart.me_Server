package com.qtvsmart.qtvsmartServer.repository;

import com.qtvsmart.qtvsmartServer.entity.Product;
import com.qtvsmart.qtvsmartServer.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductById(int id);
    List<Product> findByType(Type type);
}
