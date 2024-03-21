package commands;

import Managers.CollectionManager;
import Managers.CommandManager;

import java.util.NoSuchElementException;

public class ExecuteScript extends Command{
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    public ExecuteScript(CollectionManager collectionManager, CommandManager commandManager) {
        super("execute_script");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String args) {
            if (args.trim().isEmpty()) {
                throw new NoSuchElementException("Идентификатор не указан");
            }
        String filePath = System.getenv("FILE_PATH") + args.trim();
            collectionManager.executeScript(filePath, commandManager);

    }
}
