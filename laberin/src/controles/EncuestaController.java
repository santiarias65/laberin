/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class EncuestaController implements Initializable {
    @FXML
    private Text pregunta;
    @FXML
    private ImageView imgEstrellaUno;
    @FXML
    private ImageView imgEstrellaDos;
    @FXML
    private ImageView imgEstrellaTres;
    @FXML
    private ImageView imgEstrellaCuatro;
    @FXML
    private ImageView imgEstrellaCinco;
    @FXML
    private Button botonCalificar;
    @FXML
    private Button botonEncuesta;
    @FXML
    private HBox estrellas;
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private boolean banderaSeleccion = false;
    private int calificacion;
    private int calificacion1;
    private int calificacion2;
    private int calificacion3;
    private ArrayList<String>listaPreguntas;
    private int banderaEnunciado=0;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //mfc.abrirConexion();
        listaPreguntas = mfc.listaPreguntas();
        //mfc.cerrarConexion();
        
        
    }
    public void puntuar(){
        if(banderaEnunciado==1)calificacion1=calificacion;
        if(banderaEnunciado==2)calificacion2=calificacion;
        if(banderaEnunciado==3)calificacion3=calificacion;
    }
    public void iniciar(){
        if(banderaEnunciado<3){
            
            pregunta.setText(listaPreguntas.get(banderaEnunciado));
            banderaEnunciado++;
        }else{
            //mfc.abrirConexion();
            mfc.encuesta(calificacion1,calificacion2,calificacion3);
            mfc.cerrarConexion();
            JOptionPane.showMessageDialog( null, "Gracias por resolver el Test y la encuesta Tus datos fueron Registrados");
            mfc.getMain().abrirDevolver();
        }
    }
    @FXML
    private void unaEstrella(MouseEvent event) {
        
        reiniciarImagen();
        imgEstrellaUno.setImage(new Image("/img/estrellaColor.png"));
        calificacion = 1;
        puntuar();
        
    }

    @FXML
    private void dosEstrella(MouseEvent event) {
        banderaSeleccion=true;
        reiniciarImagen();
        imgEstrellaUno.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaDos.setImage(new Image("/img/estrellaColor.png"));
        calificacion = 2;
        puntuar();
    }

    @FXML
    private void tresEstrella(MouseEvent event) {
        banderaSeleccion=true;
        reiniciarImagen();
        imgEstrellaUno.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaDos.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaTres.setImage(new Image("/img/estrellaColor.png"));
        calificacion = 3;
        puntuar();
    }

    @FXML
    private void cuatroEstrella(MouseEvent event) {
        banderaSeleccion=true;
        reiniciarImagen();
        imgEstrellaUno.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaDos.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaTres.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaCuatro.setImage(new Image("/img/estrellaColor.png"));
        calificacion = 4;
        puntuar();
    }

    @FXML
    private void cincoEstrella(MouseEvent event) {
        banderaSeleccion=true;
        reiniciarImagen();
        imgEstrellaUno.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaDos.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaTres.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaCuatro.setImage(new Image("/img/estrellaColor.png"));
        imgEstrellaCinco.setImage(new Image("/img/estrellaColor.png"));
        calificacion = 5;
        puntuar();
    }
    public void reiniciarImagen(){
        
        imgEstrellaUno.setImage(new Image("/img/estrella.png"));
        imgEstrellaDos.setImage(new Image("/img/estrella.png"));
        imgEstrellaTres.setImage(new Image("/img/estrella.png"));
        imgEstrellaCuatro.setImage(new Image("/img/estrella.png"));
        imgEstrellaCinco.setImage(new Image("/img/estrella.png"));
    }

    @FXML
    private void calificar(MouseEvent event) {
        //mfc.abrirConexion();
        //mfc.encuesta(calificacion);
        //mfc.cerrarConexion();
        iniciar();
        reiniciarImagen();
    }

    @FXML
    private void iniciarEncuesta(MouseEvent event) {
        //vuelvo el boton de inicar encuesta inservible
        botonEncuesta.setDisable(true);
        botonEncuesta.setVisible(false);
        
        //activo el boton para dar las calificaciones
        botonCalificar.setDisable(false);
        botonCalificar.setVisible(true);
        
        //activo las estrellas
        estrellas.setDisable(false);
        iniciar();
        
    }
    public void abrirLogin(){
        mfc.getMain().abrirDevolver();
    }
}
