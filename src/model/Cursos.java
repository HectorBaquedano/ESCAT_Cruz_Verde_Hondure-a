/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hector Baquedano
 */
public class Cursos {

        
    private int id;
    private String nombre;
        
    public Cursos(String nombre) {
        this.nombre = nombre;        
    }
    
    public Cursos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
