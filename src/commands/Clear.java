package commands;

import Interfaces.CommandExecutor;
import Managers.CollectionManager;
import Managers.CommandManager;

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
