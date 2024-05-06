package exercise;

import java.util.Objects;

public class Prestamos {
    /////// PASO 1
    // Verificar si se puede agregar el objato que se quiere mockear
    private ASFIservice service;
    public Prestamos() {service = new ASFIservice();}

    //Genarar Set
    public void setService(ASFIservice service) {
        this.service = service;
    }

    //Generar Constructor
    public Prestamos(ASFIservice service) {
        this.service = service;
    }

    public String getMaximoPrestamo(int ci){
        String message;
        String categoria = service.getCategoria(ci);
        switch (categoria){
            case "A":
                return "Maximo a prestar 200000";
            case "B":
                return "Maximo a prestar 100000";
            case "C":
                return "No se puede prestar níngun monto ALERTA!";
            default:
                return "El CI ingresado no es valido verifique y vuelva a intentar";
        }
    }
}
