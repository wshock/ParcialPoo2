package Lógica;

import java.io.*;
import java.util.ArrayList;

public class Profesional {
    private ArrayList<String> usuarios;
    private String rutaArchivo = "Usuarios.txt";

    public Profesional() {
        this.usuarios = new ArrayList<>();
        cargarUsuariosDesdeArchivo();
    }

    public void agregarUsuario(String usuario) {
        this.usuarios.add(usuario);
        guardarUsuariosEnArchivo();
    }

    public void eliminarUsuario(String usuario) {
        this.usuarios.remove(usuario);
        guardarUsuariosEnArchivo();
    }

    public ArrayList<String> obtenerUsuarios() {
        return this.usuarios;
    }

    private void cargarUsuariosDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                usuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuariosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String usuario : usuarios) {
                bw.write(usuario);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
