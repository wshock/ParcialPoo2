package Lógica;

import java.sql.*;

public class RegistrarLogin {
    public static void registrarLogin(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection cnx = Conectar.conexion();
        String consulta = "INSERT INTO log_ingresos (user, date) VALUES (?, NOW());";

        try (PreparedStatement s = cnx.prepareStatement(consulta)){
            s.setString(1,username);
            s.executeUpdate();
            System.out.println("Registro exitoso");
        } catch (SQLException e){
            System.out.println("Error al registrar");
        }
    }
}
