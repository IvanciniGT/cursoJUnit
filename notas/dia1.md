Pruebas | Testing | Q&A

Desarrollador y Pruebas *** 



# Pruebas unitarias?

Comprobar si lo que hemos programado funciona tal y como 
    debería en todos los casos. Pruebas a bajo nivel.
Código con calidad    




TDD
SonarQube
Jenkins


Metodologías en cascada
    
    Requisitos > Analisis > Planificacion > Desarrollo > Pruebas > Documentación > Implantación 
    Dia 1
    
Manifiesto agil
    Metodologias agil: SCRUM, XP, Kanban

Dia 1 200 requisitos -> SACA !
25 - Entrega 25 requisitos - 1 mes -> Producción 10% funcionalidad - 100% funcional
20 requisitos 
15 requisitos

Que implica instalar en producción? Pruebas 1 mes
mes 1 - probar 25 requisitos
mes 2 - probar 25 + 20

-----
500 pruebas
50
50 +50
50 + 50 + 50 ...
2500 pruebas

No hay recursos humanos... AUTOMATIZAR


DEV--EMPAQUETADO, INSTALACIONES, DISTRIBUCION, PRUEBAS---->OPS ?  Cultura, fisolofía que me invita a automatizar TODO en un empresa IT
    
Jenkins? Servidor de CI/CD
    Orquestador de tareas
    
DEVOPS 
    Integración Continua
    Entrega Continua
    Despliegue continuo

App X
Planificacion/Requisitos
Desarrollo
    -> Compilar, empaquetar, gestión de dependencias: maven, gradle, msbuild, nuget, npm
                                                        apache ant 20 años
    -> Pruebas.... Qué pruebas?
        Plantear las pruebas
        Necesito instalar?
            Si. 
            No. 
        Muchos tipos de pruebas
        Herramienats que nos ayudan a automatizar esas pruebas
            SonarQUBE
            JUNIT
            Postman
            SOAPUI
            Selenium: Automatizar tareas en un navegador de internet
    
    -> Instalar: 
        Ansible
        Chef
        Puppet
    
    -> Obtención de una infraestructura , entorno
        Contratando en un cloud
            Terraform
            Vagrant
            
    --> Codigo -> Repo de un SCM git, mercurial, svn, cvs
    --> Y lo que instalo en el entorno de producción? Repos de artefactos:
            Maven central? Codigo fuente? jar war ear
            Nexus, Artifactory
        
        Automatizando tareas concretas no es suficiente... solo es el primer paso
    
    Alquien que orqueste todo eso: Jenkins, Travis CI, Azure Devops, Bamboo, Teamcity
            
Tipos de pruebas: ISTQB < Tester 2.0
    Estaticas. No requieren tener el código en funcionamiento , en ejecución
        ? Vulnerabilidades
          Bugs
          Calidad código
            Comentar    - Como lo hace
            Documentar  - Como usarlo, que hace
        Herramientas que automatizan esto: SonarQube <<<< 
    Dinamicas. Si requieren tener el codigo en funcionamiento, ejecutarlo
        Funcionales: Ver si mi codigo hace lo que tiene que hacer
            Unitarias
            De integración
            De sistema
            De aceptación
        No funcionales
            De carga
            Estres
            De rendimiento
            UI
    
De aceptación: Muchas - Impone el cliente
Sistema: - Instalo en algun sitio y pruebo que funciona el conjunto
Integración - Si 2 funciones son capaces de hablar bien entre si. Comunicación
Unitarias - Pocas o ninguna - Tratan de determinar si una función funciona adecuadamente
    
    
Objetiva... que cuando una prueba falle, sepa identificar univocamente lo que ha fallado    
    
    
    
Unitarias tener muchas...  muchisismas !!! un orden de magnitud por encima del numero 
                                            de funciones que tiene mi codigo    
    Quiero probar cada funcion, en multitud de escenarios. a ver si aquello funciona.
    
    Si todas mis funciones funcionan adecuadamente... tengo garantizado que el sistema funciona?
    NO. 
    Imaginad una función que guarda un dato del usuario en la sesión
        - Int
    Otra funcion lee el dato
        - String
    
Cuantas pruebas de integración, más o menos que unitarias? Menos, bastantes menos
Sistema: Quiero probar el sistema en su conjunto.
    Entro, hago login, hago una busqueda y se devuelven datos. POCAS
De aceptación. Las marca el cliente.

Con que nos ayuda JUNIT?  Con todas las pruebas funcionales.

JUNIT es un framework de pruebas. Pruebas unitarias.

Prueba?
    Validación de una característica. Que resultado puede tener una prueba?
        - Correcto                  Success
        - Incorrecto                Failure
        - No ha podido realizarse   Error
    Quiero asegurar que se cumple algo: ASSERT

Deberiamos tener 1 caso de prueba para cada assert que quiera comprobar
Una prueba puede dar lugar a muchos casos de prueba



