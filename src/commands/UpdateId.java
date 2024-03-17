package commands;

import Builder.PersonBuilder;
import Exceptions.InvalidDataException;
import Interfaces.CommandExecutor;
import Managers.CollectionManager;
import data.Person;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UpdateId extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;

    public UpdateId(CollectionManager collectionManager) {
        super("update");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            if (args.trim().isEmpty()) {
                throw new NoSuchElementException("Идентификатор не указан");
            }
            long id = Long.parseLong(args.trim());
            collectionManager.updateID(id);
        }catch (NoSuchElementException e){
            System.err.println("Мы не нашли такого человечка, cкорее всего вы ошиблись с id");
        }catch (InvalidDataException e){
            System.err.println("Что-то не так с данными, мы не смогли создать человечка :(");
        }catch (NumberFormatException e){
            System.err.println("Это число не типа 'int', давайте попробуем еще раз!");
        }
    }
}
