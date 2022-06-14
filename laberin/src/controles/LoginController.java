/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField textoNombre;
    @FXML
    private Button botonJugar;
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*try {
            ModelFactoryController mfc = ModelFactoryController.getInstance();
            mfc.abrirConexion();
            String query = "INSERT INTO prueba (nombre) values ('valen')";
            mfc.getStmt().execute(query);
            mfc.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
        
    }    

    @FXML
    private void jugar(MouseEvent event) {
        if(textoNombre.getText().equals("")){
            JOptionPane.showMessageDialog( null, "Por Favor Ingrese un Username" );
        }else{
            if(textoNombre.getText().charAt(0) ==' '){
                JOptionPane.showMessageDialog( null, "No puede empezar su Username con un espacio" );
            }else{
                
                    //mfc.abrirConexion();
                    if(mfc.abrirUsuario(textoNombre.getText())){
                        mfc.getMain().abrirPrincipal();

                }else JOptionPane.showMessageDialog( null, "El username ya se encuentra en uso\nPor favor Escoja otro" );
            }
        }
        
        
    }

    @FXML
    private void abrirReportes(ActionEvent event) {
        mfc.getMain().abrirReportes();
    }
    
}
