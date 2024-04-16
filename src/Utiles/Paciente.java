package Utiles;

import java.util.ArrayList;

public class Paciente {
    private String nombres, apellidos, id, tipoSangre;
    private int edad;
    ArrayList<Consulta> listaConsultas = new ArrayList<>();

    public Paciente(String nombres, String apellidos, String id, int edad, String tipoSangre) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.edad = edad;
        this.tipoSangre = tipoSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<Consulta> getListaConsultas(){
        return listaConsultas;
    }

    public Object[] getInformacionPaciente(){
        return new Object[]{this.getNombres(), this.getApellidos(), this.getEdad(), this.getId(), this.getTipoSangre()};
    }


}
