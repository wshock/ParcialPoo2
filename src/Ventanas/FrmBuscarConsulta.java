package Ventanas;

import Utiles.Paciente;
import Utiles.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class FrmBuscarConsulta extends Ventana{

    public static void main(String[] args) {
        FrmBuscarConsulta consultaaa = new FrmBuscarConsulta();
        consultaaa.setVisible(true);
    }
    static JButton btnBack;
    static JLabel lblTitulo, lblID, lblRespuesta;
    static JTextField txtID;
    static JButton btnEnviarID;

    // Vetanas


    // Tabla
    static DefaultTableModel model;
    static JTable tabla;
    static JScrollPane scrollpane;
    static Boolean ponerTabla;


    public FrmBuscarConsulta() {
        super();
        setTitle("Busqueda de consultas");
        this.setVisible(false);
        agregarComponentes();
    }

    private void agregarComponentes(){
        colocarBotones();
        colocarLabels();
        colocarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            // Reiniciar los campos
            txtID.setText("");
            lblRespuesta.setText("");
            model.setRowCount(0);

            // Volver a la ventana principal
            FrmLogin.ventanaPrincipal.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource().equals(btnEnviarID)){
            String ingresadoID = txtID.getText();

            for (Paciente paciente: FrmInicio.pacientes){
                if (Objects.equals(ingresadoID, paciente.getId())){
                    lblRespuesta.setText("La gestante " + ingresadoID + " tiene las siguientes consultas: ");
                    actualizarTabla(paciente);
                    break;
                }
                else if (ingresadoID.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No ingresaste ningún ID");
                    return; // Salir del método sin realizar el registro
                }
                else {
                    JOptionPane.showMessageDialog(this, "No se encuentra una gestante con ese ID");
                    model.setRowCount(0);
                }
            }
        }

    }




    private void colocarBotones(){
        ImageIcon imgBack = new ImageIcon("img/back2.png");
        btnBack = new JButton(imgBack);
        btnBack.setBounds(5,5,40,20);
        btnBack.addActionListener(this);
        btnEnviarID = new JButton("Buscar");
        btnEnviarID.setBounds(250, 160, 100,25);
        btnEnviarID.addActionListener(this);



        add(btnBack);
        add(btnEnviarID);
    }


    private void colocarLabels(){
        lblTitulo = new JLabel("Busca una consulta por documento", SwingConstants.CENTER);
        lblTitulo.setBounds(0,30,600,40);
        lblTitulo.setFont(new Font("constantia",Font.BOLD,27));

        lblID = new JLabel("Ingresa el documento de la gestante:", SwingConstants.CENTER);
        lblID.setBounds(150,90,300,20);

        txtID = new JTextField();
        txtID.setBounds(200, 115, 200, 30);


        lblRespuesta = new JLabel("", SwingConstants.CENTER);
        lblRespuesta.setBounds(0,230, 600, 50);
        lblRespuesta.setFont(new Font("constantia", Font.ITALIC, 20));


        add(lblTitulo);
        add(lblID);
        add(txtID);
        add(lblRespuesta);

    }

    private void colocarTabla(){
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("Fecha");
        model.addColumn("Edad gestacional");
        model.addColumn("Peso");
        model.addColumn("Comentario");


        scrollpane = new JScrollPane(tabla);
        scrollpane.setLocation(40,300);
        scrollpane.setSize(500,100);
        add(scrollpane, BorderLayout.CENTER);

    }
    private void actualizarTabla(Paciente paciente){
        model.setRowCount(0);
        for (Consulta consulta: paciente.getListaConsultas()){
            model.addRow(consulta.getInformacionConsulta());
        }
    }


}
