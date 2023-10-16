/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuariosDao;
import Factory.ConnectionFactory;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Alumnos;
import model.Bases;
import model.Cursos;
import model.Instituciones;
import model.Instructores;
import model.Usuarios;

/**
 *
 * @author Hector Baquedano
 */
public class PrincipalController implements Initializable{

    @FXML
    public TextField Usuarios_contraseña;

    @FXML
    private TextField alumnos_dirección;

    @FXML
    private TextField alumnos_dni;

    @FXML
    private TextField alumnos_email;

    @FXML
    private TextField alumnos_id;

    @FXML
    private TextField alumnos_nombre;

    @FXML
    private ComboBox<String> alumnos_sexo;

    @FXML
    private TextField alumnos_teléfono;

    @FXML
    private ComboBox<?> asignaciónCurso_curso;

    @FXML
    private TextField asignaciónCurso_duración;

    @FXML
    private DatePicker asignaciónCurso_fechaInicio;

    @FXML
    private TextField asignaciónCurso_id;

    @FXML
    private ComboBox<?> asignaciónCurso_institución;

    @FXML
    private ComboBox<?> asignaciónCurso_instructor;

    @FXML
    private TextField asignaciónCurso_lugarImpartido;

    @FXML
    private TextField bases_código;

    @FXML
    private TextField bases_id;

    @FXML
    private TextField bases_ubicación;

    @FXML
    private Button btnMinimizar;

    @FXML
    private Button btn_agregar_alumnos;

    @FXML
    private Button btn_agregar_asignaciónCurso;

    @FXML
    private Button btn_agregar_bases;

    @FXML
    private Button btn_agregar_cursos;

    @FXML
    private Button btn_agregar_expediente;

    @FXML
    private Button btn_agregar_instituciones;

    @FXML
    private Button btn_agregar_instructores;

    @FXML
    private Button btn_agregar_usuarios;

    @FXML
    private Button btn_alumnos;

    @FXML
    private Button btn_asignaciónCursos;

    @FXML
    private Button btn_bases;

    @FXML
    private Button btn_cerrarSesión;

    @FXML
    private Button btn_cursos;

    @FXML
    private Button btn_detalle_asignaciónCurso;

    @FXML
    private Button btn_eliminar_alumnos;

    @FXML
    private Button btn_eliminar_asignaciónCurso;

    @FXML
    private Button btn_eliminar_bases;

    @FXML
    private Button btn_eliminar_cursos;

    @FXML
    private Button btn_eliminar_expediente;

    @FXML
    private Button btn_eliminar_instituciones;

    @FXML
    private Button btn_eliminar_instructores;

    @FXML
    private Button btn_eliminar_usuarios;

    @FXML
    private Button btn_expediente;

    @FXML
    private Button btn_imprimir_alumnos;

    @FXML
    private Button btn_imprimir_detalle_asignaciónCurso;

    @FXML
    private Button btn_imprimir_expediente;

    @FXML
    private Button btn_imprimir_instituciones;

    @FXML
    private Button btn_imprimir_instructores;

    @FXML
    private Button btn_inicio;

    @FXML
    private Button btn_instituciones;

    @FXML
    private Button btn_instructores;

    @FXML
    private Button btn_limpiar_alumnos;

    @FXML
    private Button btn_limpiar_asignaciónCurso;

    @FXML
    private Button btn_limpiar_bases;

    @FXML
    private Button btn_limpiar_cursos;

    @FXML
    private Button btn_limpiar_expediente;

    @FXML
    private Button btn_limpiar_instituciones;

    @FXML
    private Button btn_limpiar_instructores;

    @FXML
    private Button btn_limpiar_usuarios;

    @FXML
    private Button btn_modificar_alumnos;

    @FXML
    private Button btn_modificar_asignaciónCurso;

    @FXML
    private Button btn_modificar_bases;

    @FXML
    private Button btn_modificar_cursos;

    @FXML
    private Button btn_modificar_expediente;

    @FXML
    private Button btn_modificar_instituciones;

    @FXML
    private Button btn_modificar_instructores;

    @FXML
    private Button btn_modificar_usuarios;

    @FXML
    private Button btn_salir;

