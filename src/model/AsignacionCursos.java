/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Hector Baquedano
 */
public class AsignacionCursos {
    
    private int id;
    private String curso;    
    private String instructor;    
    private String institucion;    
    private LocalDate fechaInicio; 
    private String duracion;
    private String lugarImpartido;

    public AsignacionCursos(int id, String curso, String instructor, String institucion, LocalDate fechaInicio, String duracion, String lugarImpartido) {
        this.id = id;
        this.curso = curso;
        this.instructor = instructor;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.lugarImpartido = lugarImpartido;
    }

    public AsignacionCursos(String curso, String instructor, String institucion, LocalDate fechaInicio, String duracion, String lugarImpartido) {
        this.curso = curso;
        this.instructor = instructor;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.lugarImpartido = lugarImpartido;
    }
    
    public AsignacionCursos() {
    }

    public int getId() {
        return id;
    }

    public String getCurso() {
        return curso;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getInstitucion() {
        return institucion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getLugarImpartido() {
        return lugarImpartido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setLugarImpartido(String lugarImpartido) {
        this.lugarImpartido = lugarImpartido;
    }
    
}
