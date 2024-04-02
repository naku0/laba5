package mainClasses;

import managers.CollectionManager;
import managers.CommandManager;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getenv("FILE_PATH"));
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        Input input = new Input(commandManager, collectionManager);
        input.addCommands(commandManager);
        input.addData();
        input.listen();

    }
}
