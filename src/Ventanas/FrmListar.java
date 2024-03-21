package Ventanas;

import Utiles.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmListar extends Ventana implements ActionListener {

    static DefaultTableModel model;
    static JTable tabla;
    static JScrollPane scrollpane;
    static JLabel lblTitulo;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }

    static JButton btnBack;

    public FrmListar(){
        super();
        this.setVisible(false);
        this.setTitle("Listado pacientes");

        agregarComponentes();
    }

    private void agregarComponentes(){
        colocarBotones();
        colocarTabla();
        colocarLabels();
    }

    private void colocarLabels(){
        lblTitulo = new JLabel("Lista de pacientes:", SwingConstants.CENTER);
        lblTitulo.setBounds(0,30,600,40);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,27));
        add(lblTitulo);


    }

    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon("img/back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);



        add(btnBack);
    }

    private void colocarTabla(){
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("Documento");


        scrollpane = new JScrollPane(tabla);
        scrollpane.setLocation(40,80);
        scrollpane.setSize(500,400);
        add(scrollpane, BorderLayout.CENTER);



    }

    public static void actualizarTabla(){
        model.setRowCount(0);
        for (Paciente paciente: FrmInicio.pacientes ){
            model.addRow(paciente.getInformacionPaciente());
        }
    }


}
