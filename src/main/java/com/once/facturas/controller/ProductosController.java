package com.once.facturas.controller;

import javax.websocket.server.PathParam;

import com.once.facturas.model.Producto;
import com.once.facturas.model.Repositoryproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


// Ejercicio
    @GetMapping("/{id}/")
    public Producto getProducto(

        @PathParam("id") Long id){
            
            System.out.println(repositoryProducto.findById(id));
            return  repositoryProducto.findById(id).get();

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
