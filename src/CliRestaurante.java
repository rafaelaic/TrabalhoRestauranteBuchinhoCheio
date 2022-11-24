import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import restaurante.Mesa;
import restaurante.Restaurante;

public class CliRestaurante {
    private Scanner input;
    private PrintStream output;
    private Restaurante restaurante;
    private String command;

    //Constructors
    public CliRestaurante(Scanner input, PrintStream output, Restaurante restaurante) {
        this.input = input;
        this.output = output;
        this.restaurante = restaurante;
    }

    public CliRestaurante(InputStream input, PrintStream output, Restaurante restaurante){
        this.input = new Scanner(input);
        this.output = output;
        this.restaurante = restaurante;
    }

    
    //Public methods
    public void initMessage() {
        System.out.println("\n\n--------- "+ restaurante.getNome() + " ---------");
        System.out.println(" = Digite HELP para conhecer os comandos! = ");
    }

    public void waitCommand() {
        System.out.print("\n> ");
        this.command = this.input.nextLine().toUpperCase();
    }

    private void infoCommand(){
        this.output.println(restaurante.toString());
    }

    private void cadastrarMesaCommand(){
        this.output.println("....Digite o número e a data: ");
        String[] receive = this.input.nextLine().split(" ");
        restaurante.adicionaMesa(Integer.valueOf(receive[0]), receive[1]);
    }

    private void listarMesas(){
        for (Mesa mesa : this.restaurante.getMesas()){
            this.output.println(mesa.toString());
            this.output.println("------");
        }
    }

    public void executeCommand(){
        if (this.command.equals("INFO")){
            this.infoCommand();
        }
        else if(this.command.equals("CADASTRAR MESA")){
            this.cadastrarMesaCommand();
        }
        else if(this.command.equals("LISTAR MESAS")){
            this.listarMesas();
        }

    }
    
}
