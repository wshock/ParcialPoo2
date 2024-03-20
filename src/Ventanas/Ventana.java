package Ventanas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public Ventana(){
        setSize(600,600); // Tamaño de la ventanaw
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Para que cuando cierre la ventana, el programa finalice
        setTitle("Ventana padre"); // Establece un título a la ventana
        setLocationRelativeTo(null); // Establecemos la ventana en el centro de la pantalla
        setLayout(null);
        this.getContentPane().setBackground(Color.lightGray); // Color background

    }



}
