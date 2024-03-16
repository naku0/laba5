package commands;

import Exceptions.EmptyCollectionException;
import Managers.CollectionManager;

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

