@RestController
@RequestMapping(value = "/productos")
public class ProductosController {

   
 // creamos el endpoint /producto - vamos a introducir datos  de nuevos productos  
    
     // primero llamamos al repositorio    
@Autowired
Repositoryproducto repositoryProducto;
     
     
   // listado de productos
   @GetMapping("/")
   public Iterable<Producto> getAllProductos() {

      return repositoryProducto.findAll();
       
   }


// Ejercicio excepciones java- try, catch y finally
@GetMapping("/{id}/")
public Producto getProducto(@PathVariable Long id){
    Producto productoid;
    Long id;
    repositoryProducto.size();
    if(id>0 && id=<repositoryProducto.size() {
        productoid = repositoryProducto.findById(id).get();
        return productoid;
  

    }else{
       NoSuchElementException exception = new NoSuchElementException("Hay un error el productocon con id= "+id+ " no existe ");
        System.out.println(exception.getMessage());
        return null;
    }
 } 