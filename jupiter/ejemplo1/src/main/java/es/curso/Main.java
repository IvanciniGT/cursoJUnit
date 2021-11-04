package es.curso;

import java.util.function.*;
import java.util.*;

public class Main {

    public static String getNombre(){
        return "Ivan";
    }
    
    public static void imprimeNombre(Supplier<String> suministradorDeNombre){
        System.out.println("Tu nombre es: " + suministradorDeNombre.get());
    }

    public static void main( String[] args )    {
        
        Supplier<String> suministradorDeNombre=()-> "Ivan";
        
        imprimeNombre( suministradorDeNombre );
        imprimeNombre( ()-> "Lucas" );
        
        // Collections para aprovechar la programacion funcional
        List<Integer> mis_numeros=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        mis_numeros.forEach(    (numero) -> System.out.println(numero*2)      );
        mis_numeros.stream().
            map( (numero) -> numero*2 ).
            map( (numero) -> numero-5 ).
            map( (numero) -> numero*numero ).
            forEach(System.out::println);
        
    }
    
    // Función lambda? Función anónima
}
