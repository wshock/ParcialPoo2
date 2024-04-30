package Lógica;
import java.sql.*;
public class AprobarIngreso {
    public static Boolean consultarAprobacion (String username, String password)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection cnx = Conectar.conexion();
        String consulta = "SELECT * FROM usuarios";

        Statement s = cnx.createStatement();
        ResultSet resultado = s.executeQuery(consulta);


        Boolean bandera = false;

        while(resultado.next()){
            if ((resultado.getString("username").equals(username)) && resultado.getString("password").equals(password)){
                bandera = true;
                return bandera;
            }
        }

        return bandera;
    }


}
