package Ventanas;

import Lógica.AprobarIngreso;
import Lógica.ValidarUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class FrmLogin extends Ventana {

    public static void main(String[] args) {
        ventanaLogin = new FrmLogin();
    }


    // Labels
    static JLabel lblTitulo, lblUsuario, lblContraseña, lblErrorSaludo;

    // Botón
    static JButton btnIngresar;

    // Campo de texto
    static JTextField txtUsuario;
    static JPasswordField  txtContraseña;

    // Ventanas
    public static FrmLogin ventanaLogin;
    public static FrmInicio ventanaPrincipal;
    public static FrmBuscarConsulta buscarConsulta;

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(btnIngresar)){

            String username = txtUsuario.getText();
            String password = txtContraseña.getText();


            /* ANTES CON ARCIHVOS PLANOS:
            if (ValidarUsuarios.validarUsuario(username, password))  */
            try {
                if (AprobarIngreso.consultarAprobacion(username, password)){ // Ahora con bases de datos

                    lblUsuario.setText("");
                    lblContraseña.setText("");
                    ventanaPrincipal.setVisible(true);
                    this.setVisible(false);


                } else {
                    lblErrorSaludo.setText("Los datos ingresados no coinciden");
                }
            } catch (SQLException ex) {
                System.out.println("1");
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("2");
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                System.out.println("3");
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                System.out.println("4");
                throw new RuntimeException(ex);
            }


        }
    }

    public FrmLogin(){
        super();
        this.setTitle("Log in");
        agregarComponentes();
        setVisible(true);

        ventanaPrincipal = new FrmInicio();
    }


    public void agregarComponentes(){
        agregarLabels();
        agregarBotones();

    }


    public void agregarLabels(){
        // Crearlos

        lblTitulo = new JLabel("Log in", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,36));
        lblTitulo.setBounds(0,0,600,100);

        // Crear fuente para usuario y contraseña
        Font fuenteUsuarioContraseña = new Font("Arial", Font.ROMAN_BASELINE,20);

        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setBounds(200, 150, 300, 20);
        lblUsuario.setFont(fuenteUsuarioContraseña);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(200, 185, 200, 30);


        lblContraseña = new JLabel("Contraseña: ");
        lblContraseña.setBounds(200, 245, 300, 20);
        lblContraseña.setFont(fuenteUsuarioContraseña);
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(200, 280, 200, 30);


        lblErrorSaludo = new JLabel("", SwingConstants.CENTER);
        // Aparecerá: Los datos ingresados no coinciden
        lblErrorSaludo.setBounds(0,350, 600, 20);




        // Agregarlos
        add(lblTitulo);
        add(lblUsuario);
        add(txtUsuario);
        add(lblContraseña);
        add(txtContraseña);
        add(lblErrorSaludo);

    }


    public void agregarBotones(){
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(250,400,100,50);
        btnIngresar.addActionListener(this);

        add(btnIngresar);

    }


}