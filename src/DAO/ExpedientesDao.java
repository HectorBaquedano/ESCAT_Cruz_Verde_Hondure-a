/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Expedientes;


public class ExpedientesDao {

    private final Connection con;
    private Alert alerta;
    private String certificado;

    public ExpedientesDao(Connection con) {
        this.con = con;
    }  
        
    public void guardar(Expedientes expedientes) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO expedientes "
                        + "(nombre, id_asignacion, certificado)"
                        + " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, expedientes.getNombre());
                statement.setInt(2, expedientes.getIdAsignacion());
                statement.setString(3, expedientes.getCertificado());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        expedientes.setId(resultSet.getInt(1));  
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Expediente guardado con éxito!");
                        alerta.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        
    public ObservableList<Expedientes> listar() {
        ObservableList<Expedientes> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, nombre, id_asignacion, certificado FROM expedientes");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Expedientes(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getInt("id_asignacion"),
                                resultSet.getString("certificado")));
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM expedientes WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Expediente eliminado con éxito!");
                        alerta.showAndWait();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String nombre, int idAsignacion, String certificado) {
        try {
            
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE expedientes SET "
                    + " nombre = ?, "
                    + " id_asignacion = ?,"
                    + " certificado = ?"
                    + " WHERE id = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setInt(2, idAsignacion);
                statement.setString(3, certificado);
                statement.setInt(4, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarExpediente(String nombre, int idAsignacion) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM expedientes WHERE BINARY nombre=? AND BINARY id_asignacion = ?" );

            try (statement) {
                statement.setString(1, nombre);
                statement.setInt(2, idAsignacion);
                statement.execute();

                ResultSet resultSet = statement.executeQuery();

                return resultSet.next();                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}