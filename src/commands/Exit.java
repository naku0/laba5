package commands;


import interfaces.CommandExecutor;

/**
 * Класс команды exit
 */
public class Exit extends Command implements CommandExecutor {

public Exit(){
    super("exit");
}
    @Override
    public void execute(String args) {
        System.out.println("Надеюсь, мы скоро снова увидимся!");
        System.exit(1);
    }
}
