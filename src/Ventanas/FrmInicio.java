package Ventanas;

import Utiles.Paciente;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FrmInicio extends Ventana implements ActionListener {

    // Ventanas
    public static FrmListar frmListar;
    public static FrmRegistrar frmRegistrar;

    // Botones
    static JButton btnListar;
    static JButton btnRegistrar;

    public static ArrayList<Paciente> pacientes = new ArrayList<>();


    public FrmInicio() {
        agregarComponentes();
    }

    public void agregarComponentes() {
        this.setTitle("Principal");
        agregarLabels();
        agregarBotones();

        frmListar = new FrmListar();
        frmRegistrar = new FrmRegistrar();
    }

    public void agregarLabels() {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrar)) {
            frmRegistrar.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnListar)){
            frmListar.setVisible(true);
            this.setVisible(false);
        }
    }

    public void agregarBotones() {
        btnListar = new JButton("Listar");
        btnListar.setBounds(150, 200, 100, 70);
        btnListar.addActionListener(this);
        add(btnListar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(300, 200, 100, 70);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);
    }
}
