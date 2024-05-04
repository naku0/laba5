package commands;

import interfaces.CommandExecutor;

/**
 * Абстрактный класс команды
 */
public abstract class Command implements CommandExecutor {
    private final String name;

    /**
     * Конструктор команды
     *
     * @param name имя команды
     */
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