    @FXML
    private Button btn_usuarios;

    @FXML
    private TextField buscar_alumnos;

    @FXML
    private TextField buscar_asignaciónCurso;

    @FXML
    private TextField buscar_bases;

    @FXML
    private TextField buscar_cursos;

    @FXML
    private TextField buscar_expediente;

    @FXML
    private TextField buscar_instituciones;

    @FXML
    private TextField buscar_instructores;

    @FXML
    private TextField buscar_usuarios;

    @FXML
    private TextField cursos_id;

    @FXML
    private TextField cursos_nombre;

    @FXML
    private Label etiqueta_usuario;

    @FXML
    private TextField expediente_certificado;

    @FXML
    private ComboBox<?> expediente_curso;

    @FXML
    private TextField expediente_id;

    @FXML
    private ComboBox<?> expediente_nombreAlumno;

    @FXML
    private AnchorPane formulario_alumnos;

    @FXML
    private AnchorPane formulario_asignaciónCursos;

    @FXML
    private AnchorPane formulario_bases;

    @FXML
    private AnchorPane formulario_cursos;

    @FXML
    private AnchorPane formulario_expediente;

    @FXML
    private AnchorPane formulario_informe_asignaciónCursos;

    @FXML
    private AnchorPane formulario_inicio;

    @FXML
    private AnchorPane formulario_instituciones;

    @FXML
    private AnchorPane formulario_instructores;

    @FXML
    private AnchorPane formulario_principal;

    @FXML
    private AnchorPane formulario_usuarios;

    @FXML
    private Label informe_etiqueta_duración_horas;

    @FXML
    private Label informe_etiqueta_fecha_inicio;

    @FXML
    private Label informe_etiqueta_id;

    @FXML
    private Label informe_etiqueta_lugar_impartido;

    @FXML
    private Label informe_etiqueta_nombre_curso;

    @FXML
    private Label informe_etiqueta_nombre_institución;

    @FXML
    private Label informe_etiqueta_nombre_instructor;

    @FXML
    private Label inicio_contadorHombres;

    @FXML
    private Label inicio_contadorMujeres;

    @FXML
    private Label inicio_contadorTotal;

    @FXML
    private LineChart<?, ?> inicio_gráficaHombres;

    @FXML
    private LineChart<?, ?> inicio_gráficaMujeres;

    @FXML
    private BarChart<?, ?> inicio_gráficaTotal;

    @FXML
    private TextField instituciones_id;

    @FXML
    private TextField instituciones_nombre;

    @FXML
    private ComboBox<?> instructores_base;

    @FXML
    private TextField instructores_dni;

    @FXML
    private TextField instructores_email;

    @FXML
    private TextField instructores_id;

    @FXML
    private TextField instructores_nombre;

    @FXML
    private ComboBox<String> instructores_sexo;

    @FXML
    private TextField instructores_teléfono;

    @FXML
    private TableView<Alumnos> tabla_alumnos;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_dni;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_email;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_id;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_nombre;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_sexo;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_teléfono;

    @FXML
    private TableColumn<Alumnos, String> tabla_alumnos_direccion;
        
    @FXML
    private TableView<?> tabla_asignaciónCurso;

    @FXML
    private TableView<?> tabla_asignaciónCurso1;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_curso;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_horas;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_id;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_inicio;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_institución;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_instructor;

    @FXML
    private TableColumn<?, ?> tabla_asignaciónCurso_lugar;

    @FXML
    private TableView<Bases> tabla_bases;

    @FXML
    private TableColumn<Bases, String> tabla_bases_código;

    @FXML
    private TableColumn<Bases, String> tabla_bases_id;

    @FXML
    private TableColumn<Bases, String> tabla_bases_ubicación;

    @FXML
    private TableView<Cursos> tabla_cursos;

    @FXML
    private TableColumn<Cursos, String> tabla_cursos_id;

    @FXML
    private TableColumn<Cursos, String> tabla_cursos_nombre;

    @FXML
    private TableView<?> tabla_expediente;

    @FXML
    private TableColumn<?, ?> tabla_expediente_certificado;

    @FXML
    private TableColumn<?, ?> tabla_expediente_curso;

