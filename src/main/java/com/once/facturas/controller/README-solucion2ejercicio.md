@RestController
@RequestMapping(value = "/productos")
public class ProductosController {

   
 
// Ejercicio excepciones java- try, catch y finally- localhost:8080/productos/2/
@GetMapping("{id}/")
public Producto getProducto(@PathVariable Long id){
    
     System.out.println("valor devuelto: "+ repositoryProducto.findById(id));
   
       Optional <Producto> p = repositoryProducto.findById(id);
 
        if p.(isEmpty())
        return null;
    }
    return p;
}






















// Ejercicio excepciones java- try, catch y finally
@GetMapping("{id}/")
public Producto getProductos(@PathVariable Long id){
    Producto productoid;

    repositoryProducto.count();
    if(id>0 && id<=repositoryProducto.count()) {
        productoid = repositoryProducto.findById(id).get();

    }else{ //throw new NoSuchElementException();
        NoSuchElementException  miException = new NoSuchElementException("Hay un error el productocon con id= "+id+ " no existe ");
        System.out.println(miException.getMessage());
        return null;
    }
    return productoid;
} 

