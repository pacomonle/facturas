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
@RequestMapping(value = "/vista")
public class ProductosController  {

 
// anotación @Value para inicializar las propiedades.
// Hemos hecho uso de spring expression language para acceder a cada uno de los valores
// utilizando ${valor} . De esta forma tan sencilla seremos ya capaces de acceder a 
// las propiedades definidas en el fichero application.properties

    @Value("${aplicacion.nombre}")
    private String nombreAplicacion;

    @Autowired
    Repositoryproducto repositoryProducto;

    

     @GetMapping("/producto")
     @ResponseBody
     public ModelAndView creaProducto() {
 
         ModelAndView modelAndView=new ModelAndView("newProducto");
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
        
        ModelAndView modelAndView=new ModelAndView("newProducto"); 
        
    try{
            
         Producto producto=new Producto(descripcion, fabricante, precio);
         modelAndView.setViewName("newProducto");
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