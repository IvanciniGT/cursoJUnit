package es.curso;


import org.junit.Assert;
//import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class AppTest {
    
    @Test
    public void pruebaSuma_Decimales() {
        double numero1=5.1;
        double numero2=6.1;
        double resultado_obtenido=App.suma(numero1, numero2);
        double resultado_esperado=11.2;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_Positivos() {
        int numero1=5;
        int numero2=6;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=11;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_Negativos() {
        int numero1=-5;
        int numero2=-6;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-11;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_PositivoYNegativo() {
        int numero1=5;
        int numero2=-6;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_NegativoYPositivo() {
        int numero1=-5;
        int numero2=6;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_CeroPositivo() {
        int numero1=5;
        int numero2=0;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=5;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }    
    
    @Test
    public void pruebaSuma_CeroNegativo() {
        int numero1=0;
        int numero2=-6;
        double resultado_obtenido=App.suma(numero1, numero2);
        int resultado_esperado=-6;
        Assert.assertEquals(resultado_esperado, resultado_obtenido, 0.000001);
    }
    
    @Test
    public void pruebaRara_Cero() {
        int numero1=0;
        int resultado_obtenido=App.funcionRara(numero1);
        int resultado_esperado=0;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    @Test
    public void pruebaRara_Par() {
        int numero1=2;
        int resultado_obtenido=App.funcionRara(numero1);
        int resultado_esperado=1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    @Test
    public void pruebaRara_Impar() {
        int numero1=5;
        int resultado_obtenido=App.funcionRara(numero1);
        int resultado_esperado=10;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    @Test
    public void pruebaRara_ParNegativo() {
        int numero1=-2;
        int resultado_obtenido=App.funcionRara(numero1);
        int resultado_esperado=-1;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    @Test
    public void pruebaRara_ImparNegativo() {
        int numero1=-3;
        int resultado_obtenido=App.funcionRara(numero1);
        int resultado_esperado=-6;
        Assert.assertEquals(resultado_esperado, resultado_obtenido);
    }
    
    
}
