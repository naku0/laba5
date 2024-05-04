package mainClasses;
import managers.CollectionManager;
import managers.CommandManager;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ваши данные сохраняются в: " + System.getenv("FILE_PATH"));
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        Input input = new Input(commandManager, collectionManager);
        input.addCommands(commandManager);
        input.addData();
        input.listen();
    }
}
