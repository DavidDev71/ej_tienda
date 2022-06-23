
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;


public final class ProductoDao extends DAO {
    
    
    
    
    
   /*A*/ public Collection<Producto> buscarTodosLosProductos() throws Exception {
        
        try {
            
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
            
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigo_fabricante(resultado.getInt(4));  
                productos.add(producto);
            }
            
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }   
    } 
    
  /*B*/  public Collection<Producto> listarProductos() throws Exception {
        
        try {
            
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);
            
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()) {
            
            producto = new Producto();
            
            producto.setNombre(resultado.getString(1));
            producto.setPrecio(resultado.getDouble(2));
            productos.add(producto);  
                
                
            } desconectarBase();
            return productos;
            
            
        } catch (Exception e) {
            throw e;
        }   
    }
    
  /*C*/ public Collection<Producto> buscarTodosLosProductosPorPrecio() throws Exception {
        
        try {
            
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);
            
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigo_fabricante(resultado.getInt(4));  
                productos.add(producto);
            }
            
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }   
    }   
    
  /*D*/ public Collection<Producto> buscarTodosLosProductosPortatiles() throws Exception {
        
        try {
            
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%'";
            consultarBase(sql);
            
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigo_fabricante(resultado.getInt(4));  
                productos.add(producto);
            }
            
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }   
    }   
  
  /*E*/ public Collection<Producto> buscarProductoBarato() throws Exception {
        
        try {
            
            String sql = "SELECT nombre, MIN(precio) FROM producto";
            consultarBase(sql);
            
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                
                producto = new Producto();
                
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            
            desconectarBase();
            return productos;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }   
    }   
  
  /*F*/ public void guardarProducto(Producto producto) throws Exception {
        
        try {
            if(producto == null){
            throw new Exception("Debe indicar un producto");  
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante)" 
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigo_fabricante() + "' );";
            instarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        
    }

  /*H*/public void modificarProducto(Producto producto) throws Exception {
        
        try {
            if(producto == null){
            throw new Exception("Debe indicar un producto que desea modificar");  
            }
            String sql = "INSERT INTO producto (nombre, precio)" 
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' WHERE CodigoFabricante = '" + producto.getCodigo_fabricante() + "' );";
            instarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

  public void eliminarProducto(Producto nombre) throws Exception {
        
        try {
            String sql = "DELETE FROM producto WHERE nombre = '" + nombre + "'";
            instarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
 
        
    }
  
}
