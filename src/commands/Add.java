package commands;

import builder.PersonBuilder;
import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.io.InputStream;
import java.util.Scanner;

public class Add extends Command implements CommandExecutor {
    public static boolean isFromFile = false;
    private Scanner method;
    private final CollectionManager collectionManager;

    /**
     * Конструктор команды "add"
     * @param collectionManager
     */
    public Add(CollectionManager collectionManager) {
        super("add");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
        collectionManager.add(new PersonBuilder().create());
        System.out.println("Человек успешно добавлен!");
        }catch (InvalidDataException e){
            System.err.println("Что-то пошло не так, попробуй ещё раз!");
        }
    }
}
