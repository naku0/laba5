package commands;

import managers.CollectionManager;
import managers.CommandManager;

import java.util.*;

public class ExecuteScript extends Command{
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    public static boolean isFromFile = false;
    private final Set<String> executedScripts = new HashSet<>();
    public ExecuteScript(CollectionManager collectionManager, CommandManager commandManager) {
        super("execute_script");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String args) {
        try {
            isFromFile = true;
            if (args.trim().isEmpty()) {
                throw new NullPointerException("Идентификатор не указан");
            }
                String filePath = System.getenv("FILE_PATH") + args.trim();
                collectionManager.executeScript(filePath, commandManager, executedScripts);
                isFromFile = false;
            }catch (NullPointerException e){
                System.err.println("Вы не указали имя файла");
            }
    }
}

