package commands;

import exceptions.RecursionException;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Класс команды execute_script.
 */
public class ExecuteScript extends Command {
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    public static boolean isFromFile = false;
    private final LinkedList<String> executedScripts = new LinkedList<>();

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
            String filePath = args.trim();
            collectionManager.executeScript(filePath, commandManager, executedScripts);
            isFromFile = false;
        } catch (NullPointerException e) {
            System.err.println("Вы не указали имя файла\n");
        }catch (FileNotFoundException e){
            System.err.println("Файл не найден\n");
        }catch (IllegalArgumentException e){
            System.err.println("Не могу прочитать файл :(\n");
        } catch (RecursionException e) {
            System.err.printf("Найдена рекурсия!\n");
        }
    }
}

