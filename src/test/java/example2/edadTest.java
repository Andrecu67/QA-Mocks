package example2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class edadTest {
    /////// PASO 2
    //  necesitamos  crear el objeto falso usando Mockito.mock(tipo de la clase)

    Check checkMock = Mockito.mock(Check.class);
    Edad edad;

    @BeforeEach
    public void setup(){
        edad = new Edad();
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "2,true,200",
                    "9,false,9",
                    "13,true,1040",
                    "15,false,0"
            }
    )

    public void verifyGetPremio (int edadIn, boolean prime, int expectedResult) throws Exception {
        /////// PASO 3
        // le decimos al metodo lo que queremos que retorne
        Mockito.when(checkMock.isPrime(edadIn)).thenReturn(prime);

        /////// PASO 4
        // usar el objeto mockeado
        edad.setCheckService(checkMock);
        int actual = edad.getPremio(edadIn);
        Assertions.assertEquals(expectedResult,actual,"ERROR! el premio es incorrecto");

        /////// PASO 5
        // verficar que el mock y los metodos mockeados se usen
        Mockito.verify(checkMock).isPrime(edadIn);
    }

    //Verificacion Negativa, para que el codigó mande excepciones se utiliza los throws y assertThrows

    @Test
    public void  verifyEdadInvalida() throws Exception{
        Assertions.assertThrows(Exception.class,()-> {
            edad.getPremio(-10);
        });
    }
}
