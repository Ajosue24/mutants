# **Ejercicio de Programación**

## **Índice**
---

1. [Premisa](#id1)
2. [Desafíos](#id2)
3. [Tecnologías](#id3)
4. [Requerimientos](#id4)
5. [Código e información adicional](#id5)
6. [Docker](#id6)
7. [Casos de prueba](#id7)

> ## **Premisa**
<div id='id1' />
---

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. Te ha contratado a ti para que
desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN. Para eso te ha pedido
crear un programa con un método o función con la siguiente firma (En alguno de los siguiente lenguajes: Java / Golang /
C-C++ / Javascript (node) / Python / Ruby):
boolean isMutant(String[] dna); // Ejemplo Java En donde recibirás como parámetro un array de Strings que representan
cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Ejemplo Humano
<table>
    <tr>
        <th>A</th>
        <th>T</th>
        <th>G</th>
        <th>C</th>
        <th>G</th>
        <th>A</th>
    </tr>
    <tr>
        <th>C</th>
        <th>A</th>
        <th>G</th>
        <th>T</th>
        <th>G</th>
        <th>C</th>
    </tr>
    <tr>
        <th>T</th>
        <th>T</th>
        <th>A</th>
        <th>T</th>
        <th>T</th>
        <th>T</th>
    </tr>
    <tr>
        <th>A</th>
        <th>G</th>
        <th>A</th>
        <th>C</th>
        <th>G</th>
        <th>G</th>
    </tr>
    <tr>
        <th>G</th>
        <th>C</th>
        <th>G</th>
        <th>T</th>
        <th>C</th>
        <th>A</th>
    </tr>
    <tr>
        <th>T</th>
        <th>C</th>
        <th>A</th>
        <th>C</th>
        <th>T</th>
        <th>G</th>
    </tr>
</table>
<table>
<tr>
    <th>A</th>
    <th>T</th>
    <th>G</th>
    <th>C</th>
    <th>G</th>
    <th>A</th>
</tr>
<tr>
    <th>C</th>
    <th>A</th>
    <th>G</th>
    <th>T</th>
    <th>G</th>
    <th>C</th>
</tr>
<tr>
    <th>T</th>
    <th>T</th>
    <th>A</th>
    <th>T</th>
    <th>G</th>
    <th>T</th>
</tr>
<tr>
    <th>A</th>
    <th>G</th>
    <th>A</th>
    <th>A</th>
    <th>G</th>
    <th>G</th>
</tr>
<tr>
    <th>C</th>
    <th>C</th>
    <th>C</th>
    <th>C</th>
    <th>T</th>
    <th>A</th>
</tr>
<tr>
    <th>T</th>
    <th>C</th>
    <th>A</th>
    <th>C</th>
    <th>T</th>
    <th>G</th>
</tr>
</table>



**Desafíos**
---
<div id='id2' />

Nivel 1:
Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto.
Nivel 2:
Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:

POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
<br>En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden
Nivel 3:
Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1
millón de peticiones por segundo).
Test-Automáticos, Code coverage > 80%.
Entregar:
● Código Fuente (Para Nivel 2 y 3: En repositorio github).
● Instrucciones de cómo ejecutar el programa o la API. (Para Nivel 2 y 3: En README de
github).
● URL de la API (Nivel 2 y 3)

> ## **Tecnologias**
<div id='id3' />
---
- Java 11
- Spring versiones 2.5.0
- JUnit 5
- Mockito
- Docker
- Postman / Swagger
- Gradle

> ## **Requerimientos**
<div id='id4' />
---
Para ejecutar el programa es necesario contar con los siguientes requerimientos:

- Java 11
- Gradle >= 7
- Docker
- Git

> ## **Código e información adicional**
<div id='id5' />
---
- GitHub, repo url = `https://github.com/Ajosue24/mutants/tree/mutants_dev` -> [repositorio](https://github.com/Ajosue24/mutants/tree/mutants_dev)
- Para Obtenerlo se debe de ejecutar el siguiente comando desde la consola

        git clone --single-branch --branch mutants_dev https://github.com/Ajosue24/mutants.git

   Al descargar el repositorio y abrirlo en un IDE podemos tener acceso al código y a sus funcionalidades
- La aplicación al levantarse cuenta con un swagger en la siguiente
  URL `http://localhost:9191/api/swagger-ui/#/`
- Dentro de la raiz del proyecto se encuentra una carpeta generada de informe para las pruebas generadas por jacoco
  /mutants/jacocoHtml
  


> ## **Docker**
<div id='id6' />
---
Se creo archivo Dockerfile para poder tener una imagen docker de la misma y se pueda ejecutar desde su contenedor, 
 Dentro de docker file se agregó comando para hacer build del código sin necesidad de ejecutar algo adicional

ejecutar el siguiente comando en la raiz del proyecto
> `docker build -t mutans-validator`
y luego el siguiente
> `docker run -p 9191:9191 mutans-validator`

<br>


> ## **Casos de prueba**
<div id='id7' />

1. Para validar si un humano es un mutante se debe de importar en postman el archivo que estará en la siguiente ruta
   > /mutants/postman/mutants.postman_collection.json
   
Al importar el archivo de postman lograremos ver 2 escenarios donde en uno de ellos retornara mutante o humano según corresponda

De lo contrario podemos acceder a la ruta del swagger dejada en uno de los puntos anteriores y hacer pruebas según como el usuario lo vea pertinente

<!-- CONTACT -->
## Contactame

- Ajosue24 - [@twitter](https://twitter.com/Ajosue24) /  https://twitter.com/Ajosue24
- Linkedin - [@Linkedin](https://www.linkedin.com/in/ajosue24/) / https://www.linkedin.com/in/ajosue24/
  <br>
- josue24664@hotmail.com / josue24664@gmail.com 
