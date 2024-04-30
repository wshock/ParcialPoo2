package Ventanas;

import Utiles.Consulta;
import Utiles.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FrmCrearConsulta extends Ventana implements ActionListener {
    public static void main(String[] args) {
        FrmCrearConsulta crearConsulta = new FrmCrearConsulta();
        crearConsulta.setVisible(true);
    }


    static JLabel txtID, lblTitulo, txtFecha, txtEdadGestacional, txtPeso, txtComentario;
    static JTextField tfID, tfFecha, tfEdadGestacional, tfPeso, tfComentario;
    static JButton btnBack, btnRealizarRegistro;

    public FrmCrearConsulta() {
        super();
        this.setTitle("Registrar paciente");
        this.setVisible(false);
        agregarComponentes();
    }

    public void agregarComponentes() {
        agregarLabels();
        agregarBotones();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)) {
            tfID.setText("");
            tfComentario.setText("");
            tfPeso.setText("");
            tfFecha.setText("");
            tfEdadGestacional.setText("");
            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnRealizarRegistro)) {
            String fecha = tfFecha.getText();
            String edadGestacionalStr = tfEdadGestacional.getText();
            String pesoStr = tfPeso.getText();
            String comentario = tfComentario.getText();
            String id = tfID.getText();

            // Verificar si algún campo está vacío
            if (fecha.isEmpty() || edadGestacionalStr.isEmpty() || pesoStr.isEmpty() || comentario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                return; // Salir del método sin realizar el registro
            }

            // Convertir la edad a entero
            int edadGestacional = Integer.parseInt(edadGestacionalStr);
            int peso = Integer.parseInt(pesoStr);

            Consulta currentRegister = new Consulta(fecha, comentario, peso, edadGestacional);
            boolean flag = true;
            for (Paciente paciente: FrmInicio.pacientes){
                if(Objects.equals(paciente.getId(), id)){
                    paciente.getListaConsultas().add(currentRegister);
                    flag = false;
                    break;
                }
            }

            if (flag){
                JOptionPane.showMessageDialog(this, "ID no coincide con ningún paciente.");
                return; // Salir del método sin realizar el registro
            }


            JOptionPane.showMessageDialog(this, "Consulta creada exitosamente");

            // Limpiar los campos después de realizar el registro
            tfFecha.setText("");
            tfPeso.setText("");
            tfEdadGestacional.setText("");
            tfComentario.setText("");


            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }

    public void agregarLabels() {

        lblTitulo = new JLabel("Ingresa los datos para crear una consulta:");
        lblTitulo.setBounds(100, 20, 1000, 20);
        lblTitulo.setFont(new Font("constantia", Font.BOLD, 18));

        txtID = new JLabel("ID del paciente:");
        txtID.setBounds(200,60,200,30);
        tfID = new JTextField();
        tfID.setBounds(200, 90, 200, 30);

        txtFecha = new JLabel("Fecha:");
        txtFecha.setBounds(20, 140, 100, 20);
        tfFecha = new JTextField();
        tfFecha.setBounds(20, 170, 200, 30);

        txtEdadGestacional = new JLabel("Edad gestacional:");
        txtEdadGestacional.setBounds(20, 220, 180, 20);
        tfEdadGestacional = new JTextField();
        tfEdadGestacional.setBounds(20, 250, 200, 30);

        txtPeso = new JLabel("Peso:");
        txtPeso.setBounds(20, 300, 100, 20);
        tfPeso = new JTextField();
        tfPeso.setBounds(20, 330, 200, 30);

        txtComentario = new JLabel("Comentarios:");
        txtComentario.setBounds(20, 380, 100, 20);
        tfComentario = new JTextField();
        tfComentario.setBounds(20, 410, 400, 30);


        add(lblTitulo);

        add(txtID);
        add(tfID);


        add(txtFecha);
        add(tfFecha);

        add(txtEdadGestacional);
        add(tfEdadGestacional);

        add(txtPeso);
        add(tfPeso);

        add(txtComentario);
        add(tfComentario);


    }

    public void agregarBotones() {
        ImageIcon imgBack = new ImageIcon("img/back2.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5, 5, 40, 20);
        btnBack.addActionListener(this);

        btnRealizarRegistro = new JButton("Realizar consulta");
        btnRealizarRegistro.setBounds(200, 490, 200, 40);
        btnRealizarRegistro.addActionListener(this);

        add(btnBack);
        add(btnRealizarRegistro);
    }
}
