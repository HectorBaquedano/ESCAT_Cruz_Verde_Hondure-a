/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DAO.UsuariosDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hector Baquedano
 */
public class LoginController implements Initializable {


        @FXML
	private TextField txtUsuario;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Button btnLogin;
        
        @FXML
        private Button btnSalir;   
        
        public static String nombreUsuario;
        
        private double x = 0;
        private double y = 0;
        	        
	@FXML
	private void validarEspacio(KeyEvent evento) {

        Object evt = evento.getSource();
        
            if(evt.equals(txtUsuario)){

                if(evento.getText().equals(" ")){
                    evento.consume();
                    System.out.println("espacio");
                }

            }else if(evt.equals(txtPassword)){

                if(evento.getText().equals(" ")){
                    evento.consume();
                    System.out.println("espacio");
                }            

            }
	}
	
        
	@FXML
	private void eventAction(ActionEvent event) throws IOException {

            Alert alerta;
            Object evt = event.getSource();
           
            if(evt.equals(btnLogin)){
                if(!txtUsuario.getText().isEmpty() && !txtPassword.getText().isEmpty()){
                    
                    String nombre = txtUsuario.getText();
                    String contraseña = txtPassword.getText();
                    
                if(UsuariosDao.validarUsuarios(nombre, contraseña)){                 
                    
                    nombreUsuario = nombre;
                    
                    btnLogin.getScene().getWindow().hide();
                    
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent presionado) -> {
                        x = presionado.getSceneX();
                        y = presionado.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent arrastrar) ->{
                        stage.setX(arrastrar.getScreenX() - x);
                        stage.setY(arrastrar.getScreenY() - y);
                    
                        stage.setOpacity(.8);
                    });
                    
                    root.setOnMouseReleased((MouseEvent soltar)->{
                        stage.setOpacity(1);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                
                }else {
			alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("No es posible Iniciar Sesión");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Usuario o Contraseña incorrecta");
                        alerta.showAndWait();
                        txtUsuario.setText("");
                        txtPassword.setText("");
                    }      
                              
                }else{
                
                    alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error de Datos");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Los Campos no pueden estar vacíos");
                    alerta.showAndWait();                                
                }
        
            }
            if(evt.equals(btnSalir)){
                System.exit(0);
            }
    
        }

	@Override
	public void initialize(URL ur1, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}        
   
}
