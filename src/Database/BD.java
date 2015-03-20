

package Database;
import java.sql.*;
import javax.swing.JOptionPane;

public class BD {
/*public String db = "registro"; //Nombre de base de datos.
public String url = "jdbc:mysql://localhost/"+db; //Ruta de la base de datos a conectar.
public String user = "root"; //Nombre de usuario (root).
public String pass = "system"; //Pass del server */
public BD(){
}

 public Connection Conectar(){
     Connection link = null;
     java.sql.Connection conexion = null;
     try{
         // Carga el dirver MySQL:
         //Class.forName("org.gjt.mm.mysql.Driver");      
         Class.forName("com.mysql.jdbc.Driver");
         conexion = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost/ControlEscolar", "root","SYSTEM");
            System.out.println("Conectado");
               
         
         // Crea un vinculo a la base de datos:
         
         //link = DriverManager.getConnection(this.url,this.user, ""); 
         // Se envian los parametros antes establecidos.   
     }
     catch (Exception e) {
         System.out.println("Error driver");
         System.out.println("Error en: " + e.getMessage());
         JOptionPane.showMessageDialog(null, e);
     }
     return conexion;
}
}