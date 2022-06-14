/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class HistorialController implements Initializable {

    @FXML
    private Label labelNivel1;
    @FXML
    private Label labelNivel2;
    @FXML
    private Label labelNivel3;
    @FXML
    private Label labelNivel4;
    @FXML
    private Label labelNivel5;
    @FXML
    private Label labelPuntos;
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    @FXML
    private Button botonSiguiente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Jugador jugador = mfc.getJugador();
        if(jugador.isNivel1()){
            labelNivel1.setText("GANADO");
            labelNivel1.setTextFill(Color.GREEN);
        }else{
            labelNivel1.setText("PERDIDO");
            labelNivel1.setTextFill(Color.RED);
        }
        if(jugador.isNivel2()){
            labelNivel2.setText("GANADO");
            labelNivel2.setTextFill(Color.GREEN);
        }else{
            labelNivel2.setText("PERDIDO");
            labelNivel2.setTextFill(Color.RED);
        }
        
        if(jugador.isNivel3()){
            labelNivel3.setText("GANADO");
            labelNivel3.setTextFill(Color.GREEN);
        }else{
            labelNivel3.setText("PERDIDO");
            labelNivel3.setTextFill(Color.RED);
        }
        
        if(jugador.isNivel4()){
            labelNivel4.setText("GANADO");
            labelNivel4.setTextFill(Color.GREEN);
        }else{
            labelNivel4.setText("PERDIDO");
            labelNivel4.setTextFill(Color.RED);
        }
        
        if(jugador.isNivel5()){
            labelNivel5.setText("GANADO");
            labelNivel5.setTextFill(Color.GREEN);
        }else{
            labelNivel5.setText("PERDIDO");
            labelNivel5.setTextFill(Color.RED);
        }
        
        labelPuntos.setText(""+jugador.getPuntos());
    }    
   
    @FXML
    private void siguiente(MouseEvent event) {
        mfc.getMain().abrirEncuesta();
    }
}
