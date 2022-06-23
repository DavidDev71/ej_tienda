
package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDao;



public class FabricanteService {
    
    private FabricanteDao dao;
    public FabricanteService(){
        this.dao = new FabricanteDao();
    }
    
    
    
     public void crearFabricante() throws Exception {
         
         Scanner leer = new Scanner (System.in);
         Fabricante fabricante = new Fabricante();
         
         try {
             
             System.out.println("Ingrese codigo de fabricante");
             fabricante.setCodigo(leer.nextInt());
             
             if (fabricante.getCodigo() <= 9) {
                 throw new Exception ("Debe ingresar un codigo mayor a 9");
             }
             
             
             System.out.println("Ingrese nombre de fabricante nuevo");
             fabricante.setNombre(leer.next());
             
             if (fabricante.getNombre() == null || fabricante.getNombre().trim().isEmpty()) {
                 throw new Exception ("Debe ingresar un nombre"); 
             }
             
             
             dao.guardarFabricante(fabricante);
             
         } catch (Exception e) {
             throw e;
         }
         
         
     }
    
    
    
}
