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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Cursos;


public class CursosDao {

    private final Connection con;
    private Alert alerta;


    public CursosDao(Connection con) {
        this.con = con;
    }  
    
    public void guardar(Cursos cursos) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO cursos (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, cursos.getNombre());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        cursos.setId(resultSet.getInt(1)); 
                                this.alerta = new Alert(Alert.AlertType.INFORMATION);
                                alerta.setTitle("Información");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Curso agregado con éxito!");
                                alerta.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Cursos> listar() {
        ObservableList<Cursos> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, NOMBRE FROM cursos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Cursos(
                                resultSet.getInt("id"),
                                resultSet.getString("NOMBRE")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
    
    public ArrayList<String> listarCursoComboBox() {
        ArrayList<String> resultado = new ArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT NOMBRE FROM cursos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(resultSet.getString("NOMBRE"));
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM cursos WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                                this.alerta = new Alert(Alert.AlertType.INFORMATION);
                                alerta.setTitle("Información");
                                alerta.setHeaderText(null);
                                alerta.setContentText("Curso eliminado con éxito!");
                                alerta.showAndWait();
                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String nombre) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE cursos SET NOMBRE = ? WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setInt(2, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Curso modificado con éxito!");
                        alerta.showAndWait();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarCurso(String nombre) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM cursos WHERE BINARY nombre=?");

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

