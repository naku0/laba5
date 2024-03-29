package commands;

import Exceptions.EmptyCollectionException;
import Interfaces.CommandExecutor;
import Managers.CollectionManager;

public class Shuffle extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public Shuffle(CollectionManager collectionManager) {
        super("shuffle");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            collectionManager.shuffle();
        }catch (EmptyCollectionException e){
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!");
        }
    }
}
