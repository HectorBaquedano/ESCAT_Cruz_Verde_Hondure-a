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
import model.Instructores;


public class InstructoresDao {

    private final Connection con;


    public InstructoresDao(Connection con) {
        this.con = con;
    }  
  
    public void guardar(Instructores instructores) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO instructores "
                        + "(nombre, dni, email, telefono, sexo, base)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, instructores.getNombre());
                statement.setString(2, instructores.getDni());
                statement.setString(3, instructores.getEmail());
                statement.setString(4, instructores.getTelefono());                
                statement.setString(5, instructores.getSexo());
                statement.setString(6,instructores.getBase());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        instructores.setId(resultSet.getInt(1));                                                
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
//    public ObservableList<Instructores> listar() {
//    ObservableList<Instructores> resultado = FXCollections.observableArrayList();
//
//        try {
//            final PreparedStatement statement = con.prepareStatement(
//                    "SELECT i.id, i.nombre, i.dni, i.email, i.telefono, i.sexo, b.codigo AS base " +
//                    "FROM instructores i " +
//                    "INNER JOIN bases b ON i.id_base = b.id"
//            );
//
//            try (statement) {
//                statement.execute();
//
//                final ResultSet resultSet = statement.getResultSet();
//
//                try (resultSet) {
//                    while (resultSet.next()) {
//                        resultado.add(new Instructores(
//                                resultSet.getInt("ID"),
//                                resultSet.getString("NOMBRE"),
//                                resultSet.getString("DNI"),
//                                resultSet.getString("EMAIL"),
//                                resultSet.getString("TELEFONO"),
//                                resultSet.getString("SEXO"),
//                                resultSet.getInt("BASE")));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return resultado;
//    }

    public ObservableList<Instructores> listar() {
        
        ObservableList<Instructores> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, nombre, dni, email, telefono, sexo, base FROM instructores");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Instructores(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DNI"),
                                resultSet.getString("EMAIL"),
                                resultSet.getString("TELEFONO"),
                                resultSet.getString("SEXO"),
                                resultSet.getString("BASE")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public ArrayList<String> listarInstructoresComboBox() {
        ArrayList<String> resultado = new ArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT nombre FROM instructores");
    
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
    
    public int eliminar(int id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM instructores WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String nombre, String dni, String email, String telefono, String sexo, String base) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE instructores SET "
                    + " NOMBRE = ?, "
                    + " DNI = ?,"
                    + " EMAIL = ?,"
                    + " TELEFONO = ?,"                 
                    + " SEXO = ?,"
                    + " BASE = ?"
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, dni);
                statement.setString(3, email);
                statement.setString(4, telefono);
                statement.setString(5, sexo);
                statement.setString(6, base);
                statement.setInt(7, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarInstructor(String nombre, String dni) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM instructores WHERE BINARY nombre=? AND BINARY dni = ?" );

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

}

