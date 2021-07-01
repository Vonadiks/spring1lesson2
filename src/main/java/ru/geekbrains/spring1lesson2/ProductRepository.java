package ru.geekbrains.spring1lesson2;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository implements ProductRepositoryInterface{
    private List<Product> productsList;
    public ProductRepository() {

    }

    @PostConstruct
    public void init() {
        productsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productsList.add(new Product(i, "Product" + i, BigDecimal.valueOf(Math.random() * 10).setScale(2, BigDecimal.ROUND_HALF_UP)));

        }
    }

    @Override
    public Product getProductById(int id) {
        for (Product  p : productsList) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("This id does not exist");
    }

    @Override
    public List<Product> getProductsList() {
        return productsList;
    }
}
