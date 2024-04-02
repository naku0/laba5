package commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddIfMax extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    private Scanner method;
    public static boolean isFromFile;

    public AddIfMax(CollectionManager collectionManager) {
        super("add_if_max");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            if (args.trim().isEmpty()) {
                throw new NoSuchElementException("Идентификатор не указан");
            }
            long id = Long.parseLong(args.trim());
            collectionManager.addIfMax(id);
        }catch (NoSuchElementException e){
            System.out.println("Мы не нашли такого человечка, cкорее всего вы ошиблись с id");
        }
    }
}
