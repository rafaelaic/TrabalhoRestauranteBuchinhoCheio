import commandline.*;
import restaurante.*;

public class Test {
    public static void main(String[] args) {
        Restaurante restaurante = Restaurante.criaRestauranteParaTestes();
        ContextoRestaurante cli = new ContextoRestaurante(System.in, System.out, restaurante);
        cli.execute();
    }
}
