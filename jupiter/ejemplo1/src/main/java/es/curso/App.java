package es.curso;


public class App {

    private double numero;
    private double original;

    public App(double numero){
        this.numero=numero;
        this.original=numero;
    }
    public App suma(double numero2){
        this.numero=App.suma(this.numero, numero2);
        return this;
    }
    public App funcionRara(){
        this.numero=App.funcionRara(this.numero);
        return this;
    }
    public double getNumero(){
        return this.numero;
    }
    public void reset(){
        this.numero=this.original;
    }






    public static void main( String[] args )    {
        //System.out.println( suma(-1,5) );
    }

    public static double suma (double numero1, double numero2){
        return numero1 + numero2;
    }
    
    public static double funcionRara(double numero){
        if(numero==0) return 0;
        if(numero%2==0) return numero/2;
        // Si recibe un numero par, debe devolver la mitad
        // Si recibe un numero impar, debe devolver el doble
        // Si recibe un cero, devuelve 0
        return numero*2;
    }
}
