package es.curso;


public class App {

    public static boolean esPar(int numero){
        return numero%2==0;
    }
    
    public static String convertirAMayusculas(String texto){
        return texto.toUpperCase();
    }
    
    public static int longitudPalabra(String texto){
        return texto.length();
    }
    
    // "HOLA" 0 -> ""
    // "HOLA" 1 -> "HOLA"
    // "HOLA" 2 -> "HOLAHOLA"
    public static String multiplicarTexto(String texto, int veces){
        StringBuilder sb=new StringBuilder("");
        for (int i=0;i<veces;i++){
            sb.append(texto);
        }
        return sb.toString();
    }
    // AlgoritmoDeHuella
    // letraDNI (numeroDNI)-> Letra
    //23  -> T
    //1234123 -> A
    public static void estoFalla(){
        throw new IllegalArgumentException("EstoyFallando");
    }
}
