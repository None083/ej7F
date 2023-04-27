/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ej7f;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author FX506
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        List<Profesor> listaProfesores = new ArrayList<>();
        
        ServiciosFicheros.lecturaFactura("RelPerCen.csv", listaProfesores);
        
        for (Profesor p : listaProfesores) {
            System.out.println(p);
        }
        
        List<Profesor> listaProfesores2 = new ArrayList<>();
        
        for (Profesor p : listaProfesores) {
            if(p.getFechaEntrada().plusYears(10).isBefore(LocalDate.now()) && 
                    p.getFechaEntrada().plusYears(15).isAfter(LocalDate.now())){
                listaProfesores2.add(p);
            }
        }
        
        ServiciosFicheros.ecribirProfesorJason("profesores.json", listaProfesores2);
        
        System.out.println("-----------------------");
        
        for (Profesor p : listaProfesores2) {
            System.out.println(p);
        }
        
        System.out.println("-----------------------");
        
        int contador = 0;
        
        for (Profesor p : listaProfesores) {
            if(p.getPuesto().equalsIgnoreCase("Tecnología P.E.S.")){
                contador++;
            }
        }
        
        System.out.println("Profesores de tecnología: " + contador);
        
        boolean inforCoordinador = false;
        
        for (Profesor p : listaProfesores) {
            if(p.getPuesto().equalsIgnoreCase("Informática P.E.S.") && p.isCoordinador()){
                inforCoordinador=true;
            }
        }
        System.out.println("Resultado de la búsqueda de profesor de Informática coordinador: " + inforCoordinador);
        
        List<String> listaProfesoresApeJ = new ArrayList<>();
        
        for (Profesor p : listaProfesores) {
            if(p.getDniPasaporte().contains("J")){
                String[] tokens = p.getEmpleado().split(" ");
                listaProfesoresApeJ.add(tokens[0]+ " " + tokens[1]);
            }
        }
        
        Comparator<String> criterioApellido = (p1,p2)-> p1.compareToIgnoreCase(p2);
        
        Collections.sort(listaProfesoresApeJ, criterioApellido);
        
        listaProfesoresApeJ.forEach(s->System.out.println(s));
        
        boolean john = false;
        
        for (Profesor p : listaProfesores) {
            String[] tokens = p.getEmpleado().split(" ");
            if(tokens[2].equalsIgnoreCase("John")){
                john = true;
            }
        }
        System.out.println("Resultado de la búsqueda de John: " + john);
        
        System.out.println(listaProfesores.stream()
                .filter(p->p.getPuesto().equalsIgnoreCase("Tecnología P.E.S."))
                .count());
        
        System.out.println(listaProfesores.stream()
                .anyMatch(p->p.getPuesto().equalsIgnoreCase("Informática P.E.S.") && p.isCoordinador()));
        
        listaProfesores.stream()
                .filter(p->p.getDniPasaporte().contains("J"))
                .map(p->p.getEmpleado())
                .sorted(criterioApellido)
                .forEach(System.out::println);
        
        System.out.println(listaProfesores.stream().anyMatch(p->p.getEmpleado().contains("John")));
        
        
    }
}
