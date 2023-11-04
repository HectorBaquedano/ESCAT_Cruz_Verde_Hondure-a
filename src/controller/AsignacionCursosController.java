/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AsignacionCursosDao;
import DAO.BasesDao;
import Factory.ConnectionFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import model.AsignacionCursos;
import model.Bases;

/**
 *
 * @author Hector Baquedano
 */
public class AsignacionCursosController {
    
    private AsignacionCursosDao asignacionCursosDao;
    
    public AsignacionCursosController(){
    
        var factory = new ConnectionFactory();
        this.asignacionCursosDao = new AsignacionCursosDao(factory.recuperaConexion());
    }
    
    public void guardar(AsignacionCursos asignacionCursos){
        this.asignacionCursosDao.guardar(asignacionCursos);
    }
    
    public int modificar(int id, String curso, String instructor, String institucion, LocalDate fechaInicio, String duracion, String lugarImpartido){
        return asignacionCursosDao.modificar(id, curso, instructor, institucion, fechaInicio, duracion, lugarImpartido);
    }
    
    public int eliminar(Integer id){
        return asignacionCursosDao.eliminar(id);
    }
    
    public ObservableList<AsignacionCursos> listar(){
        return asignacionCursosDao.listar();
    }
    
    public ArrayList<String> listarAsignacionesComboBox(){
        return asignacionCursosDao.listarAsignacionesComboBox();
    }    
    public boolean verificar(String curso, String institucion, LocalDate fechaInicio){
        return asignacionCursosDao.verificarAsignacion(curso, institucion, fechaInicio);
    }
}
