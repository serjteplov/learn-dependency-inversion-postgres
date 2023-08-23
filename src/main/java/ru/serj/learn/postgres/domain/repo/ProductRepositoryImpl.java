package ru.serj.learn.postgres.domain.repo;

import ru.serj.learn.core.model.Product;

import java.util.UUID;

public class ProductRepositoryImpl {
    public Product find(UUID id) {
        //реализация select * from product where product.id = ?
        return null;
    }
}