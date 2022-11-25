import commandline.*;
import restaurante.*;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = Restaurante.criaRestauranteParaTestes();
        ContextoRestaurante cli = new ContextoRestaurante(System.in, System.out, restaurante);
        cli.execute();
    }
}
