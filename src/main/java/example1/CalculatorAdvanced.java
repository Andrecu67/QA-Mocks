package example1;
//Dev: Mauricio

public class CalculatorAdvanced {

    private String name = "Calculadora X";
    /////// PASO 1
    // Verificar si se puede agregar el objeto que se desea mockear
    // Si el objeto tiene un metodo SET
    // si el objeto tiene un construnctor parametrizado
    private ServiceCalc calcService;

    public CalculatorAdvanced(){
        calcService = new ServiceCalc();
    }

    // Generar constructor
    public CalculatorAdvanced(ServiceCalc calcService) {
        this.calcService = calcService;
    }

    // Generar Set
    public void setCalcService(ServiceCalc calcService) {
        this.calcService = calcService;
    }

    public int getFactorial (int number){
        int f = 1;
        for (int i = 1; i<=number; i++){
            f = calcService.mult(f,i);
        }
        return f;
    }

}
