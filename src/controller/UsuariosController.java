/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuariosDao;
import Factory.ConnectionFactory;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuarios;

/**
 *
 * @author Hector Baquedano
 */
public class UsuariosController {
    
    private PrincipalController pController;
    private UsuariosDao usuariosDao;
    
    public UsuariosController(){
    
        var factory = new ConnectionFactory();
        this.usuariosDao = new UsuariosDao(factory.recuperaConexion());
    }
    
    public void guardar(Usuarios usuarios){
        this.usuariosDao.guardar(usuarios);
    }
    
    public int modificar(int id, String nombre, String contraseña){
        return usuariosDao.modificar(id,nombre, contraseña);
    }
    
    public int eliminar(Integer id){
        return usuariosDao.eliminar(id);
    }
    
    public ObservableList<Usuarios> listar(){
        return usuariosDao.listar();
    }

    public boolean verificar(String nombre){
        return usuariosDao.verificarUsuario(nombre);
    }
}
