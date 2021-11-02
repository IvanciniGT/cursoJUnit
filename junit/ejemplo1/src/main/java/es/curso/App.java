package es.curso;


public class App {

    public static void main( String[] args )    {
        //System.out.println( suma(-1,5) );
    }

    public static double suma (double numero1, double numero2){
        return numero1 + numero2;
    }
    
    public static int funcionRara(int numero){
        if(numero==0) return 0;
        if(numero%2==0) return numero/2;
        // Si recibe un numero par, debe devolver la mitad
        // Si recibe un numero impar, debe devolver el doble
        // Si recibe un cero, devuelve 0
        return numero*2;
    }
}
