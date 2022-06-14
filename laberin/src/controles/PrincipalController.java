/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import modelo.Nivel;


/**
 * FXML Controller class
 *
 * @author santi
 */
public class PrincipalController implements Initializable{
    
    //la matriz del grid empieza desde la poscicion 1,1 columna 1 y fila 1
    
    @FXML
    private GridPane grid;
    @FXML
    private ImageView imgPacman;
    @FXML
    private ImageView imgObjetivo;
    @FXML
    private HBox movimientos;
    @FXML
    private Button iniciarMovimiento;
    
    private Button[][] boton=new Button[6][6];
    
    private int idColumnaPacman;
    private int idFilaPacman;
    private int idColumnaObjetivo;
    private int idFilaObjetivo;
    private boolean banderaDesborde = true;//bandera que mide el desborde al salirse de la matriz
    
    private Button pacmanAnterior;
    
    private int numeroNivel=0;
    
    
    private Nivel nivel = new Nivel();
    //int [][]matriz = nivel.getMatriz();
    private ArrayList<int[][]>listaNiveles = nivel.getListaNiveles();
    private ArrayList<String> listaMovimientos;
    
    
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgPacman.setFitHeight(80);
        imgPacman.setFitWidth(80);
        imgObjetivo.setFitHeight(80);
        imgObjetivo.setFitWidth(80);
            //mfc.setCo(this);
        iniciar(numeroNivel);
        
        
    }
   
    
    
    
    

    @FXML
    private void iniciarMovimiento(MouseEvent event) {
        try {
            recorrer();
            
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
    }

    @FXML
    private void movimientoArriba(MouseEvent event) {
        listaMovimientos.add("arriba");
        ImageView flecha = new ImageView(new Image("/img/flechaArriba.png"));
        flecha.setFitHeight(40);
        flecha.setFitWidth(40);
        //pacmanAnterior.setGraphic(null);
        movimientos.getChildren().add(flecha);
    }

    @FXML
    private void movimientoAbajo(MouseEvent event) {
        listaMovimientos.add("abajo");
        ImageView flecha = new ImageView(new Image("/img/flechaAbajo.png"));
        flecha.setFitHeight(40);
        flecha.setFitWidth(40);
        //pacmanAnterior.setGraphic(null);
        movimientos.getChildren().add(flecha);
    }

    @FXML
    private void movimientoIzquierda(MouseEvent event) {
        listaMovimientos.add("izquierda");
        ImageView flecha = new ImageView(new Image("/img/flechaIzquierda.png"));
        flecha.setFitHeight(40);
        flecha.setFitWidth(40);
        //pacmanAnterior.setGraphic(null);
        movimientos.getChildren().add(flecha);
    }

    @FXML
    private void movimientoDerecha(MouseEvent event) {
        listaMovimientos.add("derecha");
        ImageView flecha = new ImageView(new Image("/img/flechaDerecha.png"));
        flecha.setFitHeight(40);
        flecha.setFitWidth(40);
        //pacmanAnterior.setGraphic(null);
        movimientos.getChildren().add(flecha);
    }
    @FXML
    private void borrarSecuencia(MouseEvent event) {
        int cantidad=movimientos.getChildren().size();
        movimientos.getChildren().remove(cantidad-1);
        listaMovimientos.remove(cantidad-1);
    }

   public void recorrer() throws InterruptedException{
        iniciarMovimiento.setDisable(true);
        Task tarea = new Task<Void>(){
            @Override
            protected Void call() throws Exception {
               
                for (int i = 0; i < listaMovimientos.size(); i++) {
                    if(banderaDesborde){
                        Thread.sleep(1000);
                        pacmanAnterior.setStyle("-fx-background-color: red; ");
                        //movimiento arriba
                        if(listaMovimientos.get(i).equals("arriba")){

                            idFilaPacman--;
                            //Thread.sleep(3000);//espera 1000 = 1 segundo-- segundos para ejecutar la instruccion siguiente
                            Platform.runLater(()->{
                                try {
                                    pacmanAnterior.setGraphic(null);
                                    imgPacman.setImage(new Image("/img/pacmanArriba.png"));
                                    boton[idFilaPacman][idColumnaPacman].setGraphic(imgPacman);
                                    //boton[idFilaPacman][idColumnaPacman].setStyle("-fx-background-color: red; ");
                                    pacmanAnterior = boton[idFilaPacman][idColumnaPacman];
                                    //pacmanAnterior.setStyle("-fx-background-color: red; ");
                                } catch (Exception e) {
                                    banderaDesborde = false;
                                    System.out.println(e);
                                }



                            });

                        }
                        //movimiento derecha
                        if(listaMovimientos.get(i).equals("derecha")){
                            idColumnaPacman++;
                            Platform.runLater(()->{
                                try {
                                    pacmanAnterior.setGraphic(null);
                                    imgPacman.setImage(new Image("/img/pacmanDerecha.png"));
                                    boton[idFilaPacman][idColumnaPacman].setGraphic(imgPacman);
                                    pacmanAnterior = boton[idFilaPacman][idColumnaPacman];
                                    //pacmanAnterior.setStyle("-fx-background-color: red; ");
                                } catch (Exception e) {
                                    banderaDesborde = false;
                                    System.out.println(e);
                                }
                                

                            });


                        }
                        //movimiento abajo
                        if(listaMovimientos.get(i).equals("abajo")){
                            idFilaPacman++;
                            Platform.runLater(()->{
                                try {
                                    pacmanAnterior.setGraphic(null);
                                    imgPacman.setImage(new Image("/img/pacmanAbajo.png"));
                                    boton[idFilaPacman][idColumnaPacman].setGraphic(imgPacman);
                                    pacmanAnterior = boton[idFilaPacman][idColumnaPacman];
                                    //pacmanAnterior.setStyle("-fx-background-color: red; ");
                                } catch (Exception e) {
                                    banderaDesborde = false;
                                    System.out.println(e);
                                }
                                

                            });


                        }
                        //movimiento izquierda
                        if(listaMovimientos.get(i).equals("izquierda")){
                            idColumnaPacman--;
                            Platform.runLater(()->{
                                try {
                                    pacmanAnterior.setGraphic(null);
                                    imgPacman.setImage(new Image("/img/pacmanIzquierda.png"));
                                    boton[idFilaPacman][idColumnaPacman].setGraphic(imgPacman);
                                    pacmanAnterior = boton[idFilaPacman][idColumnaPacman];
                                    //pacmanAnterior.setStyle("-fx-background-color: red; ");
                                } catch (Exception e) {
                                    banderaDesborde = false;
                                    
                                }
                                

                            });

                        }
                    }else{
                        
                        break;
                    }
                }
                //System.out.println(idColumnaPacman+" "+idColumnaObjetivo+" "+idFilaPacman+" "+idFilaObjetivo);
                if(idColumnaPacman==idColumnaObjetivo && idFilaPacman==idFilaObjetivo){
                        //JOptionPane.showMessageDialog( null, "Gano" );
                        Thread.sleep(1000);
                        mfc.aumentarPunto();
                        mfc.guardarIntento(true);
                        //mfc.aumentarNivelesJugados();
                        //System.out.println(mfc.getJugador().getPuntos());
                        
                        
                    
                }else{
                    //JOptionPane.showMessageDialog( null, "Perdio" );
                    Thread.sleep(1000);
                    mfc.guardarIntento(false);
                    //mfc.aumentarNivelesJugados();
                     
                    
                }
                Platform.runLater(()->{
                    iniciarMovimiento.setDisable(false);
                    numeroNivel++;
                    iniciar(numeroNivel);
                });
                
                return null;
           
            }
           
            
        };
        //(new Thread(tarea)).start();
        Thread hilo = new Thread(tarea);
        hilo.setDaemon(true);
        hilo.start();
        
        
        
    }
    public boolean verificarLimites(int bandera){
        return bandera+1<grid.getRowConstraints().size();
    }
   public void abrirNivel(){
        mfc.getMain().abrirNivel();
    }
   
     public void iniciar(int banderaNivel){
        
        if(banderaNivel<5){
            imgPacman.setImage(new Image("/img/pacmanDerecha.png"));
            movimientos.getChildren().clear();
            listaMovimientos = new ArrayList<>();
            int [][]matriz = listaNiveles.get(banderaNivel);
        
            for (int fila = 0; fila <matriz.length; fila++) {
                for (int columna = 0; columna <matriz[fila].length; columna++) {
                    boton[fila][columna] = new Button();
                    boton[fila][columna].setMinWidth(100);
                    boton[fila][columna].setMinHeight(100);
                    boton[fila][columna].setFocusTraversable(false);
                    if(matriz[fila][columna]==1){
                        boton[fila][columna].setGraphic(imgPacman);
                        pacmanAnterior = boton[fila][columna];
                        idColumnaPacman = columna;
                        idFilaPacman = fila;
                    }
                    if(matriz[fila][columna]==2){
                        boton[fila][columna].setGraphic(imgObjetivo);
                        idColumnaObjetivo = columna;
                        idFilaObjetivo = fila;
                    }

                    grid.add(boton[fila][columna], columna+1, fila+1);
                    //System.out.println(GridPane.getColumnIndex(boton[fila][columna]));


                    //set grid width
                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMaxWidth(Region.USE_PREF_SIZE);

                    //set grid height
                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMaxHeight(Region.USE_PREF_SIZE);

                    //GridPane.setMargin(boton[i][j], new Insets(0));//tamaño de margen
                }
            }
        }else{
            //mfc.abrirConexion();
            mfc.claseBd();
            //mfc.cerrarConexion();
            abrirHistorial();
        }
        
    }
    public void abrirHistorial(){
        mfc.getMain().abrirHistorial();
    }

    
}
