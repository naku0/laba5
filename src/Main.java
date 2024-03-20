import Managers.CollectionManager;
import Managers.CommandManager;

public class Main {
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        Input input = new Input(commandManager, collectionManager);
        input.addCommands(commandManager);
        input.addData();
        input.listen();
        /*Принтер принтер = new Принтер("Принтер");
        принтер.печатать();*/
    }
}
