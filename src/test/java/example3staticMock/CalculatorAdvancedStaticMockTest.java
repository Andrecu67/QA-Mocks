package example3staticMock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;


public class CalculatorAdvancedStaticMockTest {

    @Test
    public void verifyFactorial(){
    /////// PASO 1
    //Create mock
        MockedStatic<ServiceCalcStatic> serviceCalcStaticMockedStatic = mockStatic(ServiceCalcStatic.class);

    //Create method - mock
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(1,1)).thenReturn(1);
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(1,2)).thenReturn(2);
        serviceCalcStaticMockedStatic.when(()-> ServiceCalcStatic.mult(2,3)).thenReturn(6);

        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();
        int actualResult = calculatorAdvanced.getFactorial(3);
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! el factorial es incorrecto");
    }
}
