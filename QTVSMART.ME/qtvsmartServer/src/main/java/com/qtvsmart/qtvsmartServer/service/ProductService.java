package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Inventory;
import com.qtvsmart.qtvsmartServer.entity.Product;
import com.qtvsmart.qtvsmartServer.entity.Type;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void saveProduct(Product product);

    void deleteProduct(int id);

    List<Product> getProductsByType(Type type);

    List<Product> getProductsByInventory(Inventory inventory);

    List<Product> getBestSellingProducts();

    List<Product> getPopularProducts();

    List<Product> getLatestProducts();

    Product getOneProduct(Product product);

    List<Product> getListProduct(List<Product> productList);

}
