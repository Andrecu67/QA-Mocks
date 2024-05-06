  package example3staticMock;
//Dev: Mauricio

  public class CalculatorAdvanced {

    private String name = "Calculadora X";

    public CalculatorAdvanced( ) {

    }

    public int getFactorial (int number){
        int f = 1;
        for (int i = 1; i<=number; i++){
            f = ServiceCalcStatic.mult(f,i);
        }
        return f;
    }

}
