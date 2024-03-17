package commands;

import Interfaces.CommandExecutor;
import Managers.CollectionManager;
import data.Person;

public class ShowHeight extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public ShowHeight(CollectionManager collectionManager) {
        super("print_field_descending_height");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        collectionManager.showData(Person::getHeight);
    }
}
