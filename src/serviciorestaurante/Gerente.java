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
public class Gerente extends Thread{
    private int mesonComida[];
    private Semaphore SEComida;
    private Semaphore SPComida;
    private Semaphore SCComida;
    private Semaphore SEJefe;
    private int entraC; //entra comida
    private int saleC;
    private JefeMesoneros jefem;
    private ServicioInterfaz servicio;

    public Gerente(int[] mesonComida, Semaphore SEComida, Semaphore SPComida, Semaphore SCComida, Semaphore SEJefe, int entraC, int saleC, JefeMesoneros jefem,ServicioInterfaz servicio) {
        this.mesonComida = mesonComida;
        this.SEComida = SEComida;
        this.SPComida = SPComida;
        this.SCComida = SCComida;
        this.SEJefe = SEJefe;
        this.entraC = entraC;
        this.saleC = saleC;
        this.jefem = jefem;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        while(true){
            try {
                SEJefe.acquire(1);
                if(getJefem().getContador() == 0){ //la hora de cerrar
                    cerrar();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void cerrar(){
        
    }
    public int getEntraC() {
        return entraC;
    }

    public JefeMesoneros getJefem() {
        return jefem;
    }

    public Semaphore getSCComida() {
        return SCComida;
    }

    public Semaphore getSEComida() {
        return SEComida;
    }

    public Semaphore getSEJefe() {
        return SEJefe;
    }

    public Semaphore getSPComida() {
        return SPComida;
    }

    public int getSaleC() {
        return saleC;
    }

    public ServicioInterfaz getServicio() {
        return servicio;
    }

    public void setEntraC(int entraC) {
        this.entraC = entraC;
    }

    public void setJefem(JefeMesoneros jefem) {
        this.jefem = jefem;
    }

    public void setMesonComida(int[] mesonComida) {
        this.mesonComida = mesonComida;
    }

    public void setSCComida(Semaphore SCComida) {
        this.SCComida = SCComida;
    }

    public void setSEComida(Semaphore SEComida) {
        this.SEComida = SEComida;
    }

    public void setSEJefe(Semaphore SEJefe) {
        this.SEJefe = SEJefe;
    }

    public void setSPComida(Semaphore SPComida) {
        this.SPComida = SPComida;
    }

    public void setSaleC(int saleC) {
        this.saleC = saleC;
    }

    public void setServicio(ServicioInterfaz servicio) {
        this.servicio = servicio;
    }
    
    
}
