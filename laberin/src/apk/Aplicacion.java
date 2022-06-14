/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apk;

import controles.LoginController;
import controles.ModelFactoryController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author santi
 */
public class Aplicacion extends Application {
        private ModelFactoryController mfc = ModelFactoryController.getInstance();
        private Stage stagePrincipal;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//primaryStage.setFullScreen(true);
		mfc.setMain(this);
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/LoginPlay.fxml"));
                Parent root = loader.load();
                         
                Scene scene = new Scene(root);
                //Stage stage = new Stage();
                stagePrincipal = primaryStage;
                stagePrincipal.setScene(scene);
                stagePrincipal.getIcons().add(new Image("/img/pacmanDerecha.png"));
                stagePrincipal.show();
            } catch (Exception e) {
                    System.out.println(e);
            }
                
	}
        public void abrirReportes(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Reportes.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                //Stage stage = new Stage();

                stagePrincipal.setScene(scene);
                stagePrincipal.show();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void abrirPrincipal(){
            try {
                    stagePrincipal.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Principal.fxml"));
                    Parent root = loader.load();
                            
                    Scene scene = new Scene(root);
                            
                    stagePrincipal.setScene(scene);
                    stagePrincipal.show();
                                                        
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        public void abrirHistorial(){
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Historial.fxml"));

                    Parent root = loader.load();
                    //System.out.println("paso");

                    //PrincipalController control = loader.getController();
                    Scene scene = new Scene(root);

                    stagePrincipal.setScene(scene);
                    stagePrincipal.show();

                } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        public void abrirNivel(){
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Principal.fxml"));

                    Parent root = loader.load();
                    //System.out.println("paso");

                    //PrincipalController control = loader.getController();
                    Scene scene = new Scene(root);

                    stagePrincipal.setScene(scene);
                    stagePrincipal.show();

                } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        public void abrirEncuesta(){
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Encuesta.fxml"));

                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stagePrincipal.setScene(scene);
                    stagePrincipal.show();

                } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        public void abrirDevolver(){
               stagePrincipal.close();
        }
	public static void main(String[] args) {
		launch(args);
	}

}