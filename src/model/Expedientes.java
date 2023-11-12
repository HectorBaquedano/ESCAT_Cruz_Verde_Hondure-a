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
    
    private String nombre;
    
    private int idAsignacion;
    
    private String certificado;

    public Expedientes(int id, String nombre, int idAsignacion, String certificado) {
        this.id = id;
        this.nombre = nombre;
        this.idAsignacion = idAsignacion;
        this.certificado = certificado;
    }

    public Expedientes(String nombre, int idAsignacion, String certificado) {
        this.nombre = nombre;
        this.idAsignacion = idAsignacion;
        this.certificado = certificado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }   
    
}
