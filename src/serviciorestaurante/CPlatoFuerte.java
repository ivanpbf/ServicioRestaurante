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
    private boolean ejecutar = true;

    public CPlatoFuerte(int mesonPlatoFuerte[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, ServicioInterfaz interfaz) {
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
        int nuevo = Integer.parseInt(this.servicio.getMesonPlatos().getText())+1;
        this.servicio.getMesonPlatos().setText(Integer.toString(nuevo));
    }
    
    public void contratar(int cant){ //meter cocineros, la cantidad vendra de la interfaz
        for (int j = 0; j < cant; j++){
            boolean contratado = false;
            for (int i = 0; i<4;i++){
                if(CPlato[i] == null && !contratado){
                    CPlato[i] = new CPlatoFuerte(mesonPlatoFuerte, SE, SP, SC, entra, sale, servicio);
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
    }
    
    public void despedir(int cant){ //despedir, cantidad vendra de interfaz
        for (int j = 0; j < cant; j++){
            boolean despedido = false;
            for (int i = 0; i<4;i++){
                if(CPlato[i] == null && !despedido){
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
    }
    

    public int[] getMesonEntradas() {
        return mesonPlatoFuerte;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonPlatoFuerte = mesonEntradas;
    }
}
