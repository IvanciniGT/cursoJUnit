SonarQube
- Orden de complejidad de un algoritmo O(n) O(log(n))
    -> Cantidad de operaciones que va a realizar mi algoritmo para resolver un problema
    -> RENDIMIENTO / EFICIENCIA
- Complejidad ciclomática
    -> Es el número distinto de caminos que puede llevar el hilo al ejecutar un código
- Complejidad cognitiva
    -> Cómo de complejo es para un ser humano entender un código


function A:
    tarea
    tarea
    if: 
        tarea
        if:
           tarea
        else:
           tarea
        
Complejidad ciclomática: 3 <<<  Al menos tengo que hacer esta cantidad de pruebas unitarias
Complejidad cognitiva:

function B:
    switch:
        case A
            tarea
        case B
            tarea
        default
            tarea
    tarea


Cobertura de código: 80%
% de las lineas de codigo que tienen al menos una prueba unitaria validándolas




Java 1.8 => Programación funcional

Programación funcional?


Lenguajes paradigma imperativo: 



Imperativo: Voy escribiendo codigo que se ejecuta de manera secuencial, 
            sentencia tras sentencia
            
            Basic
            10 PRINT
            20 INPUT
            30 IF
            40 FOR
            50 GOTO 20  ....Moriamos

Procedural: Capacidad de definir y utilizar funciones/procedimientos
            Reutilizar codigo

Programación funcional: Referirme a una función a través de una variable.
                        (Para ello debo poder poner una función en memoria RAM)
                        Asignar a una variable una función


int numero=17;

Object funcion=doblarNumero;
    Poder pasarla como argumento a otra función
    Poder devolverla como resultado de una función