    @FXML
    private TableColumn<?, ?> tabla_expediente_id;

    @FXML
    private TableColumn<?, ?> tabla_expediente_nombre;

    @FXML
    private TableColumn<?, ?> tabla_informe_asignaciónCurso_certificado;

    @FXML
    private TableColumn<?, ?> tabla_informe_asignaciónCurso_dni;

    @FXML
    private TableColumn<?, ?> tabla_informe_asignaciónCurso_id;

    @FXML
    private TableColumn<?, ?> tabla_informe_asignaciónCurso_nombre_alumno;

    @FXML
    private TableColumn<?, ?> tabla_informe_asignaciónCurso_sexo;

    @FXML
    private TableView<Instituciones> tabla_instituciones;

    @FXML
    private TableColumn<Instituciones, String> tabla_instituciones_id;

    @FXML
    private TableColumn<Instituciones, String> tabla_instituciones_nombre;

    @FXML
    private TableView<Instructores> tabla_instructores;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_base;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_dni;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_email;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_id;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_nombre;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_sexo;

    @FXML
    private TableColumn<Instructores, String> tabla_instructores_teléfono;

    @FXML
    private TableView<Usuarios> tabla_usuarios;

    @FXML
    private TableColumn<Usuarios, String> tabla_usuarios_contraseña;

    @FXML
    private TableColumn<Usuarios, String> tabla_usuarios_id;

    @FXML
    private TableColumn<Usuarios, String> tabla_usuarios_usuario;

    @FXML
    private TextField usuarios_id;

    @FXML
    public TextField usuarios_usuario;
    
    //private ObservableList<Usuarios> listaUsuarios;
    
    private UsuariosController usuariosController;
    
    private UsuariosDao usuariosDao;
    
    private AlumnosController alumnosController;
    
    private CursosController cursosController;
    
    private BasesController basesController;
    
    private Instituciones instituciones;
    
    private InstitucionesController institucionesController;
    
    private Instructores instructores;
    
    private InstructoresController instructoresController;
    
    private Usuarios usuarios;
    
    private Cursos cursos;
    
    private Bases bases;
    
    
    private Alert alerta;
            
    private double x = 0;
    private double y = 0;
    
    private String[] listaSexo = {"Masculino","Femenino"};  
    private LoginController loginController;
    

    public void listaGeneroComboBox(){
        List<String> genero = new ArrayList();
        
        for(String sexo : listaSexo){
            genero.add(sexo);
        }        
        ObservableList obList = FXCollections.observableArrayList(listaSexo);
        alumnos_sexo.setItems(obList);
        instructores_sexo.setItems(obList);        
    }
        
//----------------INICIO DE LOS METODOS DE LA SECCIÓN INSTRUCTORES----------------------------------//
        
    public void limpiarInstructores(){
        instructores_id.setText("");
        instructores_nombre.setText("");
        instructores_dni.setText("");
        instructores_email.setText("");
        instructores_teléfono.setText("");
        instructores_sexo.getSelectionModel().clearSelection();
        instructores_base.getSelectionModel().clearSelection();
    }
    
    public void SeleccionarInstructor(){
    
        Instructores instructores = tabla_instructores.getSelectionModel().getSelectedItem();
        int num = tabla_instructores.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        instructores_id.setText(String.valueOf(instructores.getId()));
        instructores_nombre.setText(instructores.getNombre());
        instructores_dni.setText(instructores.getDni());
        instructores_email.setText(instructores.getEmail());
        instructores_teléfono.setText(instructores.getTelefono());
        instructores_sexo.getSelectionModel().select(instructores.getSexo());
        instructores_base.getSelectionModel().select(instructores.getBase()-1);
    }
    
