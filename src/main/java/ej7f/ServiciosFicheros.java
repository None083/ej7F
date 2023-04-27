/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7f;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FX506
 */
public class ServiciosFicheros {
    
    public static void lecturaFactura(String id, List<Profesor> lista) {
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "ISO-8859-1")) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split("'|,");
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
                if(tokens[7].equalsIgnoreCase("Sí")){
                    tokens[7]="true";
                }
                if(tokens[8].equalsIgnoreCase("Sí")){
                    tokens[8]="true";
                }
                if(tokens[5].equals("")){
                    lista.add(new Profesor(tokens[0] + tokens[1], tokens[2], tokens[3], 
                        LocalDate.parse(tokens[4], formatters), 
                        tokens[6], Boolean.valueOf(tokens[7]), Boolean.valueOf(tokens[8])));
                } else{
                    lista.add(new Profesor(tokens[0] + tokens[1], tokens[2], tokens[3], 
                        LocalDate.parse(tokens[4], formatters), LocalDate.parse(tokens[5], formatters), 
                        tokens[6], Boolean.valueOf(tokens[7]), Boolean.valueOf(tokens[8])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void ecribirProfesorJason(String id, List<Profesor> lista) throws IOException{
        
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File(id), lista);
        
    }
    
}
