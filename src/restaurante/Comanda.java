package restaurante;
import java.util.List;


public abstract class Comanda {
    //Private attributes
    protected List<String> consumo;
    protected double valor;

    
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

    //Abstract methods
    public abstract String getTipo();

    //Public methods
    public void adicionaItem(String nome, double preco) throws IllegalArgumentException{
        //Checa os parâmetros
        if(nome == "" || preco < 0){
            throw new IllegalArgumentException("O nome não estar vazio e o preço não deve ser menor do que 0");
        }

        this.consumo.add(nome);
        this.valor += preco;
    }

    public double dividirConta(int numDePessoas){
        return this.valor/numDePessoas;
    }

    public void pagarConta(){
        this.consumo.clear();
        this.valor = 0;
    }
    
    public double calcula10porcento(){
        return this.valor * 0.10;
    }
    @Override
    public String toString() {
        String message = "Valor total = R$" + String.format("%.2f", this.valor);
        message += "\nProdutos: ";
        for(String produto : this.consumo){
            message += "\n" + produto.toString();
        }

        return message;
    }
}
