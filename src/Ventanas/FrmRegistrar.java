package Ventanas;

import Utiles.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmRegistrar extends Ventana implements ActionListener {

    static JLabel lblTitulo, txtNombres, txtApellidos, txtId, txtEdad, txtTipoSangre;
    static JTextField tfNombres, tfApellidos, tfId, tfEdad, tfTipoSangre;
    static JButton btnBack, btnRealizarRegistro;

    public FrmRegistrar() {
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
            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnRealizarRegistro)) {
            String nombres = tfNombres.getText();
            String apellidos = tfApellidos.getText();
            String id = tfId.getText();
            String edadStr = tfEdad.getText();
            String tipoSangre = tfTipoSangre.getText();

            // Verificar si algún campo está vacío
            if (nombres.isEmpty() || apellidos.isEmpty() || id.isEmpty() || edadStr.isEmpty() || tipoSangre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                return; // Salir del método sin realizar el registro
            }

            // Convertir la edad a entero
            int edad = Integer.parseInt(edadStr);

            // Realizar el registro del paciente
            Paciente currentRegister = new Paciente(nombres, apellidos, id, edad, tipoSangre);
            FrmInicio.pacientes.add(currentRegister);
            FrmListar.actualizarTabla();


            JOptionPane.showMessageDialog(this, "Gestante registrada exitosamente");

            // Limpiar los campos después de realizar el registro
            tfNombres.setText("");
            tfId.setText("");
            tfApellidos.setText("");
            tfEdad.setText("");
            tfTipoSangre.setText("");


            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }

    public void agregarLabels() {

        lblTitulo = new JLabel("Ingresa los datos del carne perinatal del paciente:");
        lblTitulo.setBounds(100, 20, 1000, 20);
        lblTitulo.setFont(new Font("constantia", Font.BOLD, 18));

        txtNombres = new JLabel("Nombres:");
        txtNombres.setBounds(20, 60, 100, 20);
        tfNombres = new JTextField();
        tfNombres.setBounds(20, 90, 200, 30);

        txtApellidos = new JLabel("Apellidos:");
        txtApellidos.setBounds(20, 140, 100, 20);
        tfApellidos = new JTextField();
        tfApellidos.setBounds(20, 170, 200, 30);

        txtId = new JLabel("Documento:");
        txtId.setBounds(20, 220, 100, 20);
        tfId = new JTextField();
        tfId.setBounds(20, 250, 200, 30);

        txtEdad = new JLabel("Edad:");
        txtEdad.setBounds(20, 300, 100, 20);
        tfEdad = new JTextField();
        tfEdad.setBounds(20, 330, 200, 30);

        txtTipoSangre = new JLabel("Tipo de sangre:");
        txtTipoSangre.setBounds(20, 380, 100, 20);
        tfTipoSangre = new JTextField();
        tfTipoSangre.setBounds(20, 410, 200, 30);

        add(lblTitulo);

        add(txtNombres);
        add(tfNombres);

        add(txtApellidos);
        add(tfApellidos);

        add(txtId);
        add(tfId);

        add(txtEdad);
        add(tfEdad);

        add(txtTipoSangre);
        add(tfTipoSangre);

    }

    public void agregarBotones() {
        ImageIcon imgBack = new ImageIcon("img/back.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5, 5, 40, 20);
        btnBack.addActionListener(this);

        btnRealizarRegistro = new JButton("Realizar registro");
        btnRealizarRegistro.setBounds(350, 250, 200, 40);
        btnRealizarRegistro.addActionListener(this);

        add(btnBack);
        add(btnRealizarRegistro);
    }
}