    public void agregarInstructor(){
        
        instructoresController = new InstructoresController();
        basesController = new BasesController();
        
        if(instructores_nombre.getText().isBlank() || instructores_dni.getText().isBlank() 
                || instructores_teléfono.getText().isBlank() || instructores_base.getItems().isEmpty()
                || instructores_sexo.getItems().isEmpty()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
            
        }else if(instructoresController.verificar(instructores_nombre.getText(), instructores_dni.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("El instructor '"+ instructores_nombre.getText() + "' con DNI '" + instructores_dni.getText() + "', ya existe!");
            alerta.showAndWait();
            
        }else{
            instructoresController.guardar( new Instructores(instructores_nombre.getText(),instructores_dni.getText(),
                    instructores_email.getText(),instructores_teléfono.getText(), instructores_sexo.getSelectionModel().getSelectedItem(),
                    (int)instructores_base.getSelectionModel().getSelectedItem()));

            limpiarInstructores();
            mostrarTablaInstructores();            
        }       
    }
     
    public void eliminarInstructor(){
                
        Instructores instructores = tabla_instructores.getSelectionModel().getSelectedItem();
        int num = tabla_instructores.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar el instructor '"+ instructores.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                instructoresController.eliminar(instructores.getId());
            }else return;
        
        limpiarInstructores();
        mostrarTablaInstructores();
    } 
    
    public void modificarInstructor(){
                
        Instructores instructores = tabla_instructores.getSelectionModel().getSelectedItem();
        int num = tabla_instructores.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar el instructor '"+ instructores.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                instructoresController.modificar(instructores.getId(), instructores_nombre.getText(), instructores_dni.getText(),
                        instructores_email.getText(), instructores_teléfono.getText(),(String)instructores_sexo.getSelectionModel().getSelectedItem(),
                        (Integer)instructores_base.getSelectionModel().getSelectedItem());
            }else return;
        
        limpiarInstructores();
        mostrarTablaInstructores();        
    }
    
    public void listaInstructoresComboBox(){
        
        InstructoresController instructoresController = new InstructoresController(); 
        ObservableList obList = FXCollections.observableArrayList(instructoresController.listarInstructoresComboBox());    
        asignaciónCurso_instructor.setItems(obList);
    }
    
    public void mostrarTablaInstructores(){
    
        this.instructoresController = new InstructoresController();
        
        ObservableList<Instructores> listar = instructoresController.listar();
        
        tabla_instructores_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla_instructores_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tabla_instructores_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tabla_instructores_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabla_instructores_teléfono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tabla_instructores_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tabla_instructores_base.setCellValueFactory(new PropertyValueFactory<>("base"));
        
        tabla_instructores.setItems(listar);        
    }
        
//----------------FINAL DE LOS METODOS DE LA SECCIÓN INSTRUCTORES----------------------------------//
    
