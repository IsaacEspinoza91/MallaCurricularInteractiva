import MallaInteractiva.Asignatura;
import MallaInteractiva.MallaInteractiva;
import MallaInteractiva.Semestre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        //Definicion de asignaturas
        Asignatura calculo1 = new Asignatura(0,"Calculo 1",1);
        Asignatura algebra1 = new Asignatura(1,"Algebra 1",1);
        Asignatura fisica1 = new Asignatura(2,"Fisica 1",1);
        Asignatura tallerDesarrolloPersonal = new Asignatura(3,"Taller Desarrollo Personal",1);
        Asignatura introduccionIngenieria = new Asignatura(4,"Introduccion a la Ingenieria",1);
        Asignatura metodosDeEstudio = new Asignatura(5,"Metodos de Estudio",1);
        Asignatura calculo2 = new Asignatura(6,"Calculo 2",2);
        Asignatura algebra2 = new Asignatura(7,"Algebra 2",2);
        Asignatura fisica2 = new Asignatura(8,"Fisica 2",2);
        Asignatura fundamentosProgramacion = new Asignatura(9,"Fundametos de computación y programación",2);
        Asignatura quimica = new Asignatura(10,"Quimica General", 2);
        Asignatura introIngenieriaInformatica = new Asignatura(11,"Introudcción a la ingenería informatica", 2);
        Asignatura electro = new Asignatura(12,"Electricidad y magnetismo",3);
        Asignatura comunicacionEfectiva = new Asignatura(13,"Comunicacion Efectiva",3);
        Asignatura ingles1 = new Asignatura(14,"Ingles 1",3);
        Asignatura edo = new Asignatura(15,"Ecuaciones diferenciales",3);
        Asignatura metodos = new Asignatura(16,"Metodos de programacion",3);
        Asignatura estadistica = new Asignatura(17,"Analisis Estadistico",3);
        Asignatura ingesis = new Asignatura(18,"Ingenieria de sistemas",4);
        Asignatura fundeco = new Asignatura(19,"Fundametos de economia",4);
        Asignatura edeco  = new Asignatura(20,"Estructura de computadores",4);
        Asignatura paradigmas = new Asignatura(21,"Paradigmas de programacion",4);
        Asignatura eda = new Asignatura(22,"Analisis de Algoritmos y estructuras de datos",4);
        Asignatura ingles2 = new Asignatura(23,"Ingles 2",4);
        Asignatura evalucionProyectosInformaticos = new Asignatura(24,"Evalucion proyectos informaticos",5);
        Asignatura sia = new Asignatura(25,"Sistemas de informacion",5);
        Asignatura inso = new Asignatura(26,"Informatica y sociedad",5);
        Asignatura fundamentosIngenieriaSoftware = new Asignatura(27,"Fundamentos de ingenieria de software",5);
        Asignatura ingles3 = new Asignatura(28,"Ingles 3",5);
        Asignatura disenoBaseDatos = new Asignatura(29,"Diseno Base Datos",5);
        Asignatura organizacionComputadores = new Asignatura(30,"Organizacion de computadores",5);
        Asignatura tallerBaseDatos = new Asignatura(31,"Taller de Base Datos",6);
        Asignatura administracionProyeInfor = new Asignatura(32,"Administracion proyectos informaticos",6);
        Asignatura sistemasOperativos = new Asignatura(33,"Sistemas Operativos",6);
        Asignatura tecnicasIngeSoftware = new Asignatura(34,"Tecnicas Ingenieria de Software",6);
        Asignatura ingles4 = new Asignatura(35,"Ingles 4",6);
        Asignatura redesComputacionales = new Asignatura(36,"Redes Computacionales",6);
        Asignatura proyectosIngenieriaSoftware = new Asignatura(37,"Proyectos Ingenieria de Software",7);
        Asignatura topico1 = new Asignatura(38,"Topico 1",7);
        Asignatura topico2 = new Asignatura(39,"Topico 2",7);
        Asignatura topico3 = new Asignatura(40,"Topico 3",7);
        Asignatura seminario = new Asignatura(41,"Seminario",7);
        Asignatura tesis = new Asignatura(42,"Tesis",7);



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




        //malla
        MallaInteractiva miMalla = new MallaInteractiva("Ejecucion en Informatica",8,new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8)));

        miMalla.imprimirMallaCurricular();



    }
}



