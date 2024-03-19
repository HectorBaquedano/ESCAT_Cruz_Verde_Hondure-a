/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ExpedientesDao;
import Factory.ConnectionFactory;
import javafx.collections.ObservableList;
import model.Expedientes;

/**
 *
 * @author Hector Baquedano
 */
public class ExpedientesController {
    
    private final ExpedientesDao expedientesDao;
    
    public ExpedientesController(){
    
        var factory = new ConnectionFactory();
        this.expedientesDao = new ExpedientesDao(factory.recuperaConexion());
    }
    
    public void guardar(Expedientes expedientes){
        this.expedientesDao.guardar(expedientes);
    }
    
    public int modificar(int id, String nombre, int idAsignacion, String certificado){
        return expedientesDao.modificar(id, nombre, idAsignacion, certificado);
    }
    
    public int eliminar(Integer id){
        return expedientesDao.eliminar(id);
    }
    
    public ObservableList<Expedientes> listar(){
        return expedientesDao.listar();
    }
    
    public boolean verificar(String nombre, int idAsignacion){
        return expedientesDao.verificarExpediente(nombre, idAsignacion);
    }
    
    public String generarCertificado(String nombre, int curso){
        return expedientesDao.generarCertificado(nombre, curso);
    }
}
