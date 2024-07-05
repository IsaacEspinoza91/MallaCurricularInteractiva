import MallaInteractiva.Asignatura;
import MallaInteractiva.MallaInteractiva;
import MallaInteractiva.Semestre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


/*


        //Asignatuas requisitos y proximos
        //Las asignaturas de nivel 1 no tiene requisitos
        //Nivel 2
        calculo2.addAsignaturaRequisito(calculo1);
        algebra2.addAsignaturaRequisito(algebra1);
        fisica2.addAsignaturaRequisito(fisica1);
        fundamentosProgramacion.addAsignaturaRequisito(algebra1);
        introIngenieriaInformatica.addAsignaturaRequisito(introduccionIngenieria);
        //Nivel 3
        estadistica.addAsignaturaRequisito(calculo2);
        edo.addAsignaturaRequisito(calculo2);
        edo.addAsignaturaRequisito(fundamentosProgramacion);
        electro.addAsignaturaRequisito(calculo2);
        electro.addAsignaturaRequisito(fisica2);
        comunicacionEfectiva.addAsignaturaRequisito(tallerDesarrolloPersonal);
        ingles1.addAsignaturaRequisito(metodosDeEstudio);
        metodos.addAsignaturaRequisito(fundamentosProgramacion);
        metodos.addAsignaturaRequisito(introIngenieriaInformatica);
        //nivel 4
        fundeco.addAsignaturaRequisito(calculo1);
        ingles2.addAsignaturaRequisito(ingles1);
        paradigmas.addAsignaturaRequisito(metodos);
        eda.addAsignaturaRequisito(metodos);
        ingesis.addAsignaturaRequisito(estadistica);
        ingesis.addAsignaturaRequisito(quimica);
        ingesis.addAsignaturaRequisito(introduccionIngenieria);
        //nivel 5
        ingles3.addAsignaturaRequisito(ingles2);
        fundamentosIngenieriaSoftware.addAsignaturaRequisito(paradigmas);
        inso.addAsignaturaRequisito(comunicacionEfectiva);
        sia.addAsignaturaRequisito(ingesis);
        disenoBaseDatos.addAsignaturaRequisito(paradigmas);
        organizacionComputadores.addAsignaturaRequisito(edeco);
        evalucionProyectosInformaticos.addAsignaturaRequisito(fundeco);
        evalucionProyectosInformaticos.addAsignaturaRequisito(edo);
        //nivel 6
        administracionProyeInfor.addAsignaturaRequisito(evalucionProyectosInformaticos);
        redesComputacionales.addAsignaturaRequisito(organizacionComputadores);
        tecnicasIngeSoftware.addAsignaturaRequisito(fundamentosIngenieriaSoftware);
        tallerBaseDatos.addAsignaturaRequisito(fundamentosIngenieriaSoftware);
        tallerBaseDatos.addAsignaturaRequisito(disenoBaseDatos);
        sistemasOperativos.addAsignaturaRequisito(organizacionComputadores);
        sistemasOperativos.addAsignaturaRequisito(eda);
        //nivel 7
        proyectosIngenieriaSoftware.addAsignaturaRequisito(tallerBaseDatos);
        proyectosIngenieriaSoftware.addAsignaturaRequisito(tecnicasIngeSoftware);
        proyectosIngenieriaSoftware.addAsignaturaRequisito(administracionProyeInfor);
        topico1.addAsignaturaRequisito(tecnicasIngeSoftware);
        topico1.addAsignaturaRequisito(redesComputacionales);
        topico2.addAsignaturaRequisito(tecnicasIngeSoftware);
        topico2.addAsignaturaRequisito(redesComputacionales);
        topico3.addAsignaturaRequisito(tecnicasIngeSoftware);
        topico3.addAsignaturaRequisito(redesComputacionales);
        topico3.addAsignaturaRequisito(administracionProyeInfor);
        seminario.addAsignaturaRequisito(inso);
        seminario.addAsignaturaRequisito(sia);
        seminario.addAsignaturaRequisito(sistemasOperativos);
        seminario.addAsignaturaRequisito(tallerBaseDatos);
        tesis.addAsignaturaRequisito(seminario);




        //creacion de semestres
        Semestre s1 = new Semestre(1,6,new ArrayList<>(Arrays.asList(calculo1,algebra1,fisica1,tallerDesarrolloPersonal,introduccionIngenieria,metodosDeEstudio)));
        Semestre s2 = new Semestre(2,6,new ArrayList<>(Arrays.asList(calculo2,algebra2,fisica2,fundamentosProgramacion,quimica,introIngenieriaInformatica)));
        Semestre s3 = new Semestre(3,6,new ArrayList<>(Arrays.asList(estadistica,edo,electro,comunicacionEfectiva,ingles1,metodos)));
        Semestre s4 = new Semestre(4,6,new ArrayList<>(Arrays.asList(fundeco,ingles2,paradigmas,eda,ingesis,edeco)));
        Semestre s5 = new Semestre(5,7,new ArrayList<>(Arrays.asList(ingles3,fundamentosIngenieriaSoftware,inso,sia,disenoBaseDatos,organizacionComputadores,evalucionProyectosInformaticos)));
        Semestre s6 = new Semestre(6,6,new ArrayList<>(Arrays.asList(ingles4,sistemasOperativos,tallerBaseDatos,tecnicasIngeSoftware,redesComputacionales,administracionProyeInfor)));
        Semestre s7 = new Semestre(7,5,new ArrayList<>(Arrays.asList(proyectosIngenieriaSoftware,topico1,topico2,topico3,seminario)));
        Semestre s8 = new Semestre(8,1,new ArrayList<>(Arrays.asList(tesis)));



*/
        //malla
        MallaInteractiva miMalla = new MallaInteractiva("Ejecucion en Informatica");
        miMalla.obtenerDatosByTXT("asignaturas.txt","requisitosAsignaturas.txt");
        //miMalla.imprimirMallaCurricularNormal();

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
                        if(idAsignatura >= 0){ // condicion para verificar
                            miMalla.getAsignaturaById(idAsignatura).aprobarAsignatura(); //cambiar estado de asignatura a aprobado si es que esta disponible
                        }
                    } while (idAsignatura >= 0);
                    break;
                case 3:
                    System.out.println("Desea buscar asignatura por nombre o por id: (1: Nombre, 2: Id)");
                    eleccion1 = inTeclado.nextInt();
                    if(eleccion1 == 1){
                        System.out.println("Ingrese el nombre de la asignatura");
                        inTeclado.nextLine();
                        nombreAsignatura = inTeclado.nextLine();
                        Asignatura auxAsig = miMalla.getAsignaturaByNombre(nombreAsignatura);
                        System.out.println("Datos asignatura:\n\tNombre: "+auxAsig.getNombre()+",  Id: "+auxAsig.getId()+",  Nivel: "+auxAsig.getNivel()+"\n\tRequisitos: ");
                        for(Asignatura as : auxAsig.getAsignaturasRequisitos()){
                            System.out.println("\t\tNombre: "+as.getNombre()+",  Id: "+as.getId());
                        }
                    }else if(eleccion1 == 2){
                        System.out.println("Ingrese la id de la asignatura");
                        idAsignatura = inTeclado.nextInt();
                        Asignatura auxAsig = miMalla.getAsignaturaById(idAsignatura);
                        System.out.println("Datos asignatura:\n\tNombre: "+auxAsig.getNombre()+",  Id: "+auxAsig.getId()+",  Nivel: "+auxAsig.getNivel()+"\n\tRequisitos: ");
                        for(Asignatura as : auxAsig.getAsignaturasRequisitos()){
                            System.out.println("\t\tNombre: "+as.getNombre()+",  Id: "+as.getId());
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



