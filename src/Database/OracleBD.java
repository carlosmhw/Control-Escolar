package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;

public class OracleBD {

    //Usuario de la base de datos
    private final String USUARIO = "SYSTEM";
    //Contraseña del usuario de la base de datos
    private final String PASS = "SYSTEM4321d";
    //SID de la base de datos, este lo registramos en la instalacion
    private final String SID = "CONTROL";
    //Host donde se encuentra la base de datos, para nuesto caso como es local
    //se indica que esta en localhost
    //PUBLICA 189.244.130.55
    //LOCAL 192.168.1.10
    private final String HOST = "192.168.1.10";
    //El puerto 1521 es el estandar para este tipo de instalaciones a menos que
    //se indicque lo contrario
    private final int PUERTO = 1521;
    //Objeto donde se almacenara nuestra conexion
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    /*
     * Instanciamos un objeto de tipo OracleDriver para regitrarlo y posterior uso
     * este objeto lo provee el driver que agregamos al principio
     */
    public void registrarDriver() throws SQLException {
        OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(oracleDriver);
    }

    /*
     * Procedemos a realizar nuestra conexion a la base datos, para esto nos
     * aseguramos que el objeto este null o que este cerrada la conexion.
     * 
     * cadanaConexion: es un string que se contruye a partir de los atributos
     * definidos.
     * 
     * Finalmente obtenemos la conexion.  El metodo "getConnection"
     * lanza una excepcion la cual propagamos "throws SQLException".
     */
    public void conectar() throws SQLException {
        //System.out.println(connection);
        if (connection == null || connection.isClosed() == true) {
            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
            registrarDriver();
            connection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);
            System.out.println("Conectado");
        }
    }

    /*
     * Con este metodo cerramos la conexion una vez hayamos terminado de usar la
     * base de datos
     */
    public void cerrar() throws SQLException {
        if (connection != null && connection.isClosed() == false) {
            connection.close();
        }
    }
}