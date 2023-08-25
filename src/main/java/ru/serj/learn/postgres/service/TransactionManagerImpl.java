package ru.serj.learn.postgres.service;

import ru.serj.learn.application.service.TransactionManager;

public class TransactionManagerImpl implements TransactionManager {
    public void begin() {
        //реализация начала транзакции
        System.out.println("Module postgres. Transaction started");
    }

    public void commit() {
        //реализация фиксации транзакции
        System.out.println("Module postgres. Transaction committed");
    }

    public void rollback() {
        //реализация отката транзакции
        System.out.println("Module postgres. Transaction rolled back");
    }

    public boolean isActive() {
        //реализация, позволяющая определить, что есть активная транзакция
        System.out.println("Module postgres. Transaction active?");
        return true;
    }
}