//----------------INICIO DE LOS METODOS DE LA SECCIÓN ALUMNOS----------------------------------//
    public void listarAlumnosCapacitados(){
        this.alumnosController = new AlumnosController();
        inicio_contadorTotal.setText(String.valueOf(alumnosController.ContarAlumnosCapacitados()));
        inicio_contadorMujeres.setText(String.valueOf(alumnosController.ContarMujeresCapacitadas()));
        inicio_contadorHombres.setText(String.valueOf(alumnosController.ContarHombresCapacitados()));
    }
    
    public void limpiarAlumnos(){
        alumnos_id.setText("");
        alumnos_nombre.setText("");
        alumnos_dni.setText("");
        alumnos_email.setText("");
        alumnos_teléfono.setText("");
        alumnos_sexo.getSelectionModel().clearSelection();
        alumnos_dirección.setText("");
    }
    
    public void SeleccionarAlumno(){
    
        Alumnos alumnos = tabla_alumnos.getSelectionModel().getSelectedItem();
        int num = tabla_alumnos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        alumnos_id.setText(String.valueOf(alumnos.getId()));
        alumnos_nombre.setText(alumnos.getNombre());
        alumnos_dni.setText(alumnos.getDni());
        alumnos_email.setText(alumnos.getEmail());
        alumnos_teléfono.setText(alumnos.getTelefono());
        alumnos_sexo.getSelectionModel().select(alumnos.getSexo());
        alumnos_dirección.setText(alumnos.getDireccion());
    }
    
    public void agregarAlumno(){
        
        alumnosController = new AlumnosController();
        
        if(alumnos_nombre.getText().isBlank() || alumnos_dni.getText().isBlank() 
                || alumnos_teléfono.getText().isBlank() || alumnos_dirección.getText().isBlank() 
                || alumnos_sexo.getItems().isEmpty()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
            
        }else if(alumnosController.verificar(alumnos_nombre.getText(), alumnos_dni.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("El alumno '"+ alumnos_nombre.getText()+ "' con DNI '"+alumnos_dni.getText()+"', ya existe!");
            alerta.showAndWait();
            
        }else{
            alumnosController.guardar( new Alumnos(alumnos_nombre.getText(),alumnos_dni.getText(),
                    alumnos_email.getText(),alumnos_teléfono.getText(), alumnos_dirección.getText(),
                    alumnos_sexo.getSelectionModel().getSelectedItem()));
            
            mostrarTablaAlumnos();
            limpiarAlumnos();
        }       
    }
     
    public void eliminarAlumno(){
                
        Alumnos alumnos = tabla_alumnos.getSelectionModel().getSelectedItem();
        int num = tabla_alumnos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar el alumno '"+ alumnos.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                alumnosController.eliminar(alumnos.getId());
            }else return;
        
        limpiarAlumnos();
        mostrarTablaAlumnos();
    } 
    
    public void modificarAlumno(){
                
        Alumnos alumnos = tabla_alumnos.getSelectionModel().getSelectedItem();
        int num = tabla_alumnos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar el alumno '"+ alumnos.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                alumnosController.modificar(alumnos.getId(), alumnos_nombre.getText(),alumnos_dni.getText(),
                        alumnos_email.getText(), alumnos_teléfono.getText(), alumnos_dirección.getText(),
                        (String)alumnos_sexo.getSelectionModel().getSelectedItem());
            }else return;
        
        limpiarAlumnos();
        mostrarTablaAlumnos();        
    }
    
    public void listaAlumnosComboBox(){
        
        AlumnosController alumnosController = new AlumnosController(); 
        ObservableList obList = FXCollections.observableArrayList(alumnosController.listarAlumnosComboBox());    
        expediente_nombreAlumno.setItems(obList);
    }
        
    public void mostrarTablaAlumnos(){
    
        this.alumnosController = new AlumnosController();

        ObservableList<Alumnos> listar = alumnosController.listar();
        
        tabla_alumnos_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla_alumnos_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tabla_alumnos_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tabla_alumnos_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabla_alumnos_teléfono.setCellValueFactory(new PropertyValueFactory<>("telefono"));        
        tabla_alumnos_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla_alumnos_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        
        tabla_alumnos.setItems(listar);        
    }
        
//----------------FINAL DE LOS METODOS DE LA SECCIÓN ALUMNOS----------------------------------//
    
//----------------INICIO DE LOS METODOS DE LA SECCIÓN INSTITUCIONES----------------------------------//
    
    public void limpiarInstituciones(){
        instituciones_id.setText("");
        instituciones_nombre.setText("");
    }
    
    public void SeleccionarInstitucion(){
    
        Instituciones instituciones = tabla_instituciones.getSelectionModel().getSelectedItem();
        int num = tabla_instituciones.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        instituciones_id.setText(String.valueOf(instituciones.getId()));
        instituciones_nombre.setText(instituciones.getNombre());
    }

    public void agregarInstitucion(){
        institucionesController = new InstitucionesController();
        if(instituciones_nombre.getText().isBlank()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
        }else if(institucionesController.verificar(instituciones_nombre.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("La institución '"+ instituciones_nombre.getText()+ "', ya existe!");
            alerta.showAndWait();
        }else{
            institucionesController.guardar( new Instituciones(instituciones_nombre.getText()));
            limpiarInstituciones();
            mostrarTablaInstituciones();            
        }        
    }

    public void eliminarInstitucion(){
                
        Instituciones instituciones = tabla_instituciones.getSelectionModel().getSelectedItem();
        int num = tabla_instituciones.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar la institución '"+ instituciones.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                institucionesController.eliminar(instituciones.getId());
            }else return;
        
        limpiarInstituciones();
        mostrarTablaInstituciones();
    }

    public void modificarInstitucion(){
                
        Instituciones instituciones = tabla_instituciones.getSelectionModel().getSelectedItem();
        int num = tabla_instituciones.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar la institución '"+ instituciones.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                institucionesController.modificar(instituciones.getId(), instituciones_nombre.getText());
            }else return;
        
        limpiarInstituciones();
        mostrarTablaInstituciones();        
    }
    
    public void listaInstitucionesComboBox(){
        
        InstitucionesController institucionesController = new InstitucionesController(); 
        ObservableList obList = FXCollections.observableArrayList(institucionesController.listarInstitucionesComboBox());
        asignaciónCurso_institución.setItems(obList);
    }
    
    public void mostrarTablaInstituciones(){
    
        this.institucionesController = new InstitucionesController();
       
        ObservableList<Instituciones> listar = institucionesController.listar();
        
        tabla_instituciones_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla_instituciones_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                
        tabla_instituciones.setItems(listar);
        
    }
    
