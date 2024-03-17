package commands;

import Interfaces.CommandExecutor;

public abstract class Command implements CommandExecutor {
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    @Override
    public void execute(String args) {
        System.out.println("Команда " + name + " успешно применена!");
    }

    public String getName() {
        return name;
    }

}
