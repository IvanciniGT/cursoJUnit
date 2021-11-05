package es.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;
import java.util.stream.*;

import java.util.logging.Logger;

public class AppTest {

    private static Logger log = Logger.getLogger(AppTest.class.getName());
   
   // Pruebas de la función esPar -5:5
   // DynamicTest
    List<Integer> mis_numeros_pares=Arrays.asList(-4,-2,0,2,4);

    @TestFactory
    public Stream<DynamicTest> pruebasPares(){
        return mis_numeros_pares.stream().
            map( (numero) -> DynamicTest.dynamicTest("Prueba paridad: "+numero, ()->{
                boolean RESULTADO=App.esPar(numero);
                Assertions.assertEquals( true , RESULTADO );
            }
            ));
    }

    List<Integer> mis_numeros_impares=Arrays.asList(-5,-3,-1,1,3,5);
    @TestFactory
    public Stream<DynamicTest> pruebasImpares(){
        return mis_numeros_impares.stream().
            map( (numero) -> DynamicTest.dynamicTest("Prueba imparidad: "+numero, ()->{
                boolean RESULTADO=App.esPar(numero);
                Assertions.assertEquals( false , RESULTADO );
            }
            ));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-4 , -8 , 2, 0, 6, 10, 38})
    void pruebaParametrizadaPares(int numeroSupuestamentePar){
        Assertions.assertTrue(App.esPar(numeroSupuestamentePar));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-21, 19, 3, 7, 11})
    void pruebaParametrizadaImPares(int numeroSupuestamenteImpar){
        Assertions.assertFalse(App.esPar(numeroSupuestamenteImpar));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Hola", "Adios", "curSO"})
    void pruebaMayusculas(String palabra){
        Assertions.assertEquals(App.convertirAMayusculas(palabra),palabra.toUpperCase());
    }

    @ParameterizedTest
    @CsvSource({"Hola,HOLA","prueba,PRUEBA","guaY,GUAY"})
    void pruebaMayusculasDecente(String palabra,String palabraMayusculas){
        Assertions.assertEquals(App.convertirAMayusculas(palabra),palabraMayusculas);
    }
    
    @ParameterizedTest
    @CsvSource({"Hola,4","prueba,6","guaY,4"})
    void pruebaMayusculasDecente(String palabra,int longitudEsperada){
        Assertions.assertEquals(App.longitudPalabra(palabra),longitudEsperada);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/longitudes.csv", numLinesToSkip= 1)
    void pruebaMayusculasDecenteFichero(String palabra,int longitudEsperada){
        Assertions.assertEquals(App.longitudPalabra(palabra),longitudEsperada);
    }
    
    @Test
    void pruebaDistancia(){
        double esperada=2;
        Punto a=new Punto(2,0);
        double calculada=a.distanciaAlOrigen();
        Assertions.assertEquals(esperada,calculada, 0.00001);
    }
    
    @ParameterizedTest
    @MethodSource("generaPuntosPrueba")
    void pruebaDistancia(Punto p, double esperada){
        double calculada=p.distanciaAlOrigen();
        Assertions.assertEquals(esperada,calculada, 0.00001);
    }
    
    private static Stream<Arguments> generaPuntosPrueba(){
        return Stream.of(
            Arguments.of(new Punto(2,0),2),
            Arguments.of(new Punto(0,1),1),
            Arguments.of(new Punto(1,1),Math.sqrt(2))
        );
    }
    
    enum Nivel {
        ALTO,
        MEDIO,
        BAJO
    }
    
    @ParameterizedTest
    @EnumSource(value=Nivel.class, names={"ALTO","BAJO"})
    void pruebaEnum(Nivel nivel){
        log.info("Estamos probando el nivel: "+nivel.toString());
    }
}
