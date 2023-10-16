/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CursosDao;
import Factory.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import model.Cursos;

/**
 *
 * @author Hector Baquedano
 */
public class CursosController {
    
    private CursosDao cursosDao;
    
    public CursosController(){
    
        var factory = new ConnectionFactory();
        this.cursosDao = new CursosDao(factory.recuperaConexion());
    }
    
    public void guardar(Cursos cursos){
        this.cursosDao.guardar(cursos);
    }
    
    public int modificar(int id, String nombre){
        return cursosDao.modificar(id, nombre);
    }
    
    public int eliminar(Integer id){
        return cursosDao.eliminar(id);
    }
    
    public ObservableList<Cursos> listar(){
        return cursosDao.listar();
    }
    
    public ArrayList<String> listarCursoComboBox(){
        return cursosDao.listarCursoComboBox();
    }
    
    public boolean verificar(String nombre){
        return cursosDao.verificarCurso(nombre);
    }

}
