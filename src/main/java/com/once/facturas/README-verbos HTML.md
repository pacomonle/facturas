# Verbos HTTP

- GET : Sirve para obtener cosas. "Leer". Es una operación idempotente.
- POST : Lo usamos para *crear* cosas. Es el que usan los formularios. Esta operación no es idempotente.
- PUT: Para *poner* un objeto en REST. Lo usaremos para modificar un objeto. Es idempotente.
- DELETE: Lo usaremos para borrar cosas. Es idempotente.
- PATCH: Son para modificaciones en las que se tiene en cuenta el estado actual, sin enviar toda la información de como debe quedar un objeto. NO es idempotente.

### CRUD

Crud son las siglas de :
- Create: Crear un objeto
- Read: Leer un objeto
- Update: Actualizar un objeto
- Delete: Borrar un objeto

### REST

REST son las siglas de Representation State Transfer.

Un servicio REST es un endpoint que crea el CRUD de una entidad a partir de los verbos de HTTP.

Por ejemplo, si tenemos la entidad factura, el servicio será:

GET /facturas/ - Nos devolverá una lista de facturas
GET /facturas/1/ - Nos devolverá la factura número 1 (READ)
DELETE /facturas/1/ - Nos borrará la factura número 1 (DELETE)
PUT /facturas/1/ - Nos modificará la factura número 1 (UPDATE)
POST /facturas/ - Nos crea una nueva factura (CREATE)

Y luego está el PATCH:
PATCH /facturas/1/ nos permite modificar una factura pero de la forma "añade 2 euros a la factura". 

## Idempotente

Una operación es idempotente si no importa que se ejecute 1 o n veces, que el estado final no cambia.

(GET) Si leemos 4 veces una factura, al final la leemos.
(DELETE) Si borramos 4 veces la misma factura, al final está borrada.
(PUT) Si sobreescribimos con PUT 4 veces la misma factura , el resultado es el que le hemos enviado las 4 veces, no cambia.

Sin embargo...

(POST) Si creamos una factura 4 veces, se crean 4 facturas.
(PATCH) Si sumamos 2 euros a una factura cuatro veces, sumamos 8.

## JSON

Son las siglas de Javascript Object Notation, Notación de objetos de Javascript

```json
{
    "nombre": "Pepe",
    "edad": 36
}
```



#### Coleccion en JSON
```json
[
    {
        "nombre": "Pepe",
        "edad": 36
    },
    {
        "nombre": "Juan",
        "edad": 56
    }
]
```

OneToMany:

```json
{
    "nombre": "Azulejos Pepe",
    "CIF": "B98765453",
    "facturas" : [
        {
            "id": 1
            "importe": 37
        },
        {
            "id": 2
            "importe": 78
        }
        ]
}
```


### Tipos de *objetos* json

```json
let prueba = { "string": "mi string", 
               "boleano": true,
               "numero": 56.4,
               "objeto": {
                          "id": 1,
                          "valor": "valor"
                          },
              "array": [34,23,"caca"]
             }