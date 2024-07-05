package MallaInteractiva;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {

    //Atributos
    private int id;
    private String nombre;
    private int nivel;
    private List<Asignatura> asignaturasRequisitos = new ArrayList<>();
    private String estado; //Solo tiene 4 tipos->  a:Aprobada, r:Reprobada, d:Disponible, b:Bloqueda



    public Asignatura(int id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado = "b";
    }

    public Asignatura(int id, String nombre, int nivel, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public void addAsignaturaRequisito(Asignatura asignaturaRequisito) {
        this.asignaturasRequisitos.add(asignaturaRequisito);
    }

    public void actualizarEstadoSegunRequisitos() {
        boolean allRequisitosAprobados = true;
        for(Asignatura asig : this.asignaturasRequisitos) {
            if(asig.getEstado().equals("b") || asig.getEstado().equals("d") || asig.getEstado().equals("r")) {
                allRequisitosAprobados = false;
            }
        }
        if (allRequisitosAprobados && !this.estado.equals("a") && !this.estado.equals("r")){
            this.estado = "d";
        }
    }




    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }

    public String toStringWithColor(){
        if(estado.equals("d")){
            return "\033[0;33m"+nombre+"\033[0m";//Amarillo disponible
        }else if(estado.equals("b")){
            return nombre;//Sin color es bloqueada
        }else if(estado.equals("a")){
            return "\033[0;32m"+nombre+"\033[0m";//Verde aprobada
        }else{
            return "\033[0;31m"+nombre+"\033[0m";//Rojo reprobada
        }
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
