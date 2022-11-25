package commandline;

import java.util.Scanner;

import exceptions.*;

import java.io.PrintStream;
import java.io.InputStream;
import restaurante.*;

public class ContextoComanda extends Contexto {
    // Private attributes
    private Comanda comanda;

    // Constructors
    public ContextoComanda(Scanner input, PrintStream output, String previousPath, Comanda comanda) {
        this.input = input;
        this.output = output;
        this.previousPath = previousPath;
        this.currentPath = Cores.CIANO + comanda.getTipo() + Cores.BRANCO;
        this.fullPath = previousPath + " > " + this.currentPath;
        this.comanda = comanda;
    }

    public ContextoComanda(InputStream input, PrintStream output, String previousPath, Comanda comanda) {
        this(new Scanner(input), output, previousPath, comanda);
    }

    // Public methods

    public void listarConsumo() {
        int i = 0;
        for (String produto : this.comanda.getConsumo()) {
            this.output.println("[" + i + "] " + produto);
            i++;
        }
    }

    public void dividirConta(int numDePessoas) {
        this.output.println("O valor para cada pessoa será: R$ " + String.format("%.2f",this.comanda.dividirConta(numDePessoas)));
    }

    public void pagarConta() {
        this.comanda.pagarConta();
        this.output.println("Comanda limpa, saldo zerado. Conta paga!");
    }

    public void imprimeValor() {
        this.output.println("O valor total da comanda é: R$ " + String.format("%.2f",this.comanda.getValor()));
    }

    @Override
    public void helpCommand() {
        String message = "Contexto Atual: Comanda"
                + "\nComandos disponíveis: "
                + "\n listar_consumo -> Lista os produtos inseridos na comanda"
                + "\n dividir_conta <numDePessoas> -> Retorna o valor para cada pessoa pagar"
                + "\n pagar -> Limpa a comanda e o valor"
                + "\n valor -> Retorna o valor da comanda"
                + "\n calcula10porcento -> Retorna 10% do valor da comanda"
                + "\n info -> Retorna as informações completas da comanda"
                + "\n help -> Retorna os comandos permitidos para o contexto atual"
                + "\n clear -> Limpa o console"
                + "\n back -> Retorna ao contexto anterior";

        this.output.println(message);
    }

    @Override
    public void infoCommand() {
        this.output.println("Valor total: " + String.format("%.2f", this.comanda.getValor()));
        this.output.println("Produtos:");
        this.listarConsumo();
    }

    public void calcula10porcento(){
        this.output.println("10% do valor da comanda = " + String.format("%.2f", this.comanda.calcula10porcento()));
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
                    } else if (this.command.equals("LISTAR_CONSUMO")) {
                        this.listarConsumo();
                    } else if (this.command.equals("PAGAR")) {
                        this.pagarConta();
                    }else if (this.command.equals("VALOR")) {
                        this.imprimeValor();
                    }
                    else if (this.command.equals("CALCULA10PORCENTO")){
                        this.calcula10porcento();
                    }
                    else {
                        this.errorCommand();
                    }

                } else if (this.splitedCommand.length == 2) {
                    if (this.splitedCommand[0].equals("DIVIDIR_CONTA")){
                        this.dividirConta(Integer.parseInt(this.splitedCommand[1]));
                    }
                    else {
                        this.errorCommand();
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
