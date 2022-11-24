package restaurante;
public class Mesa {

    //Private attributes
    private int numeroMesa;
    private String data;
    private boolean reservada;
    private Comanda comanda;

    //Constructors
    public Mesa(int numeroMesa, String data){
        this.numeroMesa = numeroMesa;
        this.data = data;
        this.reservada = false;
        this.comanda = new Comanda();
    }

    public Mesa(int numeroMesa, String data, boolean reservada) {
        this.numeroMesa = numeroMesa;
        this.data = data;
        this.reservada = reservada;
        this.comanda = new Comanda();
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
    public Comanda getComanda() {
        return comanda;
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
}
