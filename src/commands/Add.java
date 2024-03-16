package commands;

import Builder.PersonBuilder;
import Exceptions.InvalidDataException;
import Managers.CollectionManager;

public class Add extends Command implements CommandExecutor{
    private final CollectionManager collectionManager;
    public Add(CollectionManager collectionManager) {
        super("add");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
        collectionManager.add(new PersonBuilder().create());
        System.out.println("Человек успешно создан!");
        }catch (InvalidDataException e){
            System.err.println("Что-то пошло не так, попробуй ещё раз!");
        }
    }
}
