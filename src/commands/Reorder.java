package commands;

import Exceptions.EmptyCollectionException;
import Interfaces.CommandExecutor;
import Managers.CollectionManager;

public class Reorder extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public Reorder(CollectionManager collectionManager) {
        super("reorder");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            collectionManager.reorder();
        }catch (EmptyCollectionException e){
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!");
        }
    }
}
