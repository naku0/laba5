package commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;
import data.Person;

public class ShowHeight extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;

    public ShowHeight(CollectionManager collectionManager) {
        super("print_field_descending_height");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            collectionManager.showData(Person::getHeight, true);
        } catch (EmptyCollectionException e) {
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!");
        }
    }
}
