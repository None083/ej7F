/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7f;

import java.time.LocalDate;

/**
 *
 * @author FX506
 */
public class Profesor {
    
    private String empleado; 
    private String dniPasaporte; 
    private String puesto; 
    private LocalDate fechaEntrada; 
    private LocalDate fechaSalida; 
    private String telefono; 
    private Boolean evaluador; 
    private boolean coordinador;

    public Profesor() {
    }

    public Profesor(String empleado, String dniPasaporte, String puesto, LocalDate fechaEntrada, LocalDate fechaSalida, String telefono, Boolean evaluador, boolean coordinador) {
        this.empleado = empleado;
        this.dniPasaporte = dniPasaporte;
        this.puesto = puesto;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.telefono = telefono;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public Profesor(String empleado, String dniPasaporte, String puesto, LocalDate fechaEntrada, String telefono, Boolean evaluador, boolean coordinador) {
        this.empleado = empleado;
        this.dniPasaporte = dniPasaporte;
        this.puesto = puesto;
        this.fechaEntrada = fechaEntrada;
        this.telefono = telefono;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getDniPasaporte() {
        return dniPasaporte;
    }

    public void setDniPasaporte(String dniPasaporte) {
        this.dniPasaporte = dniPasaporte;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Boolean evaluador) {
        this.evaluador = evaluador;
    }

    @Override
    public String toString() {
        return "Profesor{" + "empleado=" + empleado + ", dniPasaporte=" + dniPasaporte + ", puesto=" + puesto + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", telefono=" + telefono + ", evaluador=" + evaluador + ", coordinador=" + coordinador + '}';
    }
    
    
    
}
