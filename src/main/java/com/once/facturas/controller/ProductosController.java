package com.once.facturas.controller;

import java.util.HashMap;

import com.once.facturas.model.Producto;
import com.once.facturas.model.Repositoryproducto;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/productos")
public class ProductosController {

    public static final String VISTA_LISTA = "lista";
    public static final String VISTA_FORMULARIO = "formulario";

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @Autowired
    Repositoryproducto repositoryProducto;

     // listado de productos
   @GetMapping("/listado")
   @ResponseBody

   public Iterable<Producto> getAllProductos() {

      return repositoryProducto.findAll();
       
   }

   @GetMapping("/lista")
   public ModelAndView listarModelAndView() {
       ModelAndView mav = new ModelAndView();
       mav.addObject("titulo", nombreAplicacion);
       mav.addObject("productos", repositoryProducto.findAll());
       mav.setViewName("VISTA_LISTA");
       return mav;
   }
   
   @GetMapping("/crear")
    public String crear(Map model) {
        Map<String, Object> newmodel = new HashMap<String, Object>();
        Producto producto = new Producto();
        newmodel.put("producto", producto);
        newmodel.put("titulo", nombreAplicacion);
        
        return VISTA_FORMULARIO;
    }
    
    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        repositoryProducto.save(producto);
        
        return "redirect:" + VISTA_LISTA;
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        repositoryProducto.findById(id).remove();

        return "redirect:../" + VISTA_LISTA;
    }




     @GetMapping("/producto")
     @ResponseBody
     public ModelAndView creaProducto() {
 
         ModelAndView modelAndView=new ModelAndView("new_producto");
         modelAndView.addObject("productos", repositoryProducto.findAll());
         
         Long suma = repositoryProducto.count();
         modelAndView.addObject("mensaje", "Total artículos: "+String.valueOf(suma));
         
         return modelAndView;
     }
 
     @PostMapping("/producto")
     public ModelAndView creaProductoPost(
         @RequestParam("descripcion") String descripcion,
         @RequestParam("fabricante") String fabricante,
         @RequestParam("precio") Float precio
     ){
        
        ModelAndView modelAndView=new ModelAndView("new_producto"); 
        
    try{
            
         Producto producto=new Producto(descripcion, fabricante, precio);
         modelAndView.setViewName("new_producto");
         repositoryProducto.save(producto);
         
         modelAndView.addObject("productos", repositoryProducto.findAll());


        //añadimos el contador de elementos
        Long suma= repositoryProducto.count();
        modelAndView.addObject("mensaje", "Total artículos: "+String.valueOf(suma));

         return modelAndView; 
    }

    catch(Exception e){
        
        // ModelAndView modelAndView;
		modelAndView.setViewName("404");
        modelAndView.addObject("errormsg", e.getMessage());
        return modelAndView;
    }


}




}