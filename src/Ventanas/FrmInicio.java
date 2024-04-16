package Ventanas;

import Utiles.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FrmInicio extends Ventana implements ActionListener {

    // Ventanas
    public static FrmListar frmListar;
    public static FrmRegistrar frmRegistrar;
    public static FrmBuscarConsulta frmBuscarConsulta;
    public static FrmCrearConsulta frmCrearConsulta;

    // Botones
    static JButton btnListar, btnCrearConsulta;
    static JButton btnRegistrar;
    static JButton btnBuscarConsulta;
    static JLabel lblTitulo;

    public static ArrayList<Paciente> pacientes = new ArrayList<>();

    public FrmInicio() {
        agregarComponentes();
    }

    public void agregarComponentes() {
        this.setTitle("Principal");
        agregarBlueLabels();
        agregarBotones();

        frmListar = new FrmListar();
        frmRegistrar = new FrmRegistrar();
        frmBuscarConsulta = new FrmBuscarConsulta();
        frmCrearConsulta = new FrmCrearConsulta();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCrearConsulta)){
            frmCrearConsulta.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnRegistrar)) {
            frmRegistrar.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnListar)) {
            frmListar.setVisible(true);
            this.setVisible(false);
        }


        if (e.getSource().equals(btnBuscarConsulta)) {
            frmBuscarConsulta.setVisible(true);
            this.setVisible(false);
        }


    }

    public void agregarBotones() {
        btnListar = new JButton("Listar gestantes");
        btnListar.setBounds(100, 200, 150, 70);
        btnListar.addActionListener(this);
        add(btnListar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(350, 200, 150, 70);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnBuscarConsulta = new JButton("Buscar consulta");
        btnBuscarConsulta.setBounds(100, 300, 150, 70);
        btnBuscarConsulta.addActionListener(this);
        add(btnBuscarConsulta);

        btnCrearConsulta = new JButton("Crear Consulta");
        btnCrearConsulta.setBounds(350, 300, 150, 70);
        btnCrearConsulta.addActionListener(this);
        add(btnCrearConsulta);
    }

    public void agregarBlueLabels() {
        lblTitulo = new JLabel("PANTALLA INICIO:", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 30, 600, 40);
        lblTitulo.setFont(new Font("constantia", Font.BOLD, 27));
        add(lblTitulo);
    }
}
