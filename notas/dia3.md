App
    Funcionalidades
    Pruebas
        Unitarias
        Integracion
            
        
        Local
        EntornoReal
        
        Sencillas
        Completas

5 personas equipo
Laptop/PC - Instalados "algunos" componentes de mi app
    Tomcat
    MySQL
    Microservicio  <<<
    Servicio       <<<
Desarrollo
    Version Alfa de todos los microservicios de mi proyecto
Integracion
    Version Beta de todos los microservicios de mi proyecto
Test - Q&A
    Version Produccion de todos los microservicios de mi proyecto menos los que estoy desarrollando
Produccion

Red Microservicios APP
Servicio 76 ---> 99   no existe... ni siquiera está planificado su desarrollo
            ---> 77   está en desarrollo
            ---> 23   está en produccion



Pruebas de distinta naturaleza. Ejecutar en distintos entornos
Pruebas unitarias LOCAL. Como pruebo yo mi app si el ms 77 no existe? Mock
    Mock? Simular un componente que no existe o al que no tengo acceso o que me quiero aislar de él.
        Mock MS: Postman, SoapUI < Herramientas pruebas / mocking de Servicios WEB / Microservicios
            Postman: Abreme un puerto en local: http: RUTA / ARGS(arg1, arg2)
                ->
                    {
                        "tag1": arg1,
                        "tag2": [
                                true,
                                37
                                arg2
                            ]
                    }
    
Prueba unitaria de mi ms -> mock (Primero es arrancar el mock) --- No la ejecuto en todos los entornos
    - desarrollo

Prueba integración de mi ms -> Servicio real
    - integración
    
SmokeTest VER QUE TODO FUNCIONA, que la instalación fue un éxito
    - produccion
    
100 pruebas 50 pruebas    




Arquitectura de Microservicios

Aplicacion Monolitica    -> WAR    EAR
    1000 clases de Java
    Cientos de cosas
    
Sistema
    Conjunto de la funcionaldiad ofrecida por un conjunto de miniprogramas 1 tarea

SpringBoot   -> MS ---> Lleva ya dentro su propio serv apps (Tomcat) 
    

Kubernetes - Openshift    QUITAN A EQ SISTEMAS DEL FLUJO DE TRABAJO
    Contenedores

Desarrollador hace commit en git -> Producción sin mediación humana... en 5 minutos
^^^^^^^^^^^^^



Funcion:
    Llamada a un Servicio WEB http > JSON      SoapUI    postman
    Clase conecta con una BBDD 
        funcion: dameUsuario("luis@miempresa.com")
                    Usuario. Bean
                        Nombre
                        Id
                        Edad
                        Email
                        Apellidos
                        F.Nacim
        
        
        Mock --- Mockito                
            Cuando se llame a la clase GestorUsuarios.dameUsuario(userID)
            entonces devuelve siempre esto:
                Usuario :
                        Nombre: Lucas
                        Id: 13
                        Edad: 17
                        Email: kjashdkjashdj
                        Apellidos
                        F.Nacim
                        
        permitirAcceso(userID){
            Usuario usuario=GestorUsuarios.dameUsuario(userID);
            return usuario.getEdad()>18;
        }
        
        probarPermitirAccesoAMayores(id,edad){
            Inyectar Mock (Defino Mock);
            Assumptions.assumeTrue(edad>18);
            assertFalse(permitirAcceso(lucas));
            
        }
        
        // Quien controla el acceso a una BBDD? JEE
            Lo haga como lo haga ---->  Poll Conexión a la BBDD: Servidor de Apps
        
        /* Como prueba esto si el GestorUsuarios no está arrancado */
        
        
JUNIT
    Clases de Prueba
        Metodos Test    
                Parametrizados
        Factorias de Metodos de prueba
        Asserts
            Básicos
            Exceptions
        Assumptions
        Tags
        Funciones de control: After Before