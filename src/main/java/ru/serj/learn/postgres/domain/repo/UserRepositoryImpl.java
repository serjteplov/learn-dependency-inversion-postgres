package ru.serj.learn.postgres.domain.repo;


import ru.serj.learn.core.api.User1;
import ru.serj.learn.core.repo.UserRepository;

import java.util.Random;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    public User1 find(UUID id) {
        //реализация select * from user where user.id = ?
        System.out.println("Module postgres. Find user");
        return new User1(UUID.randomUUID(), "Alex", 900 + new Random().nextInt(100));
    }
}
