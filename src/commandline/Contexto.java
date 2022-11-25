package commandline;

import java.util.Scanner;
import java.io.PrintStream;

public abstract class Contexto {

    // Private attributes
    protected Scanner input;
    protected PrintStream output;
    protected String command;
    protected String[] splitedCommand;
    protected String previousPath;
    protected String fullPath;
    protected String currentPath;

    // Abstract methods
    public abstract void infoCommand();

    public abstract void helpCommand();

    public abstract void execute();

    // Public methods
    public void waitCommand() {
        this.output.print(Cores.BRANCO + "\n"  + this.fullPath + " >> "+Cores.BRANCO);
        this.command = this.input.nextLine().toUpperCase();
        this.splitedCommand = this.command.split(" ");
    }

    public void errorCommand() {
        this.output.println("Comando inválido digitado");
    }

    public void clearConsole(){
        this.output.print("\033[H\033[2J");
        this.output.flush();
    }
}
