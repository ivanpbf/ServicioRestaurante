/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import serviciorestaurante.Servicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CEntrada extends Cocinero{
    private int mesonEntradas[];
    private boolean ejecutar = true;
    private boolean pausar = false;

    public CEntrada(int mesonEntradas[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, 0.25, 1, entra, sale, interfaz);
        //0.25 es el tiempo que le toma producir [1] 
        this.mesonEntradas = mesonEntradas;
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
                CEntrada.sleep((long)(1000*getTiempo()));
                synchronized(this){
                    if (pausar)
                        this.wait();     
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonEntradas[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%20; //20 puestos del meson
        //cambiar en interfaz**
    }
    
    //despedir y contratar iran aca
    

    public int[] getMesonEntradas() {
        return mesonEntradas;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonEntradas = mesonEntradas;
    }
    
    
    
}
