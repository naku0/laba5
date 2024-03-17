package commands;

import Interfaces.CommandExecutor;
import Managers.CollectionManager;

public class ShowPassport extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
    public ShowPassport(CollectionManager collectionManager) {
        super("print_field_ascending_passport_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        collectionManager.showData(person -> Integer.parseInt(person.getPassportID()));
    }
}
