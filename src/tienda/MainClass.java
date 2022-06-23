
package tienda;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.persistencia.ProductoDao;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;


public class MainClass {

   
    public static void main(String[] args) throws Exception {
        
        ProductoService prodserv = new ProductoService();
        ProductoDao pd = new ProductoDao();
        FabricanteService fabserv = new FabricanteService();
        Scanner leer = new Scanner (System.in);
        
        
        
        
        try {
            
            String resp;
            String r = "";
            
            do {
                System.out.println("Ingrese la opción que desee realizar");
                System.out.println("A. Lista el nombre de todos los productos que hay en la tabla producto.");
                System.out.println("B. Lista los nombres y los precios de todos los productos de la tabla producto.");
                System.out.println("C. Listar aquellos productos que su precio esté entre 120 y 202. ");
                System.out.println("D. Buscar y listar todos los Portátiles de la tabla producto.");
                System.out.println("E. Listar el nombre y el precio del producto más barato.");
                System.out.println("F. Ingresar un producto a la base de datos.");
                System.out.println("G. Ingresar un fabricante a la base de datos");
                System.out.println("H. Editar un producto a eleccion.");
                
                resp = leer.next();
                
                switch (resp) {
                    
                    case "A":
                        prodserv.imprimirProductos();
                        break;
                        
                    case "B":
                        prodserv.imprimirNombreYPrecio();
                        break;
                        
                    case "C":
                        prodserv.ImprimirEntrePrecio();
                        break;
                        
                    case "D":
                        prodserv.ImprimirPortatiles();
                        break;
                        
                    case "E":
                        prodserv.ImprimirMasBarato();
                        break;
                        
                    case "F":
                      prodserv.crearProducto();
                      prodserv.imprimirProductos();
                        break;
                        
                    case "G":
                        fabserv.crearFabricante();
                        break;
                      
                    case "H":
                        prodserv.modificarProd();
                        prodserv.imprimirProductos();
                        break;
                    
                }
                    
                System.out.println("Desea seleccionar otra opción? S/N");
                r = leer.next();
                
            } while (r.equalsIgnoreCase("s"));
            
            
        } catch (Exception ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    
    
}
