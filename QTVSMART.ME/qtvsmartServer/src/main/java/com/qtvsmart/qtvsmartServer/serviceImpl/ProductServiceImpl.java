package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Image;
import com.qtvsmart.qtvsmartServer.entity.Product;
import com.qtvsmart.qtvsmartServer.entity.Type;
import com.qtvsmart.qtvsmartServer.repository.ProductRepository;
import com.qtvsmart.qtvsmartServer.service.ImageService;
import com.qtvsmart.qtvsmartServer.service.ProductService;
import com.qtvsmart.qtvsmartServer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private TypeService typeService;


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product;
        for (Product product1 : productRepository.findAll()) {
            product = getOneProduct(product1);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findProductById(id);
        Product product1 = getOneProduct(product);
        return product1;
    }

    @Override
    public void saveProduct(Product product) {
        Product product1 = getOneProduct(product);
        Image image;
        for (Image image1 : product.getImages()) {
            image = imageService.getOneImage(image1);
            imageService.addImage(image);
        }
        productRepository.save(product1);
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Product> getProductsByType(Type type) {
        List<Product> productList = productRepository.findByType(type);
        return productList;
    }



    @Override
    public List<Product> getBestSellingProducts() {
        return null;
    }

    @Override
    public List<Product> getPopularProducts() {
        return null;
    }

    @Override
    public List<Product> getLatestProducts() {
        return null;
    }

    @Override
    public Product getOneProduct(Product product) {
        Product product1 = new Product();
        List<Image> images = new ArrayList<>();
        Image image;
        for (Image image1 : product.getImages()) {
            image = imageService.getOneImage(image1);
            images.add(image);
        }
        product1.setImages(images);

        Type type = typeService.getTypeById(product.getType().getId());
        product1.setType(type);


        product1.setName(product.getName());

        product1.setOrigin(product.getOrigin());
        product1.setPrice(product.getPrice());
        product1.setCount(product.getCount());
        return product1;
    }

    @Override
    public List<Product> getListProduct(List<Product> productList) {
        List<Product> products = new ArrayList<>();
        Product product;
        for (Product product1 : productList) {
            product = getOneProduct(product1);
            products.add(product);
        }
        return products;
    }
}