//-----------------FINAL DE LOS METODOS DE LA SECCIÓN INSTITUCIONES----------------------------------//
    
//---------------------INICIO DE LOS METODOS DE LA SECCIÓN BASES-------------------------------------//
    
    public void limpiarBases(){
        bases_id.setText("");
        bases_ubicación.setText("");
        bases_código.setText("");
    }
    
    public void SeleccionarBase(){
    
        Bases bases = tabla_bases.getSelectionModel().getSelectedItem();
        int num = tabla_bases.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        bases_id.setText(String.valueOf(bases.getId()));
        bases_ubicación.setText(bases.getUbicacion());
        bases_código.setText(bases.getCodigo());
    }

    public void agregarBase(){
        basesController = new BasesController();
        if(bases_ubicación.getText().isBlank() || bases_código.getText().isBlank()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
        }else if(basesController.verificar(bases_ubicación.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("La ubicación '"+ bases_ubicación.getText()+ "', ya existe!");
            alerta.showAndWait();
        }else{
            basesController.guardar( new Bases(bases_ubicación.getText(),bases_código.getText()));
            limpiarBases();
            mostrarTablaBases();            
        }        
    }

    public void eliminarBase(){
                
        Bases bases = tabla_bases.getSelectionModel().getSelectedItem();
        int num = tabla_bases.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar la base '"+ bases.getCodigo()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                basesController.eliminar(bases.getId());
            }else return;
        
        limpiarBases();
        mostrarTablaBases();
    }

    public void modificarBase(){
                
        Bases bases = tabla_bases.getSelectionModel().getSelectedItem();
        int num = tabla_bases.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar la base '"+ bases.getUbicacion()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                basesController.modificar(bases.getId(), bases_ubicación.getText(), bases_código.getText());
            }else return;
        
        limpiarBases();
        mostrarTablaBases();        
    }
    
    public void listaBasesComboBox(){
        
        BasesController basesController = new BasesController(); 
        ObservableList obList = FXCollections.observableArrayList(basesController.listarBasesComboBox());
        instructores_base.setItems(obList);
    }
    
    public void mostrarTablaBases(){
    
        this.basesController = new BasesController();
       
        ObservableList<Bases> listar = basesController.listar();
        
        tabla_bases_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla_bases_ubicación.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        tabla_bases_código.setCellValueFactory(new PropertyValueFactory<>("codigo"));
                
        tabla_bases.setItems(listar);
        
    }        
//---------------------FINAL DE LOS METODOS DE LA SECCIÓN BASES-----------------------------------------//
    
