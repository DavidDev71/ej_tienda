
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDao;



public class ProductoService {
    
    private ProductoDao dao;
    Producto producto = new Producto();
    public ProductoService(){
        this.dao = new ProductoDao();
    }
    
     Scanner leer = new Scanner (System.in);
    
//    public void crearProducto(String nombre, double precio, int codigo_fabricante) throws Exception {
//        
//        try {
//            
//         if (nombre == null || nombre.trim().isEmpty()) {
//             
//             throw new Exception ("Debe indicar el nombre del producto");
//         }
//         
//        Producto producto = new Producto();
//        producto.setNombre(nombre);
//        producto.setPrecio(precio);
//        producto.setCodigo_fabricante(codigo_fabricante);
//        dao.guardarProducto(producto);
//            
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    
    
    public void crearProducto() throws Exception {
    
        try {
            
            System.out.println("Ingrese nombre de producto");
            producto.setNombre(leer.next());
            
         if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
             
             throw new Exception ("Debe indicar el nombre del producto");
         }
         
            System.out.println("Ingrese el precio");
            producto.setPrecio(leer.nextDouble());
            
            System.out.println("Ingrese codigo de fabricante");
            producto.setCodigo_fabricante(leer.nextInt());
         
            
        
        dao.guardarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
    } 
    
    public void modificarProd() throws Exception {
        
        try {
            
            System.out.println("Ingrese nombre de producto nuevo");
            producto.setNombre(leer.next());
            
         if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
             
             throw new Exception ("Debe indicar el nombre del producto");
         }
         
         
            System.out.println("Ingrese el precio nuevo");
            producto.setPrecio(leer.nextDouble());
            
            
            System.out.println("Ingrese el codigo de fabricante que elije modificar");
            producto.setCodigo_fabricante(leer.nextInt());
         
            
            
        
        dao.modificarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
    
    public Collection<Producto> todosLosProductos() throws Exception {
        
       try {

            Collection<Producto> productos = dao.buscarTodosLosProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        } 
        
    }
    
    public void imprimirProductos() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = todosLosProductos();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public Collection<Producto> listarNombreYPrecio() throws Exception {
        
     try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        } 
    }
    
    public void imprimirNombreYPrecio() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarNombreYPrecio();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
     
    
    public Collection<Producto> ListarEntrePrecio() throws Exception {
        
        try {

            Collection<Producto> productos = dao.buscarTodosLosProductosPorPrecio();

            return productos;
        } catch (Exception e) {
            throw e;
        }  
        
    }
    
    public void ImprimirEntrePrecio() throws Exception {
        
       try {

            //Listamos los usuarios
            Collection<Producto> productos = ListarEntrePrecio();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        } 
        
    }
    
    
    
    public Collection<Producto> ListarPortatiles() throws Exception {
        
        try {

            Collection<Producto> productos = dao.buscarTodosLosProductosPortatiles();

            return productos;
        } catch (Exception e) {
            throw e;
        }   
        
    }
    
    public void ImprimirPortatiles() throws Exception {
        
         try {

            //Listamos los usuarios
            Collection<Producto> productos = ListarPortatiles();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        } 
        
    }
    
    
    
    public Collection<Producto> ListarMasBarato() throws Exception {
        
       try {

            Collection<Producto> productos = dao.buscarProductoBarato();

            return productos;
        } catch (Exception e) {
            throw e;
        }   
    }
    
    public void ImprimirMasBarato() throws Exception {
        
        try {

            //Listamos los usuarios
            Collection<Producto> productos = ListarMasBarato();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }  
    }
    
    
    
   
    
    
    
    
    }
