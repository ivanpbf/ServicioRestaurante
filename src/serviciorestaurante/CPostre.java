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
public class CPostre extends Cocinero{
    private int mesonPostre[];
    private boolean ejecutar = true;
    private boolean pausar = false;

    public CPostre(int mesonPostre[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, 0.30, 1, entra, sale, interfaz);
        this.mesonPostre = mesonPostre;
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
                CPostre.sleep((long)(1000*getTiempo()));
                synchronized(this){
                    if (pausar)
                        this.wait();     
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CPostre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonPostre[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%10; //10 puestos del meson
        //cambiar en interfaz**
    }
    
    

    public int[] getMesonPostre() {
        return mesonPostre;
    }

    public void setMesonPostre(int[] mesonPostre) {
        this.mesonPostre = mesonPostre;
    }
}
