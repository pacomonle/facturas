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
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/api/productos")
public class ProductosApiController {

   
 // creamos el endpoint /producto - vamos a introducir datos  de nuevos productos  
    
     // primero llamamos al repositorio    
     @Autowired
     Repositoryproducto repositoryProducto;
     
     
   // listado de productos
   @GetMapping("/")
   public Iterable<Producto> getAllProductos() {

      return repositoryProducto.findAll();
       
   }

// Ejercicio excepciones java- try, catch y finally- localhost:8080/productos/2/
@GetMapping("{id}/")
public Producto getProducto(@PathVariable Long id){
    

 // en el try ponemos el codigo que puede dar error   
    try{
     return  repositoryProducto.findById(id).get();
        
  // Java.util- NoSuchElementException se lanza cuando tratas de acceder a un elemento 
  // de una secuencia que no existe      

// en el catch entre parentesis va (tipo variable) y luego {gestion de la exceppcion} 
    }catch(NoSuchElementException exception){
        NoSuchElementException miError = new NoSuchElementException("Hay un error el producto con id= "+id+ " no existe ");
        System.out.println(miError.getMessage()); //.getMessage es el metodo que lanza mi excepcion  
        return null;
    }
    
}
    
   
     // creamos el endpoint /contar - vamos a contar el numero de productos que tenemos

     

     @GetMapping("/count")
     @ResponseBody
     public String countProducto() {

       return "Tengo un total de " + String.valueOf(repositoryProducto.count()) + " productos " ;

     }

 // creamos un POST para crear productos con el metodo crearProducto   
     
@PostMapping("/")
public Producto crearProducto(
     @RequestBody Producto producto
) {

   Producto p = repositoryProducto.save(producto); 

   return p; 
    
}



}   
