# Aplicación de facturas REST

### Entidad Productos

Por cada producto:

- id: Long
- descripcion: String
- fabricante: String
- precio: Float

Son obligatorios el id y la descripción



## Mayúsculas y minúsculas en JAVA

- TitleCase: Empieza en mayúscula y mayúscula cada palabra, si hay más
- camelCase: Empieza por minúscula y mayúscula si hay más palabras
- SNAKE_MAYUSCULAS: Todas las letras en mayúsculas y si hay más palabras las separamos por _ (underscore o subrayado)

Van:

- Clases: TitleCase
- Variables y propiedades de un objeto: camelCase
- Métodos o funciones: camelCase
- constantes (public final static): SNAKE_MAYUSCULAS


### Aclaraciones de algún concepto

**paquetes**: *package* va al principio del fichero de una clase. No es más que los subdirectorios a partir de la carpeta src/main/java o src/test/java. Esto es, si está en la subcarpeta:

```sh
es/taesformacion/app
```

será el paquete:

```java
package es.taesformacion.app;
```

**imports**: Son las clases que vamos a usar dentro de la clase que hacemos en el fichero. 

```java
import java.util.Calendar;
import java.util.GregorianCalendar;
```

Es porque vamos a usar la clase java.util.Calendar dentro del fichero.

*Si no hay conflicto de nombre* no tenemos que poner el paquete cada vez que usemos una clase, sólo el nombre de la clase, esto es:

usamos:
```java
Calendar c = new GregorianCalendar();
```

en lugar de:

```java
java.util.Calendar c = new java.util.GregorianCalendar();
```

Puede haber conflicto de nombres, para ello cuando queramos usar una que no es la hemos importado, la escribimos con su paquete:

```java
import java.util.Date;
// en el siguiente usamos otra diferente
java.sql.Date d = new java.sql.Date(2002, 0, 12);
```

Por defecto, todo fichero tiene precargado el import de java.lang.*;


// count()
long i = 8;
String str  = String.valueOf(i);
System.out.println(str);

String str2 = ""+i;
System.out.println(str2);



Para que el controlador tenga un mapeo específico:

```java
@RequestMapping(value = "/productos")
class ProductoController {
```



Para generar un controlador REST:

1. Anotar la clase con @RestController (cuando haces una llamada GET la web te responde en json)


## Rutas

URL / URI :

http://localhost:8080/productos/0/

#### Protocolo:
- http:// Cómo vamos a acceder a esta dirección

Otros protocolos:
- https://
- file://
- jdbc:mysql//
- odbc:mysql//

#### Host
- localhost

Otros host:
- google.com
- facebook.com
- 98.67.65.32

### Puerto
- :8080 (Standard de Tomcat, que servidor de aplicaciones de Spring Boot)

Otros puertos:
- :80 (por defecto en http) : puerto de http
- :443 (por defecto https): puerto de https

Podemos elegir el puerto que queramos a partir del 1024
Por debajo son por defecto.

### Contexto de Aplicación
- /

Otros:
- /nombreaplicacion/

### Ruta
- /productos/0/

Otras:
- /helloworld

