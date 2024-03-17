import Managers.CollectionManager;
import Managers.CommandManager;
import commands.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private final CommandManager commandManager;
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);

    public Input(CommandManager commandManager, CollectionManager collectionManager) {
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
    }

    public void listen() throws NoSuchElementException {
        while (true) {
            try {
                String CommandToSplit = (scanner.nextLine().trim() + " ").toLowerCase();
                String[] command = CommandToSplit.split(" ", 2);
                commandManager.execute(command[0], command[1]);
            } catch (NoSuchElementException e) {
                System.out.println("За что ты меня так :(");
                System.exit(0);
            }
        }
    }

    public void addCommands(CommandManager commandManager) {
        System.out.println("Введите команду 'help' для того, чтобы вывести все доступные команды.");
        commandManager.addCommand(new Exit());
        commandManager.addCommand(new Help());
        commandManager.addCommand(new Add(this.collectionManager));
        commandManager.addCommand(new Show(this.collectionManager));
        commandManager.addCommand(new Info(this.collectionManager));
        commandManager.addCommand(new RemoveElementById(this.collectionManager));
        commandManager.addCommand(new ShowPassport(this.collectionManager));
        commandManager.addCommand(new ShowHeight(this.collectionManager));
    }
}
