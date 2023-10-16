/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escat_cvh;

import java.sql.Connection;
import java.sql.SQLException;

import Factory.ConnectionFactory;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

       //Huesped huesped = new Huesped("Hector", "Baquedano", '12-28-1983', "hondureño", "+504 3178 8470");
        System.out.println("Conexión Exitosa");
        System.out.println("Cerrando la conexión en ");
        for(int i=3; i>0; i--) {
        System.out.print(i + " ");
        }
        con.close();
        System.out.println("Conexión cerrada correctamente");
    }

}    
