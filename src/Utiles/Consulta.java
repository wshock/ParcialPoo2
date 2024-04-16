package Utiles;

public class Consulta {
    private String fecha, comentarios;
    private int peso, edadGestacional;

    public Consulta(String fecha, String comentarios, int peso, int edadGestacional){
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.peso = peso;
        this.edadGestacional = edadGestacional;
    }


    public String getFecha() {
        return fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getPeso() {
        return peso;
    }

    public int getEdadGestacional() {
        return edadGestacional;
    }

    public Object[] getInformacionConsulta(){
        return new Object[]{this.getFecha(), this.getEdadGestacional(), this.getPeso(), this.getComentarios()};
    }
}
