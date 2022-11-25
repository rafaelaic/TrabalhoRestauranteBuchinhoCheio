package restaurante;

import java.util.List;
import java.util.ArrayList;
import exceptions.*;

public class Restaurante{
    public static Restaurante criaRestauranteParaTestes(){
        Restaurante restaurante = new Restaurante("Buchinho Cheio", "Rua das Margaridas, Bairro Jeca, Sarzedo - MG");

        restaurante.adicionaMesa(12, "Mesa 6 cadeiras");
        restaurante.adicionaMesa(20, "Mesa 2 cadeiras");

        try{
            //Mesa 12
            Mesa mesa = restaurante.encontraMesa(12);
            mesa.adicionaCliente("Jõao", "jaozin@gmail.com");
            mesa.adicionaCliente("Maria", "mariazinha@gmail.com");

            Comanda comanda = mesa.getComandaComida();
            comanda.adicionaItem("Chololate com manteiga", 13.50);
            comanda.adicionaItem("Batata fria", 27.90);
            comanda.adicionaItem("Pipoca de camarelo", 32.12);
            comanda.adicionaItem("Pizza de Macarrão", 89.90);
            comanda.adicionaItem("Cookie vegano", 23.90);

            comanda = mesa.getComandaBebida();
            comanda.adicionaItem("Água pura do tiete", 79.97);
            comanda.adicionaItem("Suco do Tibet", 54.48);
            comanda.adicionaItem("Refri Brasil", 22);
            comanda.adicionaItem("Suco de acerola", 13);

            //Mesa 20
            mesa = restaurante.encontraMesa(20);
            mesa.adicionaCliente("Carlos", "carlosbolsonaro@gmail.com");
            mesa.adicionaCliente("Lula", "lula@yahoo.com.br");
            mesa.adicionaCliente("David", "davidgilmour@pf.com");
            mesa.adicionaCliente("Roger", "rogerwaters@pf.com");

            comanda = mesa.getComandaComida();
            comanda.adicionaItem("Barata Frita", 19.90);
            comanda.adicionaItem("Macaco com barbecue", 192.89);
            comanda.adicionaItem("Sopa de batata", 12);

            comanda = mesa.getComandaBebida();
            comanda.adicionaItem("Whisky de agua benta", 198.21);
            comanda.adicionaItem("Suco do Tibet", 54.48);
            comanda.adicionaItem("Refri de Acerola", 14);
            comanda.adicionaItem("Suco verde da tia Zilda", 10000.21);
        }catch (MesaNaoEncontrada e){}
        
        return restaurante;
    }


    //Private attributes
    private String nome;
    private String endereco;
    private List<Mesa> mesas;

    //Constructors
    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.mesas = new ArrayList<Mesa>();
    }
    
    //Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<Mesa> getMesas(){
        return this.mesas;
    }

    //Public methods
    @Override
    public String toString() {

        String string = "Nome: " + this.nome;
        string += "\nEndereço: " + this.endereco;
        return string;
    }

    public void adicionaMesa(Mesa mesa){
        this.mesas.add(mesa);
    }

    public void adicionaMesa(int numeroMesa, String data){
        this.adicionaMesa(new Mesa(numeroMesa, data));
    }

    public Mesa encontraMesa(int numeroMesa) throws MesaNaoEncontrada{
        for(Mesa mesa : this.mesas){
            if(mesa.getNumeroMesa() == numeroMesa){
                return mesa;
            }
        }
        throw new MesaNaoEncontrada(numeroMesa);
    }

}
