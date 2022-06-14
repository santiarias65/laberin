/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class ReportesController implements Initializable {

    @FXML
    private Label ganadoNivel1;
    @FXML
    private Label perdidoNivel1;
    @FXML
    private Label ganadoNivel2;
    @FXML
    private Label perdidoNivel2;
    @FXML
    private Label ganadoNivel3;
    @FXML
    private Label perdidoNivel3;
    @FXML
    private Label ganadoNivel4;
    @FXML
    private Label perdidoNivel4;
    @FXML
    private Label ganadoNivel5;
    @FXML
    private Label perdidoNivel5;
    @FXML
    private Label totalTest;
    @FXML
    private Label totalTest1;
    @FXML
    private Label respuestaGanadoNivel1;
    @FXML
    private Label respuestaGanadoNivel2;
    @FXML
    private Label respuestaGanadoNivel3;
    @FXML
    private Label respuestaGanadoNivel4;
    @FXML
    private Label respuestaGanadoNivel5;
    @FXML
    private Label respuestaPerdidoNivel1;
    @FXML
    private Label respuestaPerdidoNivel2;
    @FXML
    private Label respuestaPerdidoNivel3;
    @FXML
    private Label respuestaPerdidoNivel5;
    @FXML
    private Label respuestaPerdidoNivel4;
    @FXML
    private TableView<Jugador> tablaUsuarios;
    @FXML
    private TableColumn<Jugador, String> columnaUsername;
    @FXML
    private TableColumn<Jugador, Integer> columnaPuntos;
    @FXML
    private Label totalUsuarios;
    @FXML
    private TextArea contenedorPregunta;
    
    private int totalTestMfc;
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    DecimalFormat decimales = new DecimalFormat("0.0");
    private ArrayList<String>listaPreguntas = new ArrayList<>();
    //private ArrayList<Double>listaPromedioEncuesta = new ArrayList<>();
    @FXML
    private Label encuestaPregunta1;
    @FXML
    private Label encuestaPregunta2;
    @FXML
    private Label encuestaPregunta3;
    @FXML
    private Label totalEncuestas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //mfc.abrirConexion();
        totalTestMfc=mfc.totalTest();
        listaPreguntas = mfc.listaPreguntas();
        //traemos los valores de los promedios
        Double p1 = mfc.listaPromedioEncuesta("pregunta1");
        Double p2 = mfc.listaPromedioEncuesta("pregunta2");
        Double p3 = mfc.listaPromedioEncuesta("pregunta3");
        //mfc.cerrarConexion();
        totalTest.setText(""+totalTestMfc);
        totalTest1.setText(""+totalTestMfc);
        totalEncuestas.setText(""+totalTestMfc);
        
        //setiamos los valores del promedio de la encuesta
        encuestaPregunta1.setText(decimales.format(p1)+"%");
        encuestaPregunta2.setText(decimales.format(p2)+"%");
        encuestaPregunta3.setText(decimales.format(p3)+"%");
        
        //agregamos los usuarios a la tabla
        //mfc.abrirConexion();
        ArrayList<Jugador>listaJu = mfc.listaJugadores();
        //mfc.cerrarConexion();
        columnaUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        columnaPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        tablaUsuarios.getItems().addAll(listaJu);
        totalUsuarios.setText(""+listaJu.size());
        cargarPromedios();
        cargarRespuestas();
        
        
    }
    public void cargarRespuestas(){
        //mfc.abrirConexion();
        int respuestaNivel1 = mfc.respuestasCorrectas("nivel1");
        int respuestaNivel2 = mfc.respuestasCorrectas("nivel2");
        int respuestaNivel3 = mfc.respuestasCorrectas("nivel3");
        int respuestaNivel4 = mfc.respuestasCorrectas("nivel4");
        int respuestaNivel5 = mfc.respuestasCorrectas("nivel5");
        //mfc.cerrarConexion();
        
        int respuestaIncoNivel1 = totalTestMfc-respuestaNivel1;
        int respuestaIncoNivel2 = totalTestMfc-respuestaNivel2;
        int respuestaIncoNivel3 = totalTestMfc-respuestaNivel3;
        int respuestaIncoNivel4 = totalTestMfc-respuestaNivel4;
        int respuestaIncoNivel5 = totalTestMfc-respuestaNivel5;
        
        respuestaGanadoNivel1.setText(""+respuestaNivel1);
        respuestaPerdidoNivel1.setText(""+respuestaIncoNivel1);
        
        respuestaGanadoNivel2.setText(""+respuestaNivel2);
        respuestaPerdidoNivel2.setText(""+respuestaIncoNivel2);
        
        respuestaGanadoNivel3.setText(""+respuestaNivel3);
        respuestaPerdidoNivel3.setText(""+respuestaIncoNivel3);
        
        respuestaGanadoNivel4.setText(""+respuestaNivel4);
        respuestaPerdidoNivel4.setText(""+respuestaIncoNivel4);
        
        respuestaGanadoNivel5.setText(""+respuestaNivel5);
        respuestaPerdidoNivel5.setText(""+respuestaIncoNivel5);
    }
    public void cargarPromedios(){
        //mfc.abrirConexion();
        double promedioGanadoNive1=mfc.promediosNivel("nivel1");
        double promedioGanadoNive2=mfc.promediosNivel("nivel2");
        double promedioGanadoNive3=mfc.promediosNivel("nivel3");
        double promedioGanadoNive4=mfc.promediosNivel("nivel4");
        double promedioGanadoNive5=mfc.promediosNivel("nivel5");
        //mfc.cerrarConexion();
        double PromedioPerdidoNive1 = (1-promedioGanadoNive1);
        double PromedioPerdidoNive2 = (1-promedioGanadoNive2);
        double PromedioPerdidoNive3 = (1-promedioGanadoNive3);
        double PromedioPerdidoNive4 = (1-promedioGanadoNive4);
        double PromedioPerdidoNive5 = (1-promedioGanadoNive5);
        
        
        ganadoNivel1.setText(decimales.format(promedioGanadoNive1*100)+"%");
        perdidoNivel1.setText(decimales.format(PromedioPerdidoNive1*100)+"%");
        
        ganadoNivel2.setText(decimales.format(promedioGanadoNive2*100)+"%");
        perdidoNivel2.setText(decimales.format(PromedioPerdidoNive2*100)+"%");
        
        ganadoNivel3.setText(decimales.format(promedioGanadoNive3*100)+"%");
        perdidoNivel3.setText(decimales.format(PromedioPerdidoNive3*100)+"%");
        
        ganadoNivel4.setText(decimales.format(promedioGanadoNive4*100)+"%");
        perdidoNivel4.setText(decimales.format(PromedioPerdidoNive4*100)+"%");
        
        ganadoNivel5.setText(decimales.format(promedioGanadoNive5*100)+"%");
        perdidoNivel5.setText(decimales.format(PromedioPerdidoNive5*100)+"%");
    }

    @FXML
    private void pisoPregunta1(MouseEvent event) {
        contenedorPregunta.setDisable(false);
        contenedorPregunta.setVisible(true);
        contenedorPregunta.setText(listaPreguntas.get(0));
    }

    @FXML
    private void salioPregunta1(MouseEvent event) {
        contenedorPregunta.setDisable(true);
        contenedorPregunta.setVisible(false);
    }

    @FXML
    private void salioPregunta2(MouseEvent event) {
        contenedorPregunta.setDisable(true);
        contenedorPregunta.setVisible(false);
    }

    @FXML
    private void pisoPregunta2(MouseEvent event) {
        contenedorPregunta.setDisable(false);
        contenedorPregunta.setVisible(true);
        contenedorPregunta.setText(listaPreguntas.get(1));
    }

    @FXML
    private void salioPregunta3(MouseEvent event) {
        contenedorPregunta.setDisable(true);
        contenedorPregunta.setVisible(false);
    }

    @FXML
    private void pisoPregunta3(MouseEvent event) {
        contenedorPregunta.setDisable(false);
        contenedorPregunta.setVisible(true);
        contenedorPregunta.setText(listaPreguntas.get(2));
    }

    
    
}
