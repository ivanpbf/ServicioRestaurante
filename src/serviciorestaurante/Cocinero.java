/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;
import serviciorestaurante.Servicio;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Ivan
 */
public class Cocinero extends Thread{
    protected Semaphore SE;
    protected Semaphore SP;
    protected Semaphore SC;
    protected double tiempo; //el tiempo que le toma producir
    protected int entra; //posicion de entrada
    protected int sale; //posicion cuando sale
    protected Servicio interfaz;
    
    public Cocinero(Semaphore SE, Semaphore SP, Semaphore SC, double tiempo, int entra, int sale, Servicio interfaz){
        this.SE = SE;
        this.SP = SP;
        this.SC = SC;
        this.tiempo = tiempo;
        this.entra = entra;
        this.sale = sale;
        this.interfaz = interfaz;
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

    public double getTiempo() {
        return tiempo;
    }

    public int getEntra() {
        return entra;
    }

    public int getSale() {
        return sale;
    }

    public Servicio getInterfaz() {
        return interfaz;
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

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public void setEntra(int entra) {
        this.entra = entra;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public void setInterfaz(Servicio interfaz) {
        this.interfaz = interfaz;
    }
    
    
            
            
}
