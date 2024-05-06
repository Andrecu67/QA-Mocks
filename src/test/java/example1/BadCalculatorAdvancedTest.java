package example1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadCalculatorAdvancedTest {

    //No debemos realizar unit Test cuando existe dependencias y llamadas a otos metodos
    //En estos casos se deve usar mocks

    @Test
    public void verifyFactorial(){
        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
        int actual = calculatorAdvanced.getFactorial(3);
        int expected = 6;
        Assertions.assertEquals(expected,actual,"ERROR! el factorial es incorrecto");
    }
}
