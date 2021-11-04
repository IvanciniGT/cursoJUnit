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