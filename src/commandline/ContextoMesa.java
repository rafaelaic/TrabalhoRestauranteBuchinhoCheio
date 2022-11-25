package commandline;

import java.util.Scanner;

import exceptions.*;

import java.io.PrintStream;
import java.io.InputStream;
import restaurante.*;

import java.util.List;

public class ContextoMesa extends Contexto {
    // Privatte attributes
    private Mesa mesa;

    // Constructors
    public ContextoMesa(Scanner input, PrintStream output, Mesa mesa, String previousPath) {
        this.input = input;
        this.output = output;
        this.mesa = mesa;
        this.previousPath = previousPath;
        this.currentPath = Cores.VERMELHO + "Mesa " + this.mesa.getNumeroMesa() + Cores.BRANCO;
        this.fullPath = previousPath + " > " + this.currentPath;
    }

    public ContextoMesa(InputStream input, PrintStream output, Mesa mesa, String previousPath) {
        this(new Scanner(input), output, mesa, previousPath);
    }

    // Public methods
    @Override
    public void infoCommand() {
        this.output.println(this.mesa.toString());
        this.output.println("Clientes: ");
        this.listarClientes();
    }

    @Override
    public void helpCommand() {
        String message = "Contexto Atual: Mesa"
                + "\nComandos disponíveis: "
                + "\n adicionar_cliente <nome_cliente> <email_cliente> -> Cadastra o cliente"
                + "\n listar_clientes -> Lista os clientes da mesa"
                + "\n comida -> Entra no contexto da comanda de comida"
                + "\n bebida -> Entra no contexto da comanda de bebida"
                + "\n reservar -> Tenta reservar a mesa"
                + "\n info -> Retorna as informações da mesa"
                + "\n help -> Retorna os comandos permitidos para o contexto atual"
                + "\n clear -> Limpa o console"
                + "\n back -> Retorna ao contexto anterior";

        this.output.println(message);

    }

    public void selecionarComandaComida() {
        ContextoComanda contexto = new ContextoComanda(this.input, this.output, this.fullPath,
                this.mesa.getComandaComida());
        contexto.execute();
    }

    public void selecionarComandaBebida() {
        ContextoComanda contexto = new ContextoComanda(this.input, this.output, this.fullPath,
                this.mesa.getComandaBebida());
        contexto.execute();
    }

    public void listarClientes(){
        List<Cliente> clientes = this.mesa.getClientes();
        int i = 0;
        for (Cliente cliente : clientes) {
            this.output.println("[" + i + "] " + cliente.toString());
            i++;
        }
    }

    public void adicionarCliente(String nome, String email){
        this.mesa.adicionaCliente(nome, email);
        this.output.println("Cliente adicionado.");
    }

    public void reservarMesa(){
        if(this.mesa.reservar()){
            this.output.println("Mesa reservada com sucesso!");
        }
        else{
            this.output.println("A mesa já está reservada, sinto muito!");
        }
    }
    @Override
    public void execute() {
        this.clearConsole();
        while (true) {
            try{
                this.waitCommand();
                if (this.splitedCommand.length == 1) {
                    if (this.command.equals("INFO")) {
                        this.infoCommand();
                    } else if (this.command.equals("HELP")) {
                        this.helpCommand();
                    } else if (this.command.equals("BACK")) {
                        return;
                    } else if (this.command.equals("CLEAR")) {
                        this.clearConsole();
                    } else if (this.command.equals("COMIDA")) {
                        this.selecionarComandaComida();
                    } else if (this.command.equals("BEBIDA")) {
                        this.selecionarComandaBebida();
                    }else if (this.command.equals("LISTAR_CLIENTES")) {
                        this.listarClientes();
                    }else if (this.command.equals("RESERVAR")) {
                        this.reservarMesa();
                    }
                    else {
                        this.errorCommand();
                    }
                } else if (this.splitedCommand.length == 2) {
                    // if(false){
    
                    // }
                    // else {
                    //     this.errorCommand();
                    // }
                } else if(this.splitedCommand.length == 3){
                    if(this.splitedCommand[0].equals("ADICIONAR_CLIENTE")){
                        this.adicionarCliente(this.splitedCommand[1].toLowerCase(), this.splitedCommand[2].toLowerCase());
                    }
                }

                else {
                    this.errorCommand();
                }
            }catch (Exception e){
                this.errorCommand();
            }
            
            
        }
    }
}
