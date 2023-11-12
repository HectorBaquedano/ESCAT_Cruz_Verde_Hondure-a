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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.AsignacionCursos;


public class AsignacionCursosDao {

    private final Connection con;
    private Alert alerta;

    public AsignacionCursosDao(Connection con) {
        this.con = con;
    }  
        
    public void guardar(AsignacionCursos asignacion) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO asignacion_cursos "
                        + "(curso, instructor, institucion, fechaInicio, duracion, lugarImpartido)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, asignacion.getCurso());
                statement.setString(2, asignacion.getInstructor());
                statement.setString(3, asignacion.getInstitucion());
                statement.setString(4, String.valueOf(asignacion.getFechaInicio()));
                statement.setString(5, asignacion.getDuracion());
                statement.setString(6, asignacion.getLugarImpartido());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        asignacion.setId(resultSet.getInt(1));  
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Asignación guardada con éxito!");
                        alerta.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<AsignacionCursos> listar() {
        ObservableList<AsignacionCursos> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, curso, instructor, institucion, fechaInicio, duracion, lugarImpartido FROM asignacion_cursos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new AsignacionCursos(
                                resultSet.getInt("id"),
                                resultSet.getString("curso"),
                                resultSet.getString("instructor"),
                                resultSet.getString("institucion"),
                                resultSet.getDate("fechaInicio").toLocalDate(),
                                resultSet.getString("duracion"),
                                resultSet.getString("lugarImpartido")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
    
    public ArrayList<String> listarAsignacionesComboBox() {
        ArrayList<String> resultado = new ArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id FROM asignacion_cursos");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(resultSet.getString("id"));
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM asignacion_cursos WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Asignación eliminada con éxito!");
                        alerta.showAndWait();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String curso, String instructor, String institucion, LocalDate fechaInicio, String duracion, String lugarImpartido) {
        try {
            
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE asignacion_cursos SET "
                    + " curso = ?, "
                    + " instructor = ?,"
                    + " institucion = ?,"
                    + " fechaInicio = ?,"
                    + " duracion = ?,"
                    + " lugarImpartido = ?"
                    + " WHERE id = ?");

            try (statement) {
                statement.setString(1, curso);
                statement.setString(2, instructor);
                statement.setString(3, institucion);
                statement.setObject(4, java.sql.Date.valueOf(fechaInicio));
                statement.setString(5, duracion);
                statement.setString(6, lugarImpartido);
                statement.setInt(7, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarAsignacion(String curso, String institucion, LocalDate fechaInicio) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM asignacion_cursos WHERE BINARY curso=? AND BINARY institucion = ? AND BINARY fechaInicio = ?" );

            try (statement) {
                statement.setString(1, curso);
                statement.setString(2, institucion);
                statement.setObject(3, java.sql.Date.valueOf(fechaInicio));
                statement.execute();

                ResultSet resultSet = statement.executeQuery();

                return resultSet.next();                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}