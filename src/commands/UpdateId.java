package commands;

import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, реализующий команду update_id
 */
public class UpdateId extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    private Scanner method;

    public UpdateId(CollectionManager collectionManager) {
        super("update");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            if (args.trim().isEmpty()) {
                throw new NoSuchElementException("Идентификатор не указан\n");
            }
            long id = Long.parseLong(args.trim());
            collectionManager.updateID(id);
        }catch (NoSuchElementException e){
            System.err.println("Мы не нашли такого человечка, cкорее всего вы ошиблись с id\n");
        }catch (InvalidDataException e){
            System.err.println("Что-то не так с данными, мы не смогли создать человечка :(\n");
        }catch (NumberFormatException e){
            System.err.println("Это число не типа 'int', давайте попробуем еще раз!\n");
        }
    }
}
