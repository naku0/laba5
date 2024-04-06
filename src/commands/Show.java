package commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

/**
 * Класс команды show
 */
public class Show extends Command implements CommandExecutor {
    CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            collectionManager.show();

        } catch (EmptyCollectionException e) {
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!");
        }
    }
}

