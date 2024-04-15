package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    public Ventana() {
        setSize(600, 600); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Para que cuando cierre la ventana, el programa finalice
        setTitle("Aplicación Médica"); // Establece un título a la ventana
        setLocationRelativeTo(null); // Establecemos la ventana en el centro de la pantalla
        setLayout(null);

        // Establecemos un color de fondo más atractivo
        getContentPane().setBackground(new Color(240, 240, 240));

        // Cambiamos el color de los componentes
        UIManager.put("Button.background", new Color(51, 153, 255));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 13));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
