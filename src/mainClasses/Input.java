package mainClasses;

import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;
import commands.*;
import data.Community;

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
                System.err.println("давайте не будем так делать >:(");
                break;
            }
        }
    }

    public void addCommands(CommandManager commandManager) {
        System.out.println("Введите команду 'help' для того, чтобы вывести все доступные команды.");
        commandManager.addCommand(new Exit());
        commandManager.addCommand(new Help(this.collectionManager));
        commandManager.addCommand(new Add(this.collectionManager));
        commandManager.addCommand(new Show(this.collectionManager));
        commandManager.addCommand(new Info(this.collectionManager));
        commandManager.addCommand(new RemoveElementById(this.collectionManager));
        commandManager.addCommand(new ShowPassport(this.collectionManager));
        commandManager.addCommand(new ShowHeight(this.collectionManager));
        commandManager.addCommand(new ShowHairColors(this.collectionManager));
        commandManager.addCommand(new Clear(this.collectionManager));
        commandManager.addCommand(new UpdateId(this.collectionManager));
        commandManager.addCommand(new Reorder(this.collectionManager));
        commandManager.addCommand(new Save(this.collectionManager));
        commandManager.addCommand(new Shuffle(this.collectionManager));
        commandManager.addCommand(new AddIfMax(this.collectionManager));
        commandManager.addCommand(new ExecuteScript(this.collectionManager, this.commandManager));
    }
    public void addData(){
        String filePath = System.getenv("FILE_PATH")+"example.xml";
        Community community = FileManager.readFile(filePath);
        if (community != null) {
            collectionManager.addToCollection(community.getPeople());
        }
    }
}
