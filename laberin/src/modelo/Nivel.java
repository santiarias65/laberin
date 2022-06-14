/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author santi
 */
public class Nivel {
    ArrayList<int[][]> listaNiveles = new ArrayList<>();
    int[][] matriz;
    
    
    public Nivel(){
        //crearNiveles();
        nivelesQuemados();
    }

    public ArrayList<int[][]> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(ArrayList<int[][]> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }
    
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public void nivelesQuemados(){
        int[][] m1 = {
            {0,0,0,0,0,0},
            {0,1,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,2,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},   
        };
        listaNiveles.add(m1);
        
        int[][] m2 = {
            {0,0,0,0,0,0},
            {0,0,2,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,1,0,0},   
        };
        listaNiveles.add(m2);
        
        int[][] m3 = {
            {0,1,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,2,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},   
        };
        listaNiveles.add(m3);
        
        int[][] m4 = {
            {0,0,0,0,2,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,1,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},   
        };
        listaNiveles.add(m4);
        
        int[][] m5 = {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,2,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,1},
            {0,0,0,0,0,0},   
        };
        listaNiveles.add(m5);
    }
    public void crearNiveles(){
        for (int p = 0; p < 6; p++) {
        
            boolean bandera = true;
            Random random = new Random();
            int filaAleatorio = random.nextInt(6);
            int columnaAleatorio =random.nextInt(6);
            int filaAleatorioObjetivo = random.nextInt(6);
            int columnaAleatorioObjetivo =random.nextInt(6);
            int[][]m = new int[6][6];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    m[i][j] = 0;
                }
            }
            while (bandera) {            
                if(filaAleatorio!=filaAleatorioObjetivo && columnaAleatorio!=columnaAleatorioObjetivo){
                    m[filaAleatorio][columnaAleatorio]=1;
                    m[filaAleatorioObjetivo][columnaAleatorioObjetivo]=2;
                    bandera = false;
                }
            }
            //System.out.println("modelo.Nivel.crearNiveles()");
            //matriz = m;
            
            listaNiveles.add(m);
        }
        //System.out.println("salio");
    }
    
}
