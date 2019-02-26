/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static serviciorestaurante.ServicioRestaurant.CPostres;
import serviciorestaurante.ServicioInterfaz;

/**
 *
 * @author Ivan
 */
public class CPostre extends Cocinero{
    private int mesonPostre[];

    public CPostre(int mesonPostre[], Semaphore SE, Semaphore SP, Semaphore SC, long tiempo, int entra, int sale, ServicioInterfaz interfaz) {
        super(SE, SP, SC, tiempo, 0.30, entra, sale, interfaz);
        this.mesonPostre = mesonPostre;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                SP.acquire(1);
                SE.acquire(1);
                cocinar();
                SE.release();
                SC.release();
                CPostre.sleep((long)(1000*tiempo*taza));
            } catch (InterruptedException ex) {
                Logger.getLogger(CPostre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cocinar(){
        mesonPostre[entra]=1; //se cocino 1 y se pone en su meson
        entra = (entra+1)%mesonPostre.length; //10 puestos del meson
        int nuevo = Integer.parseInt(this.servicio.getMesonPostres().getText())+1;
        this.servicio.getMesonPostres().setText(Integer.toString(nuevo));
    }
    
    public void contratar(){ //meter cocineros, la cantidad vendra de la interfaz
            boolean contratado = false;
            for (int i = 0; i<ServicioRestaurant.maxCantPostre;i++){
                if(CPostres[i] == null && !contratado){
                    CPostres[i] = new CPostre(mesonPostre, SE, SP, SC,tiempo, entra, sale, servicio);
                    contratado = true;
                    CPostres[i].start();
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosPostres().getText())+1;
                    this.servicio.getCocinerosPostres().setText(Integer.toString(nuevo));
                }
                else if(contratado){
                    break;
                }
            }
    }
    public void despedir(){
            boolean despedido = false;
            for (int i = 0; i<ServicioRestaurant.maxCantPostre;i++){
                if(CPostres[i] != null && !despedido){
                    CPostres[i] = null;
                    despedido = true;
                    int nuevo = Integer.parseInt(this.servicio.getCocinerosPostres().getText())-1;
                    this.servicio.getCocinerosPostres().setText(Integer.toString(nuevo));
                }
                else if(despedido){
                    break;
                }
            }
    }

    public int[] getMesonPostre() {
        return mesonPostre;
    }

    public void setMesonPostre(int[] mesonPostre) {
        this.mesonPostre = mesonPostre;
    }
}
