/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controller.PrincipalController;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import model.Alumnos;


public class AlumnosDao {

    private final Connection con;
    private Alert alerta;
    public PrincipalController principal;
    
    public AlumnosDao(Connection con) {
        this.con = con;
    }  
        
    public void guardar(Alumnos alumnos) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO alumnos "
                        + "(nombre, dni, email, telefono, direccion, sexo)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, alumnos.getNombre());
                statement.setString(2, alumnos.getDni());
                statement.setString(3, alumnos.getEmail());
                statement.setString(4, alumnos.getTelefono());
                statement.setString(5, alumnos.getDireccion());
                statement.setString(6, alumnos.getSexo());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        alumnos.setId(resultSet.getInt(1));  
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Alumno guardado con éxito!");
                        alerta.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Alumnos> listar() {
        ObservableList<Alumnos> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, nombre, dni, email, telefono, direccion, sexo FROM alumnos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Alumnos(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("dni"),
                                resultSet.getString("email"),
                                resultSet.getString("telefono"),
                                resultSet.getString("direccion"),
                                resultSet.getString("sexo")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public ArrayList<String> listarAlumnosComboBox() {
        ArrayList<String> resultado = new ArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT nombre FROM alumnos");
    
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM alumnos WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Alumno eliminado con éxito!");
                        alerta.showAndWait();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String nombre, String dni, String email, String telefono, String direccion, String sexo) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE alumnos SET "
                    + " NOMBRE = ?, "
                    + " DNI = ?,"
                    + " EMAIL = ?,"
                    + " TELEFONO = ?,"
                    + " DIRECCION = ?,"
                    + " SEXO = ?"
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, dni);
                statement.setString(3, email);
                statement.setString(4, telefono);
                statement.setString(5, direccion);
                statement.setString(6, sexo);
                statement.setInt(7, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarAlumno(String nombre, String dni) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM alumnos WHERE BINARY nombre=? AND BINARY dni = ?" );

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, dni);
                statement.execute();

                ResultSet resultSet = statement.executeQuery();

                return resultSet.next();                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int ContarAlumnosCapacitados() {
        
        int resultado = 0;
        
        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT count(id) FROM alumnos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado = resultSet.getInt("count(id)");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    public int ContarMujeresCapacitadas() {
        
        int resultado = 0;
        
        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT count(id) FROM alumnos WHERE sexo = 'F'");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado = resultSet.getInt("count(id)");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    public int ContarHombresCapacitadas() {
        
        int resultado = 0;
        
        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT count(id) FROM alumnos WHERE sexo = 'M'");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado = resultSet.getInt("count(id)");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
}