package ru.serj.learn.postgres.domain.repo;


import ru.serj.learn.core.model.User1;

import java.util.UUID;

public class UserRepositoryImpl {
    public User1 find(UUID id) {
        //реализация select * from user where user.id = ?
        return null;
    }
}
