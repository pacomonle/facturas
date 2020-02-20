package com.once.facturas.controller;

import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import com.once.facturas.model.Producto;
import com.once.facturas.model.Repositoryproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

/**
 * MainController- ProductosController
 * 
 */

// etiqueta para crear un controller
 
//@Controller

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







// Ejercicio excepciones java- try, catch y finally
@GetMapping("/{id}/")
public Producto getProducto(@PathVariable Long id){
    Producto productoid;

 // en el try ponemos el codigo que puede dar error   
    try{
        productoid = repositoryProducto.findById(id).get();
        
  // Java.util- NoSuchElementException se lanza cuando tratas de acceder a un elemento 
  // de una secuencia que no existe      

// en el catch entre parentesisnva (tipo variable) y luego {gestion de la exceppcion} 
    }catch(NoSuchElementException exception){
        NoSuchElementException miError = new NoSuchElementException("Hay un error el producto con id= "+id+ " no existe ");
        System.out.println(miError.getMessage()); //.getMessage es el metodo que lanza mi excepcion con un string 
        return null;
    }
    return productoid;  //recordar que productoid = repositoryProducto.findById(id).get();
}
    


   // creamos directorio producto para crear nuevos productos
     @GetMapping("/producto")
     @ResponseBody
     public ModelAndView creaProducto() {
 
         ModelAndView modelAndView=new ModelAndView("producto");
         modelAndView.addObject("mensaje", "");
         return modelAndView;
     }
 
     @PostMapping("/producto")
     public ModelAndView clientePost(
         @RequestParam("descripcion") String descripcion,
         @RequestParam("fabricante") String fabricante,
         @RequestParam("precio") Float precio
     ){
         ModelAndView modelAndView=new ModelAndView("producto");
         Producto producto=new Producto(descripcion, fabricante, precio);
         
         repositoryProducto.save(producto);
         
         return modelAndView;
     }


    
     // creamos el endpoint /contar - vamos a contar el numero de productos que tenemos

     

     @GetMapping("/count")
     @ResponseBody
     public String countProducto() {

       return "Tengo un total de " + String.valueOf(repositoryProducto.count()) + " productos " ;

     }

     




}   
