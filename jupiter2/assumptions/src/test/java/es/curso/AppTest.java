package es.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
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
import org.junit.jupiter.api.Tag;

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

@Tag("tag1")
public class AppTest {

/*
mvn -Dgroups=rama test
mvn -DexcludedGroups=feature17 test
*/

   private static Logger log = Logger.getLogger(AppTest.class.getName());
   
   @ParameterizedTest
   @Tag("rama")
   @Tag("feature17")
   @Tag("integracion")
   @Tag("mock")
   @CsvFileSource(resources="/multiplicar.csv")
   void pruebaMultiplicarTexto(String texto, int veces, String resultado)  {
        String entorno=System.getProperty("entorno","produccion");
        Assumptions.assumeTrue( /*CONDICION*/ entorno.equals("desarrollo") );
        //Assumptions.assumeFalse();
        Assertions.assertEquals(resultado,App.multiplicarTexto(texto,veces));
   }
   
   @ParameterizedTest
   @Tag("tag1")
   @CsvFileSource(resources="/multiplicar.largo.csv")
   void pruebaMultiplicarTextoLargo(String texto, int veces, String resultado)  {
        Assumptions.assumeFalse( /*CONDICION*/ veces==0 );
        Assertions.assertEquals(resultado,App.multiplicarTexto(texto,veces));
   }
   
   @Test
   void probarException(){
       Assertions.assertThrows(IllegalArgumentException.class, App::estoFalla );
       
       
       try{
            App.estoFalla();
       }catch(Exception e){
           return;
       }
       Assertions.fail("Ups esto NO ha dado una excepcion");
       
   }
}
