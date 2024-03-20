package Lógica;

public class ValidarUsuarios {

    public static boolean validarUsuario(String usuario, String password){
        boolean flag = false; // Mi flag
        String usuarios = LeerTxt.leer("src/Lógica/Usuarios.txt");

        // Este siguiente me los separará por punto y coma ";" (usuario,password)
        String[] usuarioClave = usuarios.split(";");
        // Este siguiente lo creo para separar cada uno
        String[] us;

        for (int i = 0; i < usuarioClave.length; i++) {
            // Aquí me queda en la posición [0] el uuario y [1] la contraseña
            // Esto porque los spliteo (separo) por coma ","
            us = usuarioClave[i].split(",");

            if (us[0].equals(usuario) && us[1].equals(password)){
                flag = true;
                return flag;
            }
        }

        // El for recorrerá todas las tuplas (usario,password) hasta encontrar la que se parezca

        return flag;
    }
}
