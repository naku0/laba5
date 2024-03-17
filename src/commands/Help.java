package commands;

import Interfaces.CommandExecutor;

public class Help extends Command implements CommandExecutor {
        public Help() {
        super("help");
    }
    @Override
    public void execute(String args) {
        System.out.println("HELP");
    }
}
