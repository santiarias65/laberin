package controles;


import apk.Aplicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jugador;

public class ModelFactoryController{
        private Aplicacion main;
        //SELECT MAX(id) AS id FROM jugadores; consulta da el ultimo id
        private Jugador jugador = new Jugador();
        private ArrayList<Jugador>listaTop= new ArrayList<>();
	private Connection con;
        private Statement stmt;
        private ResultSet rs;
        
        
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
            abrirConexion();
            //System.out.println("controles.ModelFactoryController.<init>()");
	}
        
        public void aumentarPunto(){
            getJugador().aumentarPunto();
        }
        
        public void abrirConexion(){
            try
            {   //servidor //usuario //clave
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(
                        "jdbc:mysql://sql10.freesqldatabase.com","sql10499394","Z31EfDb7j1");
                stmt=con.createStatement();  
                rs=stmt.executeQuery("use sql10499394;");
                /*Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(
                        "jdbc:mysql://localhost","root","");
                stmt=con.createStatement();  
                rs=stmt.executeQuery("use laberin;");*/
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        public void cerrarConexion(){
            try {
                //System.out.println("DESCONECTADO");
                stmt.close();
                con.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public boolean abrirUsuario(String username){
            try {
                //abrirConexion();
                String query = "INSERT INTO jugadores (username) values ('"+username+"')";
                stmt.executeUpdate(query);
                bdClase(username);
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
    }
    public void guardarIntento(boolean actual){
        jugador.guardarIntento(actual);
    }
    //ingresa los datos de la base de datos a una instancia Jugador
    public void bdClase(String username){
            try {
                jugador.setUsername(username);
                int puntos;
                rs = stmt.executeQuery("SELECT * FROM `jugadores` WHERE username ='"+username+"'");
                while(rs.next()){
                 //System.out.println(rs.getString(1));
                 jugador.setPuntos(rs.getInt("puntos"));
                 jugador.setNivel1(rs.getBoolean("nivel1"));
                 jugador.setNivel2(rs.getBoolean("nivel2"));
                 jugador.setNivel3(rs.getBoolean("nivel3"));
                 jugador.setNivel4(rs.getBoolean("nivel4"));
                 jugador.setNivel5(rs.getBoolean("nivel5"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //mandar de la clase a la base de datos
    public void claseBd(){
            try {
                String username = jugador.getUsername();
                int puntos = jugador.getPuntos();
                int nivel1 = jugador.isNivel1()?1:0;
                int nivel2 = jugador.isNivel2()?1:0;
                int nivel3 = jugador.isNivel3()?1:0;
                int nivel4 = jugador.isNivel4()?1:0;
                int nivel5 = jugador.isNivel5()?1:0;
                /*boolean nivel2 = jugador.isNivel2();
                boolean nivel3 = jugador.isNivel3();
                boolean nivel4 = jugador.isNivel4();
                boolean nivel5 = jugador.isNivel5();*/
                
                String query = "UPDATE `jugadores` SET `puntos`='"+puntos+"',`nivel1`='"+nivel1+"',`nivel2`='"+nivel2+"',`nivel3`='"+nivel3+"',`nivel4`='"+nivel4+"',`nivel5`='"+nivel5+"' WHERE username ='"+username+"'";
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //envia la calificacion de la encuesta a la bd
    public void encuesta(int c1,int c2,int c3){
            try {
                String username=jugador.getUsername();
                String query ="INSERT INTO `encuesta`(`username`, `pregunta1`, `pregunta2`, `pregunta3`) values ('"+username+"','"+c1+"','"+c2+"','"+c3+"')";
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //traer las preguntas de la encuesta
    public ArrayList<String> listaPreguntas(){
        ArrayList<String>preguntas = new ArrayList<>();
            try {
                String query = "SELECT p.pregunta FROM `pregunta`p";
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    preguntas.add(rs.getString(1));
                    
                }   } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return preguntas;
    }
    public Double listaPromedioEncuesta(String pregunta){
        Double promedio = 0.0;
            try {
                
                String query = "SELECT AVG("+pregunta+") FROM `encuesta`";
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    promedio = rs.getDouble(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return promedio;
    }
    public ArrayList<Jugador>listaJugadores(){
        ArrayList<Jugador>listaJu = new ArrayList<>();
            try {
                
                String query = "SELECT j.username,j.puntos FROM `jugadores`j ORDER BY j.puntos DESC";
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    Jugador ju = new Jugador();
                    ju.setUsername(rs.getString("username"));
                    ju.setPuntos(rs.getInt("puntos"));
                    listaJu.add(ju);
                }   } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return listaJu;
    }
    //tenemos los top por los puntajes
    public void top(){
            try {
                rs = stmt.executeQuery("SELECT * FROM `jugadores` WHERE id<11 ORDER BY puntos DESC");
                while(rs.next()){
                    Jugador clasi = new Jugador();
                    clasi.setUsername(rs.getString("username"));
                    clasi.setPuntos(rs.getInt("puntos"));
                    listaTop.add(clasi);
                }   } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //promedios segun nivel ganado
    public double promediosNivel(String nivel){
        try {
            String query ="SELECT AVG("+nivel+") FROM `jugadores`";
            rs = stmt.executeQuery(query);
            rs.next();
            return rs.getDouble(1);   
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //respuestas correctas segun nivel
    public int respuestasCorrectas(String tabla){
            try {
                String query = "SELECT COUNT("+tabla+") FROM `jugadores` WHERE "+tabla+"=1";
                rs = stmt.executeQuery(query);
                rs.next();
                return rs.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
    }
    //total test
    public int totalTest(){
            try {
                String query="SELECT COUNT(*) FROM `jugadores`";
                rs = stmt.executeQuery(query);
                rs.next();
                return rs.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }

    public ArrayList<Jugador> getListaTop() {
        return listaTop;
    }

    public void setListaTop(ArrayList<Jugador> listaTop) {
        this.listaTop = listaTop;
    }
    
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Aplicacion getMain() {
        return main;
    }

    public void setMain(Aplicacion main) {
        this.main = main;
    }

    
}
