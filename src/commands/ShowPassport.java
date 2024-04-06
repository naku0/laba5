package commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

/**
 * Класс, реализующий команду show
 */
public class ShowPassport extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public ShowPassport(CollectionManager collectionManager) {
        super("print_field_ascending_passport_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try{
        collectionManager.showData(person -> Integer.parseInt(person.getPassportID()), false);
        }catch (EmptyCollectionException e){
            System.err.println("В коллекции ещё ничего нет, но это можно исправить!");
        }
    }
}
