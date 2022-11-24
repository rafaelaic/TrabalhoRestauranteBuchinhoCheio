package commandline;

import java.util.Scanner;

import exceptions.*;

import java.io.PrintStream;
import java.io.InputStream;
import restaurante.*;

public class ContextoMesa extends Contexto {
    // Privatte attributes
    private Mesa mesa;

    // Constructors
    public ContextoMesa(Scanner input, PrintStream output, Mesa mesa, String previousPath) {
        this.input = input;
        this.output = output;
        this.mesa = mesa;
        this.previousPath = previousPath;
        this.currentPath = "Mesa "+this.mesa.getNumeroMesa();
        this.fullPath = previousPath + " > " + this.currentPath;
    }

    public ContextoMesa(InputStream input, PrintStream output, Mesa mesa, String previousPath){
        this(new Scanner(input), output, mesa, previousPath);
    }
    
    // Public methods
    @Override
    public void infoCommand() {
        this.output.println(this.mesa.toString());
    }

    @Override
    public void helpCommand() {
        String message = "Contexto Atual: " + this.previousPath + this.currentPath
                + "\nComandos disponíveis: "
                + "\nINFO -> Retorna as informações da mesa"
                + "\nHELP -> Retorna os comandos permitidos para o contexto atual"
                + "\nBACK -> Retorna ao contexto anterior";

        this.output.println(message);
        
    }

    public void selecionarComandaComida(){

    }

    public void selecionarComandaBebida(){

    }

    @Override
    public void execute() {
        while(true){
            this.waitCommand();
            if(this.splitedCommand.length == 1){
                if(this.command.equals("INFO")){ this.infoCommand(); }
                else if(this.command.equals("HELP")){ this.helpCommand(); }
                else if(this.command.equals("BACK")) {return;}
                else if(this.command.equals("COMANDA_COMIDA")) {this.selecionarComandaComida();}
                else if(this.command.equals("COMANDA_BEBIDA")) {this.selecionarComandaBebida();}
            }
            else if(this.splitedCommand.length == 2){
            }
        }
    }
}
