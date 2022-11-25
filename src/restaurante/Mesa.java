package restaurante;

import java.util.List;
import java.util.ArrayList;

public class Mesa {

    //Private attributes
    private int numeroMesa;
    private String data;
    private boolean reservada;
    private ComandaComida comandaComida;
    private ComandaBebida comandaBebida;


    private List<Cliente> clientes;

    //Constructors
    public Mesa(int numeroMesa, String data){
        this.numeroMesa = numeroMesa;
        this.data = data;
        this.reservada = false;
        this.comandaComida = new ComandaComida();
        this.comandaBebida = new ComandaBebida();
        this.clientes = new ArrayList<Cliente>();
    }

    public Mesa(int numeroMesa, String data, List<Cliente> clientes) {
        this.numeroMesa = numeroMesa;
        this.data = data;
        this.reservada = true;
        this.comandaComida = new ComandaComida();
        this.comandaBebida = new ComandaBebida();
        this.clientes = clientes;

    }

    //Getters and Setters
    public int getNumeroMesa() {
        return numeroMesa;
    }
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public boolean isReservada() {
        return reservada;
    }
    public ComandaComida getComandaComida() {
        return comandaComida;
    }
    public ComandaBebida getComandaBebida() {
        return comandaBebida;
    }
    public List<Cliente> getClientes(){
        return this.clientes;
    }
    
    //Public methods
    @Override
    public String toString() {
        String string = "Número: " + this.numeroMesa;
        string += "\nData: " + this.data;
        string += "\nReservada: " + this.reservada;
        return string;
    }

    public boolean reservar(){
        if(this.reservada) return false;
        else{
            this.reservada = true;
            return true;
        }
    }

    public void adicionaCliente(Cliente cliente){
        this.clientes.add(cliente);
        this.reservar();
    }

    public void adicionaCliente(String nome, String email){
        this.clientes.add(new Cliente(nome, email));
        this.reservar();
    }

    public boolean removeCliente(Cliente cliente){
        return this.clientes.remove(cliente);
    }

    public boolean removeCliente(String nome, String email){
        return this.removeCliente(new Cliente(nome, email));
    }
}
