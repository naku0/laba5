package Managers;

import commands.Command;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class CommandManager {
    private final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();

    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    public void execute(String name, String args) {
        Command command = commands.get(name);
        if (command == null) {
            System.out.println("Такой команды нет :(");
        } else {
            command.execute(args);
        }
    }
}
