package commands;

import managers.CollectionManager;

/**
 * Класс команды save
 */
public class Save extends Command{
    private final CollectionManager collectionManager;
    public Save(CollectionManager collectionManager) {
        super("save");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        collectionManager.save();
    }
}
