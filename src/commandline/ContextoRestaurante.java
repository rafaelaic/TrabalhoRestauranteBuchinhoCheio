package commandline;

import java.util.Scanner;

import exceptions.*;

import java.io.PrintStream;
import java.io.InputStream;
import restaurante.*;



public class ContextoRestaurante extends Contexto {

    private Restaurante restaurante;

    // Constructors
    public ContextoRestaurante(Scanner input, PrintStream output, Restaurante restaurante) {
        this.input = input;
        this.output = output;
        this.restaurante = restaurante;
        this.currentPath = "Restaurante";
        this.previousPath = "";
        this.fullPath = this.currentPath;
    }

    public ContextoRestaurante(InputStream input, PrintStream output, Restaurante restaurante) {
        
        this(new Scanner(input), output, restaurante);
    }

    // Public methodes
    @Override
    public void infoCommand() {
        this.output.println(restaurante.toString());
    }

    @Override
    public void helpCommand() {
        String message = "Contexto Atual: " + this.previousPath + this.currentPath
                + "\nComandos disponíveis: "
                +"\nINFO -> Retorna as informações do restaurante"
                +"\nHELP -> Retorna os comandos permitidos para o contexto atual"
                +"\nEXIT -> Finaliza o programa";
        this.output.println(message);;
    }

    public void selecionarMesa(int numeroMesa){
        try{
            Mesa mesa = restaurante.encontraMesa(numeroMesa);
            ContextoMesa nextContext = new ContextoMesa(input, output, mesa, this.fullPath);
            nextContext.execute();
        }catch (MesaNaoEncontrada e){
            this.output.println(e.toString());
        }
    }

    @Override
    public void execute() {
        while(true){
            this.waitCommand();
            if(this.splitedCommand.length == 1){
                if(this.command.equals("INFO")){ this.infoCommand(); }
                else if(this.command.equals("HELP")){ this.helpCommand(); }
                else if(this.command.equals("EXIT")){ return; }
            }
            else if(this.splitedCommand.length == 2){
                if(this.splitedCommand[0].equals("SEL_MESA")){
                    this.selecionarMesa(Integer.parseInt(this.splitedCommand[1]));
                }
            }
        }
    }

}
