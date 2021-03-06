/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;
import serviciorestaurante.ServicioRestaurant;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Ivan
 */
public class Cocinero extends Thread{
    protected Semaphore SE;
    protected Semaphore SP;
    protected Semaphore SC;
    protected long tiempo; //el tiempo que le toma producir
    protected double taza; //taza de produccion, ej: 1 por hora y eso
    protected int entra; //posicion de entrada
    protected int sale; //posicion cuando sale
    protected ServicioInterfaz servicio;
    
    public Cocinero(Semaphore SE, Semaphore SP, Semaphore SC, long tiempo,double taza, int entra, int sale, ServicioInterfaz servicio){
        this.SE = SE;
        this.SP = SP;
        this.SC = SC;
        this.tiempo = tiempo;
        this.taza = taza;
        this.entra = entra;
        this.sale = sale;
        this.servicio = servicio;
    }

    public Semaphore getSE() {
        return SE;
    }

    public Semaphore getSP() {
        return SP;
    }

    public Semaphore getSC() {
        return SC;
    }

    public long getTiempo() {
        return tiempo;
    }

    public int getEntra() {
        return entra;
    }

    public int getSale() {
        return sale;
    }

    public ServicioInterfaz getInterfaz() {
        return servicio;
    }

    public void setSE(Semaphore SE) {
        this.SE = SE;
    }

    public void setSP(Semaphore SP) {
        this.SP = SP;
    }

    public void setSC(Semaphore SC) {
        this.SC = SC;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public void setEntra(int entra) {
        this.entra = entra;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public void setInterfaz(ServicioInterfaz interfaz) {
        this.servicio = interfaz;
    }
    
    
            
            
}
