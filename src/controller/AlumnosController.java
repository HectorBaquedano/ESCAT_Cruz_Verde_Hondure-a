/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AlumnosDao;
import Factory.ConnectionFactory;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import model.Alumnos;

/**
 *
 * @author Hector Baquedano
 */
public class AlumnosController {
    
    private AlumnosDao alumnosDao;
    
    public AlumnosController(){
    
        var factory = new ConnectionFactory();
        this.alumnosDao = new AlumnosDao(factory.recuperaConexion());
    }
    
    public void guardar(Alumnos alumnos){
        this.alumnosDao.guardar(alumnos);
    }
    
    public int modificar(int id, String nombre, String dni, String email, String telefono, String direccion, String sexo){
        return alumnosDao.modificar(id, nombre, dni, email, telefono, direccion, sexo);
    }
    
    public int eliminar(Integer id){
        return alumnosDao.eliminar(id);
    }
    
    public ObservableList<Alumnos> listar(){
        return alumnosDao.listar();
    }

    public ArrayList<String> listarAlumnosComboBox(){
        return alumnosDao.listarAlumnosComboBox();
    }
    
    public boolean verificar(String nombre, String dni){
        return alumnosDao.verificarAlumno(nombre, dni);
    }
    
    public int ContarAlumnosCapacitados(){
        return alumnosDao.ContarAlumnosCapacitados();
    }
    
    public int ContarMujeresCapacitadas(){
        return alumnosDao.ContarMujeresCapacitadas();
    }
    
    public int ContarHombresCapacitados(){
        return alumnosDao.ContarHombresCapacitadas();
    }
}
