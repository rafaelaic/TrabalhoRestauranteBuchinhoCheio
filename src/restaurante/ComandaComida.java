package restaurante;

import java.util.ArrayList;

public class ComandaComida extends Comanda{

    public ComandaComida(){
        this.consumo = new ArrayList<String>();
        this.valor = 0;
    }

    @Override
    public String getTipo() {
        return ComandaComida.class.getSimpleName();
    }
    
}
