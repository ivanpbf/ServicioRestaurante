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
    volatile boolean ejecutar; //esto lo usamos para que al despedir o contratar lo pongamos en ejecucion

    public CEntrada(int mesonEntradas[], Semaphore SE, Semaphore SP, Semaphore SC, long tiempo, int entra, int sale, ServicioInterfaz interfaz) {
        super(SE, SP, SC, tiempo, 0.25, entra, sale, interfaz); //0.25 es la taza
        //0.25 es el tiempo que le toma producir [1] 
        this.mesonEntradas = mesonEntradas;
        ejecutar = true;
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
                CEntrada.sleep((long)(tiempo*taza*1000)); //esto lo verificamos con la interfaz
            } catch (InterruptedException ex) {
                Logger.getLogger(CEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonEntradas[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%mesonEntradas.length; //20 puestos del meson
        
        int nuevo = Integer.parseInt(this.servicio.getMesonEntradas().getText())+1;
        this.servicio.getMesonEntradas().setText(Integer.toString(nuevo));
    }
    
    //despedir y contratar iran aca
    public void contratar(){ //meter cocineros, la cantidad vendra de la interfaz
            boolean contratado = false;
            for (int i = 0; i<ServicioRestaurant.maxCantEntrada;i++){
                if(CEntradas[i] == null && !contratado){
                    CEntradas[i] = new CEntrada(mesonEntradas, SE, SP, SC,tiempo, entra, sale, servicio);
                    CEntradas[i].ejecutar = true;
                    CEntradas[i].start();
                    contratado = true;
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosEntradas().getText())+1;
                    this.servicio.getCocinerosEntradas().setText(Integer.toString(nuevo));
                }
                else if(contratado){
                    break;
                }
            }
    }
    
    public void despedir(){
            boolean despedido = false;
            for (int i = 0; i<ServicioRestaurant.maxCantEntrada;i++){
                if(CEntradas[i] != null && !despedido){
                    CEntradas[i].ejecutar = false;
                    CEntradas[i] = null;
                    despedido = true;
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosEntradas().getText())-1;
                    this.servicio.getCocinerosEntradas().setText(Integer.toString(nuevo));
                }
                else if(despedido){
                    break;
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
