package ar.unrn.tp3.bd;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConexion {

    private static final JdbcConexion instancia = new JdbcConexion();

    static JdbcConexion obtenerInstancia(){

        return instancia;
    }


   Connection obtenerConexion() throws SQLException{
        Connection conexion;
        try {
            conexion = DriverManager.getConnection("jdbc:derby:db");
        }catch (SQLException e){
        throw e;
        }
        return conexion;
   }

}
