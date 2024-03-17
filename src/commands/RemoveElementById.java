package commands;

import Managers.CollectionManager;

import java.util.NoSuchElementException;

public class RemoveElementById extends Command implements CommandExecutor{
    private final CollectionManager collectionManager;
    public RemoveElementById(CollectionManager collectionManager) {
        super("remove_by_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) {
        try {
            int id = Integer.parseInt(args.trim());
            collectionManager.removeElement(collectionManager.getPersonById(id));
            System.out.println("Этого человечка больше нет с нами");
        }
        catch (NoSuchElementException e){
            System.err.println("Такого человека нет, возможно вы ошиблись с id");
        }
        catch (NumberFormatException e){
            System.err.println("Поле 'id' должно быть типа 'int'!");
        }
    }
}
