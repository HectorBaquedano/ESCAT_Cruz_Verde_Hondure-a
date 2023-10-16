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
import model.Bases;


public class BasesDao {

    private final Connection con;
    private Alert alerta;

    public BasesDao(Connection con) {
        this.con = con;
    }  
    
    public void guardar(Bases bases) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO bases (ubicacion, codigo) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, bases.getUbicacion());
                statement.setString(2, bases.getCodigo());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        bases.setId(resultSet.getInt(1));
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Base guardada con éxito!");
                        alerta.showAndWait();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Bases> listar() {
        ObservableList<Bases> resultado = FXCollections.observableArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, UBICACION, CODIGO FROM bases");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Bases(
                                resultSet.getInt("id"),
                                resultSet.getString("UBICACION"),
                                resultSet.getString("CODIGO")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public ArrayList<Integer> listarBasesComboBox() {
        ArrayList<Integer> resultado = new ArrayList();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id FROM bases");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(resultSet.getInt("id"));
                        //resultado.add(resultSet.getString("codigo"));
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM bases WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Base eliminada con éxito!");
                        alerta.showAndWait();
                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(int id, String ubicacion, String codigo) {
        
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE bases SET "
                    + " UBICACION = ?, "
                    + " CODIGO = ?"
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, ubicacion);
                statement.setString(2, codigo);
                statement.setInt(3, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                        this.alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Información");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Base modificada con éxito!");
                        alerta.showAndWait();
                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean verificarBase(String ubicacion) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM bases WHERE BINARY ubicacion=?");

            try (statement) {
                statement.setString(1, ubicacion);
                statement.execute();

                ResultSet resultSet = statement.executeQuery();

                return resultSet.next();
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}

