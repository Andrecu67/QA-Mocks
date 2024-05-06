package example2;

public class Edad {
    /////// PASO 1
    // Verificar si se puede agregar el objato que se quiere mockear
    private Check checkService;
    public Edad() {checkService = new Check();}

    //Generar Set
    public void setCheckService(Check checkService) {
        this.checkService = checkService;
    }

    //Constructor
    public Edad(Check checkService) {
        this.checkService = checkService;
    }

    public int getPremio(int edad) throws Exception {
        int premio = 0;
        if(edad<0){
            throw new Exception("La edad ingresada no es valida");
        } else if (!checkService.isPrime(edad)) {
            if(edad<=10)
                premio = edad;
            else
                premio = 0;
        } else {
            if(edad<=10)
                premio = edad*100;
            else
                premio = edad*80;
        }
        return premio;
    }
}

