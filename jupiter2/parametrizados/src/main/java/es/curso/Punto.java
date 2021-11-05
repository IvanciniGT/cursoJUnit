package es.curso;

public class Punto{
    
    private double x;
    private double y;
    
    public Punto(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    public double distanciaAlOrigen(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
}
