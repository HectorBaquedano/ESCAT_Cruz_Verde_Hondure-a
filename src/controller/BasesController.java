/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BasesDao;
import Factory.ConnectionFactory;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import model.Bases;

/**
 *
 * @author Hector Baquedano
 */
public class BasesController {
    
    private BasesDao basesDao;
    
    public BasesController(){
    
        var factory = new ConnectionFactory();
        this.basesDao = new BasesDao(factory.recuperaConexion());
    }
    
    public void guardar(Bases bases){
        this.basesDao.guardar(bases);
    }
    
    public int modificar(int id, String ubicacion, String codigo){
        return basesDao.modificar(id, ubicacion, codigo);
    }
    
    public int eliminar(Integer id){
        return basesDao.eliminar(id);
    }
    
    public ObservableList<Bases> listar(){
        return basesDao.listar();
    }
    
    public ArrayList<Integer> listarBasesComboBox(){
        return basesDao.listarBasesComboBox();
    }
    public boolean verificar(String ubicacion){
        return basesDao.verificarBase(ubicacion);
    }
}
