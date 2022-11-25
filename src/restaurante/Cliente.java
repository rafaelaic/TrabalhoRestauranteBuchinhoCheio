package restaurante;
public class Cliente {
    //Private attributes
    private String nome;
    private String email;

    //Constructors
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Public methods
    @Override
    public String toString() {
        String string = "Nome: " + this.nome;
        string += " | Email: " + this.email;
        return string;
    }

}
