/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escat_cvh;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hector Baquedano
 */
public class ESCAT_CVH extends Application{
    
    private double x =0;
    private double y =0;
    
    @Override
    public void start(Stage stage) throws IOException {
          
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        
        root.setOnMouseDragged((MouseEvent event)->{
            stage.setX(event.getScreenX() -x);
            stage.setY(event.getScreenY() -y);
            
            stage.setOpacity(.8);
        });
        
        root.setOnMouseReleased((MouseEvent event)->{
            stage.setOpacity(1);
        });
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
    }
    
}