//---------------------INICIO DE LOS METODOS DE LA SECCIÓN CURSOS-------------------------------------//
    
    public void limpiarCursos(){
        cursos_id.setText("");
        cursos_nombre.setText("");
    }
    
    public void SeleccionarCurso(){
    
        Cursos cursos = tabla_cursos.getSelectionModel().getSelectedItem();
        int num = tabla_cursos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        cursos_id.setText(String.valueOf(cursos.getId()));
        cursos_nombre.setText(cursos.getNombre());        
    }

    public void agregarCurso(){
        
        if(cursos_nombre.getText().isBlank()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
        }else if(cursosController.verificar(cursos_nombre.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("El curso '"+cursos_nombre.getText()+ "', ya existe!");
            alerta.showAndWait();
        }else{
            cursosController.guardar( new Cursos(cursos_nombre.getText()));
            limpiarCursos();
            mostrarTablaCursos();            
        }        
    }

    public void eliminarCurso(){
                
        Cursos cursos = tabla_cursos.getSelectionModel().getSelectedItem();
        int num = tabla_cursos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar el curso '"+ cursos.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                cursosController.eliminar(cursos.getId());
            }else return;
        
        limpiarCursos();
        mostrarTablaCursos();
    }

    public void modificarCurso(){
                
        Cursos cursos = tabla_cursos.getSelectionModel().getSelectedItem();
        int num = tabla_cursos.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar el curso '"+ cursos.getNombre()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                cursosController.modificar(cursos.getId(), cursos_nombre.getText());
            }else return;
        
        limpiarCursos();
        mostrarTablaCursos();        
    }
    
    public void listaCursosComboBox(){
        
        CursosController cursosController = new CursosController(); 
        ObservableList obList = FXCollections.observableArrayList(cursosController.listarCursoComboBox());
        asignaciónCurso_curso.setItems(obList);
        expediente_curso.setItems(obList);
    }
    
    public void mostrarTablaCursos(){
    
        this.cursosController = new CursosController();
       
        ObservableList<Cursos> listar = cursosController.listar();
        
        tabla_cursos_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla_cursos_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                
        tabla_cursos.setItems(listar);
        
    }
        
//---------------------FINAL DE LOS METODOS DE LA SECCIÓN CURSOS-----------------------------------------//
    
//---------------------INICIO DE METODOS DE LA SECCIÓN USUARIOS------------------------------------------//
    
    public void limpiarUsuarios(){        
        usuarios_usuario.setText("");
        Usuarios_contraseña.setText("");
    }
    
    public void SeleccionarUsuario(){
    
        Usuarios usuarios = tabla_usuarios.getSelectionModel().getSelectedItem();
        int num = tabla_usuarios.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
        usuarios_usuario.setText(usuarios.getUsuario());
        Usuarios_contraseña.setText(usuarios.getContraseña());
    }
    
    public void agregarUsuario(){
        
        if(usuarios_usuario.getText().isBlank() || Usuarios_contraseña.getText().isBlank()){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Los campos obligatorios no pueden estar vacíos");
            alerta.showAndWait();
        }else if(usuariosController.verificar(usuarios_usuario.getText())){
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("El usuario '"+usuarios_usuario.getText()+ "', ya existe!");
            alerta.showAndWait();
        }else{
            usuariosController.guardar( new Usuarios(usuarios_usuario.getText(),Usuarios_contraseña.getText()));
            limpiarUsuarios();
            mostrarTablaUsuarios();
            
        }        
    }
    
    public void eliminarUsuario(){
                
        Usuarios usuarios = tabla_usuarios.getSelectionModel().getSelectedItem();
        int num = tabla_usuarios.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea borrar al usuario "+ usuarios.getUsuario()+ "?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){        
                usuariosController.eliminar(usuarios.getId());
            }else return;
        
        limpiarUsuarios();
        mostrarTablaUsuarios();        
    }
    
    public void modificarUsuario(){
                
        Usuarios usuarios = tabla_usuarios.getSelectionModel().getSelectedItem();
        int num = tabla_usuarios.getSelectionModel().getSelectedIndex();
        
        if((num-1)<-1) return;
        
            alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Advertencia!!!");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea modificar el usuario '"+ usuarios.getUsuario()+ "'?");
            ButtonType confirmar = new ButtonType("Confirmar");
            ButtonType cancelar = new ButtonType("Cancelar");
            alerta.getButtonTypes().setAll(confirmar,cancelar);
            Optional<ButtonType> opcion = alerta.showAndWait();
                       
            if(opcion.get().equals(confirmar)){                
                usuariosController.modificar(usuarios.getId(), usuarios_usuario.getText(),Usuarios_contraseña.getText());
            }else return;
        
        limpiarUsuarios();
        mostrarTablaUsuarios();        
    }
    
    public void mostrarTablaUsuarios(){
    
        this.usuariosController = new UsuariosController();

        ObservableList<Usuarios> listar = usuariosController.listar();
        
        tabla_usuarios_usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tabla_usuarios_contraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        
        tabla_usuarios.setItems(listar);
        
    }
    
