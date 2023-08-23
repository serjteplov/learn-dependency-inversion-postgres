package ru.serj.learn.postgres.service;

import ru.serj.learn.core.model.CreateOrderContext;
import ru.serj.learn.core.model.Product;
import ru.serj.learn.core.model.User1;
import ru.serj.learn.core.service.CreateOrderObserver;
import ru.serj.learn.postgres.domain.repo.OrderRepositoryImpl;
import ru.serj.learn.postgres.domain.repo.ProductRepositoryImpl;
import ru.serj.learn.postgres.domain.repo.UserRepositoryImpl;

import java.util.UUID;

public class CreateOrderObserverImpl implements CreateOrderObserver {
    private final TransactionManagerImpl transactionManagerImpl;
    private final UserRepositoryImpl userRepository;
    private final ProductRepositoryImpl productRepository;
    private final OrderRepositoryImpl orderRepository;
    private final ThreadLocal<Long> transactionId = new ThreadLocal<>();

    public CreateOrderObserverImpl(TransactionManagerImpl transactionManagerImpl,
                                   UserRepositoryImpl userRepository,
                                   ProductRepositoryImpl productRepository,
                                   OrderRepositoryImpl orderRepository
    ) {
        this.transactionManagerImpl = transactionManagerImpl;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void onStart(CreateOrderContext context) {
        long txId = transactionManagerImpl.begin();
        transactionId.set(txId);
        User1 user = userRepository.find(context.getRequest().getUserId());
        Product product = productRepository.find(context.getRequest().getProductId());
        context.setUser(user);
        context.setProduct(product);
    }

    @Override
    public void onEnd(CreateOrderContext context) {
        orderRepository.create(context.getOrder());
        transactionManagerImpl.commit(transactionId.get());
    }
}
