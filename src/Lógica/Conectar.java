package Lógica;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    public static Connection conexion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String url = "jdbc:mysql://127.0.0.1:3306/hanner?user=root&password=hanner1027803781.";
        Driver d = (Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);

        System.out.println("Conectado");
        return conn;
    }
}


