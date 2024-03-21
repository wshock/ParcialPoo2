package Utiles;

public class Paciente {
    private String nombres, apellidos, id;
    private int edad;

    public Paciente(String nombres, String apellidos, String id, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.edad = edad;
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

    public Object[] getInformacionPaciente(){
        return new Object[]{this.getNombres(), this.getApellidos(), this.getEdad(), this.getId()};
    }
}
