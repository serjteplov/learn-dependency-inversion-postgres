package ru.serj.learn.postgres.domain.repo;

import ru.serj.learn.core.api.Product;
import ru.serj.learn.core.repo.ProductRepository;

import java.util.Random;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository {
    public Product find(UUID id) {
        //реализация select * from product where product.id = ?
        System.out.println("Module postgres. Find product");
        return new Product(UUID.randomUUID(), "Super product", 10 + new Random().nextInt(50));
    }
}