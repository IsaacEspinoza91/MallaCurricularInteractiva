package MallaInteractiva;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {

    //Atributos
    private int id;
    private String nombre;
    private int nivel;
    private List<Asignatura> asignaturasRequisitos = new ArrayList<>();
    private String estado; //Solo tiene 4 tipos->  a:Aprobada, d:Disponible, b:Bloqueda



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
        if (this.asignaturasRequisitos.isEmpty() && this.estado.equals("b")) {
            //caso si asignatura no tiene requisistos esta disponible
            this.estado = "d";
        }
        boolean allRequisitosAprobados = true;
        for(Asignatura asig : this.asignaturasRequisitos) {
            if(asig.getEstado().equals("b") || asig.getEstado().equals("d")) {
                allRequisitosAprobados = false;
            }
        }
        if (allRequisitosAprobados && !this.estado.equals("a")){
            this.estado = "d";
        }
    }

    public void aprobarAsignatura(){
        if(this.estado.equals("d")){
            this.estado = "a";
            System.out.println("Asignatura aprobada");
        }else{
            System.out.println("La asignatura no esta disponible de cursar");
        }
    }



    @Override
    public String toString() {
        return nombre + " (" + id + " nivel  "+nivel+")        requisitos"+asignaturasRequisitos;
    }

    public String toStringWithColor() {
        if (estado.equals("d")) {
            return "\033[0;33m" + id + ". " + nombre + "\033[0m";//Amarillo disponible
        } else if (estado.equals("b")) {
            return id + ". " + nombre;//Sin color es bloqueada
        } else { //caso aprobada
            return "\033[0;32m" + id + ". " + nombre + "\033[0m";//Verde aprobada
        }
    }

}
