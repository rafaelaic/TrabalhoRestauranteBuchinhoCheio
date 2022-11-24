package exceptions;

public class MesaNaoEncontrada extends Exception{
    private int numeroMesa;

    public MesaNaoEncontrada(int numeroMesa){
        super();
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return "A mesa de número "+ this.numeroMesa + " não foi encontrada";
    }
}
