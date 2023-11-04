/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hector Baquedano
 */
public class Expedientes {
    
    private int id;
    
    private String alumno;
    
    private String fechaInicio;
    
    private String certificado;

    public Expedientes(int id, String alumno, String fechaInicio, String certificado) {
        this.id = id;
        this.alumno = alumno;
        this.fechaInicio = fechaInicio;
        this.certificado = certificado;
    }

    public Expedientes(String alumno, String fechaInicio, String certificado) {
        this.alumno = alumno;
        this.fechaInicio = fechaInicio;
        this.certificado = certificado;
    }

    public int getId() {
        return id;
    }

    public String getAlumno() {
        return alumno;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }   
    
}
