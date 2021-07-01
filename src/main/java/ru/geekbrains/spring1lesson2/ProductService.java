package ru.geekbrains.spring1lesson2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepositoryInterface productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return (ProductRepository) productRepository;
    }


    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getListOfProducts() {
        return productRepository.getProductsList();
    }

    public void showInfo() {
        System.out.print("Available products:\n");
        for (Product p : getListOfProducts()) {
            System.out.println(p.toString());
        }
        System.out.println("Enter 'add' or 'remove' and id");
        System.out.println("Enter 'new cart' to create new cart");
        System.out.println("To exit enter 'exit'");
        System.out.print("Enter your command: ");
    }
}
