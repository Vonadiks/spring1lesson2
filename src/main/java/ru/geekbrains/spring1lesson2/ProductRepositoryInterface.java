package ru.geekbrains.spring1lesson2;
import java.util.List;

public interface ProductRepositoryInterface {
    Product getProductById(int id);
    List<Product> getProductsList();
}
