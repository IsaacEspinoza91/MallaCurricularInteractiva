package MallaInteractiva;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {

    //Atributos
    private int id;
    private String nombre;
    private int nivel;
    private List<Asignatura> asignaturasRequisitos = new ArrayList<>();



    public Asignatura(int id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }



    //metodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Asignatura> getAsignaturasRequisitos() {
        return asignaturasRequisitos;
    }

    public void setAsignaturasRequisitos(List<Asignatura> asignaturasRequisitos) {
        this.asignaturasRequisitos = asignaturasRequisitos;
    }



    public void addAsignaturaRequisito(Asignatura asignaturaRequisito) {
        this.asignaturasRequisitos.add(asignaturaRequisito);
    }





    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asignatura: ").append(nombre).append(" (ID: ").append(id).append("), Previas: ");
        if (asignaturasRequisitos.isEmpty()) {
            sb.append("Ninguna");
        } else {
            for (Asignatura previa : asignaturasRequisitos) {
                sb.append(previa.nombre).append(" ");
            }
        }
        return sb.toString().trim();
    }

     */

}
