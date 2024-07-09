import MallaInteractiva.Asignatura;
import MallaInteractiva.MallaInteractiva;
import MallaInteractiva.Semestre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //malla
        MallaInteractiva miMalla = new MallaInteractiva("Ingeniería de Ejecución en Computación e Informática");
        miMalla.obtenerDatosByTXT("asignaturas.txt","requisitosAsignaturas.txt");

        Scanner inTeclado = new Scanner(System.in);
        String nombreAsignatura;
        int opcionPrincipal, eleccion1, idAsignatura;
        do {
            printMenuPrincipal();
            opcionPrincipal = inTeclado.nextInt();
            switch(opcionPrincipal){
                case 1:
                    miMalla.imprimirMallaCurricularNormal();
                    break;
                case 2:
                    do {
                        miMalla.actualizarEstadoTodasLasAsignaturas();
                        miMalla.imprimirMallaCurricularNormal();
                        System.out.println("Ingrese la Id de la asignatura aprobada:      (en caso de querer salir ingrese un entero negativo)");
                        idAsignatura = inTeclado.nextInt();
                        if(idAsignatura >= 0 && miMalla.existeAsignaturaById(idAsignatura)){ // condicion para verificar
                            miMalla.getAsignaturaById(idAsignatura).aprobarAsignatura(); //cambiar estado de asignatura a aprobado si es que esta disponible
                        }else{
                            System.out.println("No existe asignatura con la id: "+idAsignatura+". Vuelve a intentarlo");
                        }
                    } while (idAsignatura >= 0);
                    miMalla.setAllAsignaturasBloquedas();
                    break;
                case 3:
                    System.out.println("Desea buscar asignatura por nombre o por id: (1: Nombre, 2: Id)");
                    eleccion1 = inTeclado.nextInt();
                    if(eleccion1 == 1){
                        System.out.println("Ingrese el nombre de la asignatura");
                        inTeclado.nextLine();
                        nombreAsignatura = inTeclado.nextLine();
                        if(miMalla.existeAsignaturaByNombre(nombreAsignatura)) {
                            Asignatura auxAsig = miMalla.getAsignaturaByNombre(nombreAsignatura);
                            System.out.println("Datos asignatura:\n\tNombre: " + auxAsig.getNombre() + ",  Id: " + auxAsig.getId() + ",  Nivel: " + auxAsig.getNivel() + "\n\tRequisitos: ");
                            for (Asignatura as : auxAsig.getAsignaturasRequisitos()) {
                                System.out.println("\t\tNombre: " + as.getNombre() + ",  Id: " + as.getId());
                            }
                        }else{
                            System.out.println("No existe asignatura con nombre: "+nombreAsignatura+". Lo sentimos");
                        }

                    }else if(eleccion1 == 2){
                        System.out.println("Ingrese la id de la asignatura");
                        idAsignatura = inTeclado.nextInt();
                        if(miMalla.existeAsignaturaById(idAsignatura)){
                            Asignatura auxAsig = miMalla.getAsignaturaById(idAsignatura);
                            System.out.println("Datos asignatura:\n\tNombre: "+auxAsig.getNombre()+",  Id: "+auxAsig.getId()+",  Nivel: "+auxAsig.getNivel()+"\n\tRequisitos: ");
                            for(Asignatura as : auxAsig.getAsignaturasRequisitos()){
                                System.out.println("\t\tNombre: "+as.getNombre()+",  Id: "+as.getId());
                            }
                        }else{
                            System.out.println("No existe asignatura con la id: "+idAsignatura+". Lo sentimos");
                        }

                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    break;

            }
        }while(opcionPrincipal != 4);


    }




    private static void printMenuPrincipal() {
        System.out.println("\n\n### Malla Curricular Interactiva ###");
        System.out.println("Opciones\n");
        System.out.println("\t1.  Ver malla curricular");
        System.out.println("\t2.  Simular estado malla curricular");
        System.out.println("\t3.  Solicitar información sobre asignatura");
        System.out.println("\t4.  Salir");
        System.out.println("\nIngresa una opcion y presiona Enter: ");
    }

}



