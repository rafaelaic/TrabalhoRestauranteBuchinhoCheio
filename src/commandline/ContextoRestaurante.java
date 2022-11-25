package commandline;

import java.util.List;
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
        this.currentPath = Cores.VERDE + "Restaurante" + Cores.BRANCO;
        this.previousPath = "";
        this.fullPath = this.currentPath;
    }

    public ContextoRestaurante(InputStream input, PrintStream output, Restaurante restaurante) {

        this(new Scanner(input), output, restaurante);
    }

    // Public methodes

    public void initMessage() {
        this.output.println(Cores.CIANO + "\n\nBem vindo ao Restaurante " + this.restaurante.getNome()+"!" + Cores.BRANCO);
        this.output.println(Cores.AMARELO + "Digite help para conhecer os comandos do contexto atual, \ne divirta-se navegando entre os diferentes contextos (restaurante, mesa e comanda)"+Cores.BRANCO);
    }

    @Override
    public void infoCommand() {
        this.output.println(restaurante.toString());
    }

    @Override
    public void helpCommand() {
        String message = "Contexto Atual: Restaurante" 
                + "\nComandos disponíveis (não são case-sensitive): "
                + "\n adicionar_mesa <numMesa> <dataMesa> -> Adiciona a mesa desejada"
                + "\n sel_mesa <numMesa> -> Entra no contexto da mesa desejada"
                + "\n listar_mesas -> Retorna as mesas disponíveis"
                + "\n info -> Retorna as informações do restaurante"
                + "\n help -> Retorna os comandos permitidos para o contexto atual"
                + "\n clear -> Limpa o console"
                + "\n exit -> Finaliza o programa";
        this.output.println(message);
        ;
    }

    public void listarMesas() {
        List<Mesa> mesas = this.restaurante.getMesas();
        this.output.println("Quantidade de mesas: " + mesas.size());
        for (Mesa mesa : mesas) {
            this.output.println("Mesa " + mesa.getNumeroMesa() + " - " + mesa.getData());
        }
    }

    public void selecionarMesa(int numeroMesa) {
        try {
            Mesa mesa = restaurante.encontraMesa(numeroMesa);
            ContextoMesa nextContext = new ContextoMesa(input, output, mesa, this.fullPath);
            nextContext.execute();
        } catch (MesaNaoEncontrada e) {
            this.output.println(e.toString());
        }
    }

    public void adicionarMesa(int numeroMesa, String data){
        this.restaurante.adicionaMesa(numeroMesa, data);
        this.output.println("Mesa adicionada");
    }

    @Override
    public void execute() {
        this.clearConsole();
        this.initMessage();
        while (true) {
            try{
                this.waitCommand();
                if (this.splitedCommand.length == 1) {
                    if (this.command.equals("INFO")) {
                        this.infoCommand();
                    } else if (this.command.equals("HELP")) {
                        this.helpCommand();
                    } else if (this.command.equals("EXIT")) {
                        return;
                    } else if (this.command.equals("LISTAR_MESAS")) {
                        this.listarMesas();
                    } else if (this.command.equals("CLEAR")) {
                        this.clearConsole();
                    } 
                    else {
                        this.errorCommand();
                    }
                } else if (this.splitedCommand.length == 2) {
                    if (this.splitedCommand[0].equals("SEL_MESA")) {
                        this.selecionarMesa(Integer.parseInt(this.splitedCommand[1]));
                    } else {
                        this.errorCommand();
                    }
                } else if(this.splitedCommand.length ==3){
                    this.adicionarMesa(Integer.parseInt(this.splitedCommand[1]), this.splitedCommand[2]);
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
