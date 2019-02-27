/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static serviciorestaurante.ServicioRestaurant.CPlato;
import serviciorestaurante.ServicioInterfaz;

/**
 *
 * @author Ivan
 */
public class CPlatoFuerte extends Cocinero{
    private int[] mesonPlatoFuerte;
    volatile boolean ejecutar;

    public CPlatoFuerte(int mesonPlatoFuerte[], Semaphore SE, Semaphore SP, Semaphore SC,long tiempo, int entra, int sale, ServicioInterfaz interfaz) {
        super(SE, SP, SC, tiempo, 0.33, entra, sale, interfaz);
        this.mesonPlatoFuerte = mesonPlatoFuerte;
        ejecutar = true;
    }
    
    @Override
    public void run() {
        while(ejecutar){
            try {
                this.SP.acquire(1);
                this.SE.acquire(1);
                cocinar();
                this.SE.release();
                this.SC.release();
                CPlatoFuerte.sleep((long)(1000*tiempo*taza)); //verificar esto
            } catch (InterruptedException ex) {
                Logger.getLogger(CPlatoFuerte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonPlatoFuerte[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%mesonPlatoFuerte.length; //30 puestos del meson
        
        int nuevo = Integer.parseInt(this.servicio.getMesonPlatos().getText())+1;
        this.servicio.getMesonPlatos().setText(Integer.toString(nuevo));
    }
    
    public void contratar(){ //meter cocineros, la cantidad vendra de la interfaz
            boolean contratado = false;
            for (int i = 0; i<ServicioRestaurant.maxCantPF;i++){
                if(CPlato[i] == null && !contratado){
                    CPlato[i] = new CPlatoFuerte(mesonPlatoFuerte, SE, SP, SC,tiempo, entra, sale, servicio);
                    CPlato[i].ejecutar = true;
                    CPlato[i].start();
                    contratado = true;
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosPlatos().getText())+1;
                    this.servicio.getCocinerosPlatos().setText(Integer.toString(nuevo));
                }
                else if(contratado){
                    break;
                }
            }
    }
    
    public void despedir(){ //despedir, cantidad vendra de interfaz
            boolean despedido = false;
            for (int i = 0; i<ServicioRestaurant.maxCantPF;i++){
                if(CPlato[i] != null && !despedido){
                    CPlato[i].ejecutar = false;
                    CPlato[i] = null;
                    despedido = true;
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosPlatos().getText())-1;
                    this.servicio.getCocinerosPlatos().setText(Integer.toString(nuevo));
                }
                else if(despedido){
                    break;
                }
            }
    }
    

    public int[] getMesonEntradas() {
        return mesonPlatoFuerte;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonPlatoFuerte = mesonEntradas;
    }
}
