
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        
        try {
            
           Class.forName(DRIVER);
           String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
           conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
            
        }
     
        
    }
    
    protected void desconectarBase() throws Exception {
        
        try {
            if (resultado != null) {
                resultado.close();
            }
            
             if (sentencia != null) {
                sentencia.close();
            }
             
              if (conexion != null) {
                conexion.close();  
            }
            
            
        } catch (Exception e) {
            throw e;
        }   
    }
    
    
    protected void instarModificarEliminar(String sql) throws Exception {
        
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
        } catch (SQLException | ClassNotFoundException ex) {
            /*conexion.rollback(); sirve por si por ej se estan cargando 1000 datos y en la linea 500
            arroja un error, el rollback deshace todo como si no se hubiera ingresado ningun dato 
            y se debe tener el commit en true :
            SET autocommit =1;
            COMMIT;*/
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    
    
    protected void consultarBase(String sql) throws Exception {
        
        try {
            conectarBase();
            sentencia= conexion.createStatement();
            resultado= sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
    
    
    
}
