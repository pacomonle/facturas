Excepciones, o sencillamente problemas. En la programación siempre se producen errores, más o menos graves, pero que hay que gestionar y tratar correctamente. Por ello en java disponemos de un mecanismo consistente en el uso de bloques try/catch/finally. La técnica básica consiste en colocar las instrucciones que podrían provocar problemas dentro de un bloque try, y colocar a continuación uno o más bloques catch, de tal forma que si se provoca un error de un determinado tipo, lo que haremos será saltar al bloque catch capaz de gestionar ese tipo de error específico. El bloque catch contendrá el codigo necesario para gestionar ese tipo específico de error. Suponiendo que no se hubiesen provocado errores en el bloque try, nunca se ejecutarían los bloques catch.

palabras reservadas para tratamiento de excepciones:

- Try.

- Catch.

- Finally.


Veamos ahora la estructura del bloque try/catch/finally:

         try
         {
         //Código que puede provocar errores
         }
         catch(Tipo1 var1)
         {
	         //Gestión del error var1, de tipo Tipo1
         }
         [  

         catch(TipoN varN)
         {
	         //Gestión del error varN, de tipo TipoN
         } ]
         [
         finally
         {
	         //Código de finally
         }
         ]
         
Como podemos ver es obligatorio que exista la zona try, o zona de pruebas, donde pondremos las instrucciones problemáticas. Después vienen una o más zonas catch, cada una especializada en un tipo de error o excepción. Por último está la zona finally, encargada de tener un código que se ejecutará siempre, independientemente de si se produjeron o no errores.

Se puede apreciar que cada catch se parece a una función en la cuál sólo recibimos un objeto de un determinado tipo, precisamente el tipo del error. Es decir sólo se llamará al catch cuyo argumento sea coincidente en tipo con el tipo del error generado.