/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hector Baquedano
 */
public class Instructores {
    
    private int id;
    private String nombre;
    private String dni;
    private String email;
    private String telefono;    
    private String sexo;
    private int idBase;
    
    public Instructores(String nombre, String dni, String email, String telefono, String sexo, int idBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.idBase = idBase;
    }
    
    public Instructores(int id, String nombre, String dni, String email, String telefono, String sexo, int idBase) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.idBase = idBase;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void setBase(int idBase) {
        this.idBase = idBase;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public int getBase() {
        return idBase;
    }
    
}
