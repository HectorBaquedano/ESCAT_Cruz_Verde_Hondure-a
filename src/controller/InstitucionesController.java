/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.InstitucionesDao;
import Factory.ConnectionFactory;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import model.Instituciones;

/**
 *
 * @author Hector Baquedano
 */
public class InstitucionesController {
    
    private InstitucionesDao institucionesDao;
    
    public InstitucionesController(){
    
        var factory = new ConnectionFactory();
        this.institucionesDao = new InstitucionesDao(factory.recuperaConexion());
    }
    
    public void guardar(Instituciones instituciones){
        this.institucionesDao.guardar(instituciones);
    }
    
    public int modificar(int id, String nombre){
        return institucionesDao.modificar(id, nombre);
    }
    
    public int eliminar(Integer id){
        return institucionesDao.eliminar(id);
    }
    
    public ObservableList<Instituciones> listar(){
        return institucionesDao.listar();
    }
    
    public ArrayList<String> listarInstitucionesComboBox(){
        return institucionesDao.listarInstitucionesComboBox();
    }
    
    public boolean verificar(String nombre){
        return institucionesDao.verificarInstitucion(nombre);
    }
}
