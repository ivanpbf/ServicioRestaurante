/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import serviciorestaurante.ServicioInterfaz;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static serviciorestaurante.ServicioRestaurant.CEntradas;


public class CEntrada extends Cocinero{
    private int mesonEntradas[];
    private boolean ejecutar = true;

    public CEntrada(int mesonEntradas[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, ServicioInterfaz interfaz) {
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
                CEntrada.sleep((long)(1000*getTiempo())); //esto lo verificamos con la interfaz
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
    public void contratar(int cant){ //meter cocineros, la cantidad vendra de la interfaz
        for (int j = 0; j < cant; j++){
            boolean contratado = false;
            for (int i = 0; i<3;i++){
                if(CEntradas[i] == null && !contratado){
                    CEntradas[i] = new CEntrada(mesonEntradas, SE, SP, SC, entra, sale, servicio);
                    CEntradas[i].start();
                    contratado = true;
                    //cambia en la interfaz
                }
                else if(contratado){
                    break;
                }
            }
        }
    }
    
    public void despedir(int cant){
        for (int j = 0; j < cant; j++){
            boolean despedido = false;
            for (int i = 0; i<3;i++){
                if(CEntradas[i] == null && !despedido){
                    CEntradas[i].ejecutar = false;
                    CEntradas[i] = null;
                    despedido = true;
                    //cambia en la interfaz
                }
                else if(despedido){
                    break;
                }
            }
        }
    }

    public int[] getMesonEntradas() {
        return mesonEntradas;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonEntradas = mesonEntradas;
    }
    
    
    
}
