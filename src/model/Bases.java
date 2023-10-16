/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hector Baquedano
 */
public class Bases {
        
    private int id;
    private String ubicacion;
    private String codigo;
    
    public Bases(String ubicacion, String codigo) {
        this.ubicacion = ubicacion;
        this.codigo = codigo;
    }

    public Bases(int id, String ubicacion, String codigo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
    }
        
    public void setId(int id) {
        this.id = id;
    }

    public void setUbicacionBase(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCodigoBase(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

}
