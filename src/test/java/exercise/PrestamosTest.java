package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class PrestamosTest {
    /////// PASO 2
    //  necesitamos crear el objeto falso usando Mockito.mock(tipo de la clase)

    ASFIservice serviceMock = Mockito.mock(ASFIservice.class);
    Prestamos prestamos;

    @BeforeEach
    public void setup(){prestamos = new Prestamos();}

    @ParameterizedTest
    @CsvSource(
            {
                    "454566,A,Maximo a prestar 200000",
                    "999999,B,Maximo a prestar 100000",
                    "77777,C,No se puede prestar níngun monto ALERTA!",
                    "76565,NULL,El CI ingresado no es valido verifique y vuelva a intentar",
                    "-4655,NULL,El CI ingresado no es valido verifique y vuelva a intentar"
            }
    )

    public void verifyGetMaximoPrestamo (int ci, String categoria, String expectedResult){
        /////// PASO 3
        // le decimos al metodo lo que queremos que retorne
        Mockito.when(serviceMock.getCategoria(ci)).thenReturn(categoria);

        /////// PASO 4
        // usar el objeto mockeado
        prestamos.setService(serviceMock);
        String actual = prestamos.getMaximoPrestamo(ci);
        Assertions.assertEquals(expectedResult,actual,"ERROR! el maximo es incorrecto");

        /////// PASO 5
        // verficar que el mock y los metodos mockeados se usen
        Mockito.verify(serviceMock).getCategoria(ci);
    }

}