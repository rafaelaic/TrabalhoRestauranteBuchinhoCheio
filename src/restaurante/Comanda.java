package restaurante;
import java.util.List;
import java.util.ArrayList;


public class Comanda {
    //Private attributes
    private List<String> consumo;
    private double valor;
    private List<Cliente> clientes;

    //Constructors
    public Comanda(){
        this.consumo = new ArrayList<String>();
        this.valor = 0;
        this.clientes = new ArrayList<Cliente>();
    }

    public Comanda(List<Cliente> clientes) {
        this.consumo = new ArrayList<String>();
        this.valor = 0;
        this.clientes = clientes;
    }
    
    //Getters and Setters
    public List<String> getConsumo() {
        return consumo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    //Public methods
    public void adicionaCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void adicionaCliente(String nome, String email){
        this.clientes.add(new Cliente(nome, email));
    }

    public boolean removeCliente(Cliente cliente){
        return this.removeCliente(cliente.getNome(), cliente.getEmail());
    }

    public boolean removeCliente(String nome, String email){
        for(Cliente cliente : this.clientes){
            if(cliente.equals(new Cliente(nome, email))){
                this.clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public void adicionaItem(String nome, double preco) throws IllegalArgumentException{
        //Checa os parâmetros
        if(nome == "" || preco < 0){
            throw new IllegalArgumentException("O nome não estar vazio e o preço não deve ser menor do que 0");
        }

        this.consumo.add(nome);
        this.valor += preco;
    }

}
