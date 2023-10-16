/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConnectionFactory;
import controller.PrincipalController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Usuarios;


public class UsuariosDao {

    private final Connection con;
    private Alert alerta;
    private PrincipalController pController;
    

    public UsuariosDao(Connection con) {
        this.con = con;
    }  
    
    public static boolean validarUsuarios(String nombre, String contraseña) {
		
                ConnectionFactory con = new ConnectionFactory();
		Connection connect = con.recuperaConexion();
                  
		try {
			final PreparedStatement statement = connect.prepareStatement("SELECT * FROM usuarios WHERE BINARY nombre=? AND BINARY contraseña=?");
			try(statement){
				statement.setString(1, nombre);
				statement.setString(2, contraseña);
				
				statement.execute();
				
				final ResultSet resultSet = statement.executeQuery();

                                return resultSet.next();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
    }	
    
    public void guardar(Usuarios usuarios) {
         
        try {                
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO USUARIOS "
                        + "(nombre, contraseña)"
                        + " VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setString(1, usuarios.getUsuario());
                statement.setString(2, usuarios.getContraseña());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        usuarios.setId(resultSet.getInt(1));                                                
                    }
                                this.alerta = new Alert(AlertType.INFORMATION);
                                alerta.setTitle("Información");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Usuario agregado con éxito!");
                                alerta.showAndWait();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
                
    }

    public ObservableList<Usuarios> listar() {
        
        ObservableList<Usuarios> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, NOMBRE, CONTRASEÑA FROM usuarios");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Usuarios(
                                resultSet.getInt("id"),
                                resultSet.getString("Nombre"),
                                resultSet.getString("contraseña")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM USUARIOS WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                this.alerta = new Alert(AlertType.INFORMATION);
                                alerta.setTitle("Información");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Usuario borrado con éxito!");
                                alerta.showAndWait();
                return updateCount;       
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String usuario, String contraseña) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE USUARIOS SET "
                    + " NOMBRE = ?, "
                    + " CONTRASEÑA = ?"
                    + " WHERE ID = ?");

            try (statement) {                
                statement.setString(1, usuario);
                statement.setString(2, contraseña);
                statement.setInt(3, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                                this.alerta = new Alert(AlertType.INFORMATION);
                                alerta.setTitle("Información");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Usuario modificado con éxito!");
                                alerta.showAndWait();
                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarUsuario(String nombre) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM usuarios WHERE BINARY nombre=?");

            try (statement) {
                statement.setString(1, nombre);
                statement.execute();

                ResultSet resultSet = statement.executeQuery();

                return resultSet.next();
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