//------------------------------FINAL METODOS DE LA SECCIÓN USUARIOS-----------------------------------------//    
    
//------------------------------INICIO DE METODOS DEL MENU PRINCIPAL-----------------------------------------//    
    
    public void cerrarSesion(){
        
        try{
        
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Mensaje de Confirmación");
            alerta.setHeaderText(null);
            alerta.setContentText("Está seguro que desea cerrar sesión?");
            
            Optional<ButtonType> opcion = alerta.showAndWait();
            
            if(opcion.get().equals(ButtonType.OK)){
                
                btn_cerrarSesión.getScene().getWindow().hide();
                
                Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
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
            
            }else return;
            
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
       
    public void cambiarFormulario(ActionEvent cambio){
        if(cambio.getSource() == btn_inicio){
            formulario_inicio.setVisible(true);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);

            btn_inicio.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            listarAlumnosCapacitados();
            
        }else if(cambio.getSource() == btn_alumnos){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(true);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            limpiarAlumnos();
            mostrarTablaAlumnos();
            listaGeneroComboBox();
            
        }else if(cambio.getSource() == btn_cursos){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(true);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            limpiarCursos();
            mostrarTablaCursos();
            
        }else if(cambio.getSource() == btn_bases){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(true);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            limpiarBases();
            mostrarTablaBases();
            
        }else if(cambio.getSource() == btn_instituciones){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(true);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            limpiarInstituciones();
            mostrarTablaInstituciones();
            
        }else if(cambio.getSource() == btn_expediente){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(true);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            listaCursosComboBox();
            listaAlumnosComboBox();
            listaInstitucionesComboBox();
            
        }else if(cambio.getSource() == btn_instructores){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(true);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            limpiarInstructores();
            listaGeneroComboBox();
            listaBasesComboBox();
            mostrarTablaInstructores();
            
        }else if(cambio.getSource() == btn_asignaciónCursos){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(true);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            btn_usuarios.setStyle("-fx-background-color: transparent");
            
            listaCursosComboBox();
            listaInstructoresComboBox();
            listaInstitucionesComboBox();
            
        }else if(cambio.getSource() == btn_usuarios){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(true);
            formulario_informe_asignaciónCursos.setVisible(false);
            
            btn_inicio.setStyle("-fx-background-color: transparent");
            btn_alumnos.setStyle("-fx-background-color: transparent");
            btn_cursos.setStyle("-fx-background-color: transparent");
            btn_bases.setStyle("-fx-background-color: transparent");
            btn_instituciones.setStyle("-fx-background-color: transparent");
            btn_expediente.setStyle("-fx-background-color: transparent");
            btn_instructores.setStyle("-fx-background-color: transparent");
            btn_asignaciónCursos.setStyle("-fx-background-color: transparent");
            btn_usuarios.setStyle("-fx-background-color: linear-gradient(to bottom right, #339434, #33cc33)");
            
            mostrarTablaUsuarios();
            limpiarUsuarios();
            
        }else if(cambio.getSource() == btn_detalle_asignaciónCurso){
            formulario_inicio.setVisible(false);
            formulario_alumnos.setVisible(false);
            formulario_cursos.setVisible(false);
            formulario_bases.setVisible(false);
            formulario_instituciones.setVisible(false);
            formulario_expediente.setVisible(false);
            formulario_instructores.setVisible(false);
            formulario_asignaciónCursos.setVisible(false);
            formulario_usuarios.setVisible(false);
            formulario_informe_asignaciónCursos.setVisible(true);
        }
    }

    public void salir(){
        System.exit(0);
    }
    
    public void minimizar(){
        Stage stage = (Stage)formulario_principal.getScene().getWindow();
        stage.setIconified(true);
    }
//------------------------------FINAL DE METODOS DEL MENU PRINCIPAL-----------------------------------------//    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaBasesComboBox();
        listaGeneroComboBox();
        listaCursosComboBox();
        listaAlumnosComboBox();
        listarAlumnosCapacitados();
        mostrarTablaAlumnos();
        mostrarTablaUsuarios();
        mostrarTablaCursos();
        mostrarTablaBases();
        mostrarTablaInstituciones();
        mostrarTablaInstructores();

    }

}