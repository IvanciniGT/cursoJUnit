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

import java.util.*;
import java.util.stream.*;

import java.util.logging.Logger;

//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(OrderAnnotation.class)
public class AppTest {

    private static Logger log = Logger.getLogger(AppTest.class.getName());
    private static App instancia;

    @BeforeAll
    static void inicializacion(){
        log.info("Inicializando pruebas");
        //double numero1=5;
        //instancia=new App(numero1);
    }

    @BeforeEach
    void previo(){
        log.info("Ejecutando previo test");
        if (AppTest.instancia!=null)AppTest.instancia.reset();
    }

    @AfterAll
    static void finalizacion(){
        log.info("Finalizando pruebas");
    }

    @AfterEach
    void postPrueba(){
        log.info("Ejecutando post prueba");
    }

    @Test
    @Order(1)
    public void pruebaConstructor() {
        log.info("Ejecutando prueba Constructor");
        double numero=5;
        AppTest.instancia=new App(numero);
        Assertions.assertEquals(numero,AppTest.instancia.getNumero());
    }

    @DisplayName("Comprobar el reset sin modificaciones previas.")
    @Test
    @Order(2)
    public void pruebaResetSinModificarPreviamente() {
        log.info("Ejecutando prueba Reset");
        double numero=5;
        AppTest.instancia=new App(numero);
        AppTest.instancia.reset();
        Assertions.assertEquals(numero,AppTest.instancia.getNumero());
    }

    @Test
    @Order(4)
    public void pruebaResetTrasModificacionPrevia() {
        log.info("Ejecutando prueba Reset con modificación");
        double numero=5;
        AppTest.instancia=new App(numero);
        AppTest.instancia.suma(4);
        AppTest.instancia.reset();
        Assertions.assertEquals(numero,AppTest.instancia.getNumero());
    }

    @Test
    @Order(3)
    public void pruebaSuma() {
        log.info("Ejecutando prueba SUMA");
        double numero2=6.1;
        double resultado_obtenido=AppTest.instancia.suma(numero2).getNumero();
        double resultado_esperado=11.1;
        Assertions.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
        log.info("    Fin prueba SUMA");
    }    
    
    @Test
    @Order(5)
    public void pruebaRara() {
        log.info("Ejecutando prueba RARA");
        double resultado_obtenido=AppTest.instancia.funcionRara().getNumero();
        int resultado_esperado=10;
        Assertions.assertEquals(resultado_esperado, resultado_obtenido);
        log.info("    Fin prueba RARA");
    }
    
    @Test
    @Order(6)
    public void pruebaRaraExcepcion() {
        log.info("Ejecutando prueba RARA EXCEPTION");
        AppTest.instancia=new App(-5);
        Throwable excepcionLanzada=Assertions.assertThrows(IllegalArgumentException.class, 
        //    () -> AppTest.instancia.funcionRara() );
        //Assertions.assertThrows(IllegalArgumentException.class, 
            AppTest.instancia::funcionRara );
        
        Assertions.assertTrue(excepcionLanzada.getMessage().indexOf("negativo")!=-1);
            
        log.info("    Fin prueba RARA");
    }
    
    
    @Test
    @Disabled
    @Order(6)
    public void completo() {
        log.info("Ejecutando prueba Completa");
        double numero=10;
        AppTest.instancia=new App(numero);
        //Assertions.assertEquals(numero,AppTest.instancia.getNumero());
        AppTest.instancia.reset();
        //Assertions.assertEquals(numero,AppTest.instancia.getNumero());
        AppTest.instancia.suma(4);
        //Assertions.assertEquals(14,AppTest.instancia.getNumero());
        double resultado_obtenido=AppTest.instancia.funcionRara().getNumero();
        int resultado_esperado=7;
        Assertions.assertEquals(resultado_esperado, resultado_obtenido);
        log.info("    Fin prueba Completa");
    }


    List<Integer> mis_numeros=Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10);

    @TestFactory
    public Stream<DynamicTest> probarSumasVariaditas(){
        return mis_numeros.stream().
            map( (numero) -> DynamicTest.dynamicTest("Prueba a sumar: "+numero, ()->{
                    int numero_base=5;
                    instancia=new App(numero_base);
                    double RESULTADO=instancia.suma(numero).getNumero();
                    Assertions.assertEquals( numero_base + numero , RESULTADO );
                }
            ));
    }
    
    
    @TestFactory
    public Stream<DynamicTest> probarRestasVariaditas(){
        return mis_numeros.stream().
            map( (numero) -> DynamicTest.dynamicTest("Prueba a sumar: "+numero, ()->{
                    int numero_base=5;
                    instancia=new App(numero_base);
                    double RESULTADO=instancia.suma(numero).getNumero();
                    Assertions.assertEquals( numero_base + numero , RESULTADO );
                }
            ));
    }
}
