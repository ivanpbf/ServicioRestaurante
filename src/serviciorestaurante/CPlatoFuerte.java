/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class CPlatoFuerte extends Cocinero{
    private int[] mesonPlatoFuerte;
    private boolean ejecutar = true;

    public CPlatoFuerte(int mesonPlatoFuerte[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, 0.33, 1, entra, sale, interfaz);
        this.mesonPlatoFuerte = mesonPlatoFuerte;
    }
    
    @Override
    public void run() {
        while(ejecutar){
            try {
                SP.acquire(1);
                SE.acquire(1);
                cocinar();
                SE.release();
                SC.release();
                CPlatoFuerte.sleep((long)(1000*getTiempo()));
            } catch (InterruptedException ex) {
                Logger.getLogger(CPlatoFuerte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonPlatoFuerte[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%30; //30 puestos del meson
        //cambiar en interfaz**
    }
    

    public int[] getMesonEntradas() {
        return mesonPlatoFuerte;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonPlatoFuerte = mesonEntradas;
    }
}
