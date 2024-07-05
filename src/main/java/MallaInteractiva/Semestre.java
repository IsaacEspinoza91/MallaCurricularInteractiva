package MallaInteractiva;

import java.util.ArrayList;
import java.util.List;

public class Semestre {

    //Atributos
    private int nivel;
    private int cantidadAsignaturas;
    private List<Asignatura> asignaturas = new ArrayList<>();


    public Semestre(int nivel, int cantidadAsignaturas, List<Asignatura> asignaturas) {
        this.nivel = nivel;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.asignaturas = asignaturas;
    }
    public Semestre(int nivel){
        this.nivel = nivel;
        this.cantidadAsignaturas = 0;
    }


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Semestre: ").append(nivel).append("\n");
        for (Asignatura asignatura : asignaturas) {
            sb.append("  ").append(asignatura).append("\n");
        }
        return sb.toString();
    }

    public void addAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
        this.cantidadAsignaturas = this.asignaturas.size();
    }
}
