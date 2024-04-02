package commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Help extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
        public Help(CollectionManager collectionManager) {
        super("help");
        this.collectionManager = collectionManager;

    }
    @Override
    public void execute(String args) {
        collectionManager.help();
    }
}
