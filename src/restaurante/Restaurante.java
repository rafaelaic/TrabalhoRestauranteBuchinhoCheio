package restaurante;

import java.util.List;
import java.util.ArrayList;
import exceptions.*;

public class Restaurante{
    public static Restaurante criaRestauranteParaTestes(){
        Restaurante restaurante = new Restaurante("Loja do seu Juca", "Rua das Margaridas, Bairro Jeca, Sarzedo - MG");

        restaurante.adicionaMesa(12, "Mesa 6 cadeiras");
        restaurante.adicionaMesa(20, "Mesa 2 cadeiras");

        try{
            Comanda comanda = restaurante.encontraMesa(12).getComanda();
            comanda.adicionaCliente("Jõao pé de feijão", "jaozin@gmail.com");
            comanda.adicionaCliente("Maria margarida", "mariazinha@gmail.com");

            comanda.adicionaItem("Pizza de Macarrão", 89.90);
            comanda.adicionaItem("Cookie vegano", 23.90);

            comanda = restaurante.encontraMesa(20).getComanda();
            comanda.adicionaCliente("Pietra Vladimir", "vladimirpietra@gmail.com");
            comanda.adicionaItem("Churrasco de linguiça", 192.23);
            comanda.adicionaItem("Carne vegana com sangue", 321.34);
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
