package Lógica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirTxt {
    public static void crearUsuario(String username, String password){
        String nombreArchivo = "src/Usuarios.txt";

        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(username+","+password+";");
            bufferedWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
