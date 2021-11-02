package es.curso;


import org.junit.Assert;
//import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class AppTest {
    
    @Test
    public void pruebaSuma_Positivos() {
        int numero1=5;
        int numero2=6;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=11;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }    
    
    @Test
    public void pruebaSuma_Negativos() {
        int numero1=-5;
        int numero2=-6;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-11;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }    
    
    @Test
    public void pruebaSuma_PositivoYNegativo() {
        int numero1=5;
        int numero2=-6;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }    
    
    @Test
    public void pruebaSuma_NegativoYPositivo() {
        int numero1=-5;
        int numero2=6;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }    
    
    @Test
    public void pruebaSuma_CeroPositivo() {
        int numero1=5;
        int numero2=0;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=5;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }    
    
    @Test
    public void pruebaSuma_CeroNegativo() {
        int numero1=0;
        int numero2=-6;
        int resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-6;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    
}
