package commandline;

import java.util.Scanner;
import java.io.PrintStream;

public abstract class Contexto {
    
    //Private attributes
    protected Scanner input;
    protected PrintStream output;
    protected String command;
    protected String[] splitedCommand;
    protected String previousPath;
    protected String fullPath;
    protected String currentPath;
     
    //Abstract methods
    public abstract void infoCommand();
    public abstract void helpCommand();
    public abstract void execute();

    //Public methods
    public void waitCommand(){
        this.output.print("\n" + this.fullPath+ " >> ");
        this.command = this.input.nextLine().toUpperCase();
        this.splitedCommand = this.command.split(" ");
    }

}
