package commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

/**
 * Класс команды clear
 */
public class Clear extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager) {
        super("clear");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        collectionManager.clear();
    }
}
