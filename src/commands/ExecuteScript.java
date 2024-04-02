package commands;

import managers.CollectionManager;
import managers.CommandManager;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExecuteScript extends Command{
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    public static boolean isFromFile = false;
    public ExecuteScript(CollectionManager collectionManager, CommandManager commandManager) {
        super("execute_script");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String args) {
            isFromFile = true;
            if (args.trim().isEmpty()) {
                throw new NoSuchElementException("Идентификатор не указан");
            }
        String filePath = System.getenv("FILE_PATH") + args.trim();
            collectionManager.executeScript(filePath, commandManager);

    }
}
