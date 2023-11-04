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
    
    private Integer id;
    private String nombre;
    private String dni;
    private String email;
    private String telefono;    
    private String sexo;
    private String base;
    
    public Instructores(String nombre, String dni, String email, String telefono, String sexo, String base) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.base = base;
    }
    
    public Instructores(Integer id, String nombre, String dni, String email, String telefono, String sexo, String base) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.sexo = sexo;
        this.base = base;
    }
    
    public Instructores(){
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
    
    public void setBase(String base) {
        this.base = base;
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

    public String getBase() {
        return base;
         
    }    

    
}