Servicios debilmente acoplados
Servicios WEB : SOAP , WSDL, UDDI
Microservicios : REST (JSON)
Probar un microservicio: Funcional
                    Que pruebo... el consumirlo o el producirlo
                    Unitarias- Recibo los params adecuadamente
                                - Los proceso adecuandamente
                                - Dados unos parametros determinado genero la respuesta adecuadamente
                    Integración:
                        Llamo al microservicio http con unos parametros, se lo que deberia a recibir de vuelta
                            ^^^^^
                            Postman - 
                            SOAPUI  - Programa que prueba mi programa
                            Jmeter  - 
                        
                        Como se utiliza eso posteriomente... desde JUNIT -> 
                                ESTANDAR De como almacenar los resultados de las pruebas ejecutadas
                                
                                
Prueba de unas pantallas de una webapp?
    Querria probarlo en firefox?
    chrome?
    edge
    opera
    safari
    chrome versiones? Al menos en las 3/4 ultimas
    chrome windows linux macos, android - tableta - telefono
    
    Manualmente? Tengo dinero? ni de coña.
    Automatizar. Selenium
        JUNIT 
        
--------

Webapp
Necesitas una pantalla de login, con su cajita para email + password + boton login

Si el usuario es correcto, pues ok, debe entrar en la app
Si el usuario no es correcto, pues nok, no debe entrar en la app

HTML   -   Servlet   -> redirección -OK
                                    -NOK
Paso 1 - desarrollo                                    
Paso 2 - Voy a hacer las pruebas:
    Diseñar las pruebas
        Introducir un correo y un password -> comprobar resultado
            combinacion buena
            combinacion mala
    Ejecutar las pruebas
    
Diseño Prueba:
    Prueba 1: tenemos un formulario con cajitas adecuadas y un boton
                                                tipos de datos
                                                identificador del campo input html 
                                        botton haga submit al sitio adecuado 
    
    Prueba 2: usar el formulario
        Combinaciones:      Usuario   Password
                               ok        ok      caso de prueba   c1
                               ok        nok                      c2
                               nok       ok
                               nok       nok
                        Con al menos 2 juegos de datos
    
                ivan        password1
                juaquin     loquesearuinoso
                conchi      password2

Ejecuto la prueba: AUTOMATIZAR
    Selenium + JUNIT Datos de prueba


BBDD juego? La que tengo en mi ordenador maleada?    OK    Oracle 11c
            Una bbdd limpia con datos decentes?      OK    Oracle 11.1 rac
            



Acabo de montar una app con una pagina de login. Con unos campos. 
y he hecho que si los datos estén bien entre y si no, que no entre.
Ummm. voy a probar a ver si tengo una app con un formulario de login
y a ver si ssi pongo datos buenos entra.... 
Malo ha de ser que no... se acabas de montar la app para que haga eso.
^^^^^^^^^

Ikea - Sofa
Sofa regulación legal. Ikea da sus politicas adicionales
El sofa no debe prender fuego en determinadas circustancias
---> Pruebas al sofa... 

Mercedes - Coche - Estrellas euroncap  <<< nivel de seguridad
----


Tornillo Din iso

-------------------------------------------------------------------
Test Driven Development - XP: Obligan a seguir una metodologia TDD 

Paso 1: Diseña las pruebas - Requisitos. De forma automatizada.
Paso 2: Escribe código hasta que superes las pruebas
Paso 3: Disfruta !

Por si acaso..... Mala practica

El software funcionando es la medida principal de PROGRESO
                                                    ^^^^^
                                                    En cuanto había avanzado:
                                                    - Número de requisitos implementados < desarrollador 
                                                    - Número de lineas de código DESASTRE
            ^^^^^^^^^^^
        >>>>>   Número de requisitos que han superado las pruebas definidas para ellos   <<<<<

Programa que prueba mi programa, sin tener el programa que quiero probar. API

API? interface
    Declaración de las funciones que tiene tu codigo
    No la implementación

Desarrollo la implementación de un programa de prueba
Y lo ejecuto... Y que me dice el programa de prueba? funciona todo bien?
No, no puede funcionar... por que no hay implementación

Ponte a implementar... y ve ejecutando pruebas... y cuando todas funionen, has acabado

Pruebas unitarias son una bendición <<<<<

Java 1.8 + maven


MAVEN < arquetipo
    pom.xml                   <<<<<<     Dependencias + plugins + propiedades configuracion
    src
        main
            java
            webapp
            resources
        test
            java
    target
        classes
        test-classes .class
        surefire-reports/ *.xml  Resultados de las pruebas
        empaquetado.jar...war...ear
    
mvn clean   > Borrar la carpeta target
    
mvn compile > Compilar .java -> .class  
    VVV
mvn test-compile > Compilar las pruebas 
    VVV
mvn test > Ejecutar las pruebas ya compiladas
    VVV
mvn package > Empaquetar el proyecto en un .jar .war .ear
    VVV
mvn install > Dar de alta el empaquetado en el repo local .m2


set PATH=%PATH%;c:\maven\bin
mvn --version

JUnit 4 - 
JUnit 5 - Jupiter. Soporte para programación funcional (Java1.8)