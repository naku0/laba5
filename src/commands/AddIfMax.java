package commands;

import Interfaces.CommandExecutor;
import Managers.CollectionManager;

import java.util.Collections;
import java.util.NoSuchElementException;

public class AddIfMax extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;

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
