package restaurante;

import java.util.ArrayList;

public class ComandaBebida extends Comanda{

    public ComandaBebida(){
        this.consumo = new ArrayList<String>();
        this.valor = 0;
    }

    @Override
    public String getTipo() {
        return ComandaBebida.class.getSimpleName();
    }
}
