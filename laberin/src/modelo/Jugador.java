/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author santi
 */
public class Jugador {
    private String username;
    private int puntos;
    private boolean nivel1;
    private boolean nivel2;
    private boolean nivel3;
    private boolean nivel4;
    private boolean nivel5;
    private int bandera=1;
    
    public Jugador(){
        
    }
    public void guardarIntento(boolean actual){
        if(bandera==1)nivel1=actual;
        if(bandera==2)nivel2=actual;
        if(bandera==3)nivel3=actual;
        if(bandera==4)nivel4=actual;
        if(bandera==5)nivel5=actual;
        bandera++;
    }
    public void aumentarPunto(){
        puntos++;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isNivel1() {
        return nivel1;
    }

    public void setNivel1(boolean nivel1) {
        this.nivel1 = nivel1;
    }

    public boolean isNivel2() {
        return nivel2;
    }

    public void setNivel2(boolean nivel2) {
        this.nivel2 = nivel2;
    }

    public boolean isNivel3() {
        return nivel3;
    }

    public void setNivel3(boolean nivel3) {
        this.nivel3 = nivel3;
    }

    public boolean isNivel4() {
        return nivel4;
    }

    public void setNivel4(boolean nivel4) {
        this.nivel4 = nivel4;
    }

    public boolean isNivel5() {
        return nivel5;
    }

    public void setNivel5(boolean nivel5) {
        this.nivel5 = nivel5;
    }
    
}
