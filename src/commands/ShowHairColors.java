package commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

/**
 * Класс реализующий команду "print_field_descending_hair_color"
 */
public class ShowHairColors extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;

    public ShowHairColors(CollectionManager collectionManager) {
        super("print_field_descending_hair_color");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            collectionManager.showHairColors();
        } catch (EmptyCollectionException e) {
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!\n");
        }
    }
}
