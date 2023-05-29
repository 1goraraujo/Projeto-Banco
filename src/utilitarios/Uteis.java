package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Uteis {
    static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

    public static String doubleTString(Double valor){
        return formatandoValores.format(valor);
    }
}
