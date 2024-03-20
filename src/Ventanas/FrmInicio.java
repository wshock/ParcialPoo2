package Ventanas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FrmInicio extends Ventana implements ActionListener {
    public static void main(String[] args) {
        FrmInicio tal = new FrmInicio();
    }
    // Ventanas
    public static FrmListar frmListar;
    public static FrmRegistrar frmRegistrar;


    // Botón
    static JButton btnListar;
    static JButton btnRegistrar;

    /* DE AQUÍ SE SACAN LOS JLABELS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrar)) {
            ventanaRegistro.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnListar)){
            ventanaListado.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnBuscar)){
            ventanaBusqueda.setVisible(true);
            this.setVisible(false);
        }
    }

     */


    public FrmInicio(){
        agregarComponentes();
    }

    public void agregarComponentes(){
        agregarLabels();
        agregarBotones();
    }

    public void agregarLabels(){

    }


    public void agregarBotones(){

    }




}
