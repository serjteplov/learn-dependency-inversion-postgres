package ru.serj.learn.postgres.domain.repo;

import ru.serj.learn.core.api.Order;
import ru.serj.learn.core.repo.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void create(Order order) {
        System.out.println("Module postgres. Order has been created");
    }
}
