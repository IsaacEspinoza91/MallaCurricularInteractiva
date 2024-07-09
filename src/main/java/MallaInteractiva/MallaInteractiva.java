package MallaInteractiva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MallaInteractiva {

    //Atributos
    private String nombreCarrera;
    private int cantidadSemestres;
    private List<Semestre> semestres = new ArrayList<Semestre>();


    public MallaInteractiva(String nombreCarrera, int cantidadSemestres, List<Semestre> semestres) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadSemestres = cantidadSemestres;
        this.semestres = semestres;
    }
    public MallaInteractiva(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
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



    public boolean existeAsignaturaByNombre(String nombre) {
        for (Semestre semestre : semestres) {
            for (Asignatura asignatura : semestre.getAsignaturas()) {
                if (asignatura.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeAsignaturaById(int id){
        for (Semestre semestre : semestres) {
            for (Asignatura asignatura : semestre.getAsignaturas()) {
                if (asignatura.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void actualizarEstadoTodasLasAsignaturas(){
        for (Semestre semestre : semestres) {
            for (Asignatura asignatura : semestre.getAsignaturas()) {
                asignatura.actualizarEstadoSegunRequisitos();
            }
        }
    }

    public void setAllAsignaturasBloquedas(){
        for (Semestre semestre : semestres) {
            for (Asignatura a : semestre.getAsignaturas()) {
                a.setEstado("b");
            }
        }
    }



    public void imprimirMallaCurricularNormal() {
        int maxAsignaturas = 0;
        for (Semestre semestre : semestres) {
            maxAsignaturas = Math.max(maxAsignaturas, semestre.getAsignaturas().size());
        }
        System.out.println("\n\n--------------------------------------------------------------------------------------");
        System.out.println("Malla Curricular de la carrera: " + nombreCarrera);
        for (Semestre semestre : semestres) {
            System.out.println("\nNivel " + semestre.getNivel());
            for(Asignatura ramo : semestre.getAsignaturas()) {
                System.out.println("\t" + ramo.toStringWithColor());
            }
        }
        System.out.println("\n--------------------------------------------------------------------------------------\n");
    }



    public void obtenerDatosByTXT(String archivoAsignaturas, String archivoRequisitosAsignaturas){
        // Lectura de asignaturas
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoAsignaturas));//leer el archivo
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                int idAsig = Integer.parseInt(parts[0]);
                String nombreAsig = parts[1];
                int nivelAsig = Integer.parseInt(parts[2]);

                Asignatura auxAsig = new Asignatura(idAsig, nombreAsig, nivelAsig);
                boolean existeSemestreDelNivel = false;

                for(Semestre semestreAct : semestres) {
                    if(semestreAct.getNivel() == nivelAsig) {
                        semestreAct.addAsignatura(auxAsig);
                        existeSemestreDelNivel = true;
                    }
                }
                if(semestres.isEmpty() || !existeSemestreDelNivel) {
                    Semestre auxSemestre = new Semestre(nivelAsig);
                    auxSemestre.addAsignatura(auxAsig);
                    semestres.add(auxSemestre);
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Lectura requisitos de asignaturas
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoRequisitosAsignaturas));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                int idAsig = Integer.parseInt(parts[0]);
                String[] idsAsignaturasRequisitos = parts[1].split("-");
                for(String idAsigRequisito : idsAsignaturasRequisitos) {
                    //encontrar Asignatura original y agregar las asignaturas requisitos
                    getAsignaturaById(idAsig).addAsignaturaRequisito(getAsignaturaById(Integer.parseInt(idAsigRequisito)));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Asignatura getAsignaturaById(int id){
        for(Semestre semestre : semestres) {
            for(Asignatura a : semestre.getAsignaturas()) {
                if(a.getId() == id) {
                    return a;
                }
            }
        }
        return null;
    }

    public Asignatura getAsignaturaByNombre(String nombre){
        for(Semestre semestre : semestres) {
            for(Asignatura a : semestre.getAsignaturas()) {
                if(a.getNombre().equals(nombre)) {
                    return a;
                }
            }
        }
        return null;
    }
}


