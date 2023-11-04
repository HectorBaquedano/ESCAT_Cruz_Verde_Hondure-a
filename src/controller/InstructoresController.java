/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.InstructoresDao;
import Factory.ConnectionFactory;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import model.Instructores;

/**
 *
 * @author Hector Baquedano
 */
public class InstructoresController {
    
    private final InstructoresDao instructoresDao;
    
    public InstructoresController(){
    
        var factory = new ConnectionFactory();
        this.instructoresDao = new InstructoresDao(factory.recuperaConexion());
    }
    
    public void guardar(Instructores instructores){
        this.instructoresDao.guardar(instructores);
    }
    
    public int modificar(int id, String nombre, String dni, String email, String telefono, String sexo, String base){
        return instructoresDao.modificar(id, nombre, dni, email, telefono, sexo, base);
    }
    
    public int eliminar(int id){
        return instructoresDao.eliminar(id);
    }
    
    public ObservableList<Instructores> listar(){
        return instructoresDao.listar();
    }
    
    public ArrayList<String> listarInstructoresComboBox(){
        return instructoresDao.listarInstructoresComboBox();
    }
    
    public boolean verificar(String nombre, String dni){
        return instructoresDao.verificarInstructor(nombre, dni);
    }
}
