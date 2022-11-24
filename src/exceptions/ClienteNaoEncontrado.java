package exceptions;

public class ClienteNaoEncontrado extends Exception{
    private String nome;
    private String email;

    public ClienteNaoEncontrado(String nome, String email){
        super();
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "O cliente de nome"+ this.nome + " e email " + this.email+"não foi encontrada";
    }
}
