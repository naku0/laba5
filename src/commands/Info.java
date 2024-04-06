package commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

/**
 * Класс команды info
 */
public class Info extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public Info(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        collectionManager.getInfo();
    }
}
