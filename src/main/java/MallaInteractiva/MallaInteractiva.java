package MallaInteractiva;

import java.util.List;

public class MallaInteractiva {

    //Atributos
    private String nombreCarrera;
    private int cantidadSemestres;
    private List<Semestre> semestres;


    public MallaInteractiva(String nombreCarrera, int cantidadSemestres, List<Semestre> semestres) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadSemestres = cantidadSemestres;
        this.semestres = semestres;
    }


    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getCantidadSemestres() {
        return cantidadSemestres;
    }

    public void setCantidadSemestres(int cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }




    public void actulizarEstadoTodasLasAsignaturas(){
        for (Semestre semestre : semestres) {
            for (Asignatura asignatura : semestre.getAsignaturas()) {
                asignatura.actualizarEstadoSegunRequisitos();
            }
        }
    }


    public void printMalla(){
        System.out.println("Nombre Carrera: " + nombreCarrera);
        System.out.println("Cantidad de Semestres: " + cantidadSemestres);
        for (Semestre semestre : semestres) {
            System.out.println(semestre.getAsignaturas().get(0).getNombre());
        }
    }



/*
    public void imprimirMallaCurricular() {
        System.out.println("Malla Curricular de la carrera: " + nombreCarrera);
        for (Semestre semestre : semestres) {
            System.out.println("Nivel " + semestre.getNivel());
            System.out.println("-------------------------------------");
            for (Asignatura asignatura : semestre.getAsignaturas()) {
                System.out.println(asignatura.getId() + " - " + asignatura.getNombre());
            }
            System.out.println();
        }
    }
*/


    public void imprimirMallaCurricularNormal() {
        int maxAsignaturas = 0;
        for (Semestre semestre : semestres) {
            maxAsignaturas = Math.max(maxAsignaturas, semestre.getAsignaturas().size());
        }

        System.out.println("Malla Curricular de la carrera: " + nombreCarrera);
        for (Semestre semestre : semestres) {
            System.out.println("\n\tNivel " + semestre.getNivel());
            for(Asignatura ramo : semestre.getAsignaturas()) {
                System.out.println("\t" + ramo.toStringWithColor());
            }
        }


    }


    public void imprimirMallaCurricular() {
        int maxAsignaturas = 0;
        for (Semestre semestre : semestres) {
            maxAsignaturas = Math.max(maxAsignaturas, semestre.getAsignaturas().size());
        }

        System.out.println("Malla Curricular de la carrera: " + nombreCarrera);
        System.out.print("Nivel ");
        for (Semestre semestre : semestres) {
            System.out.print("\tNivel " + semestre.getNivel());
        }
        System.out.println();

        for (int i = 0; i < maxAsignaturas; i++) {
            System.out.print("      ");
            for (Semestre semestre : semestres) {
                if (i < semestre.getAsignaturas().size()) {
                    Asignatura asignatura = semestre.getAsignaturas().get(i);
                    System.out.print("\t" + asignatura.getId() + " - " + asignatura.getNombre());
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

}


