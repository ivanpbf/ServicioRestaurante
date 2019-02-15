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
public class JefeMesoneros extends Thread{
    //basicamente es el cronometrador
    private double Contador; //creo que double ya que tratamos con horas siendo 1 segundo 1 hora
    //pero no estoy seguro si deberiamos hacer una mejor conversion de esas unidades
    private Semaphore SEJefe;
    private ServicioInterfaz servicio;
    private boolean Escribiendo; 

    public JefeMesoneros(double Contador, Semaphore SEJefe, ServicioInterfaz servicio) {
        this.Contador = Contador;
        this.SEJefe = SEJefe;
        this.servicio = servicio;
        this.Escribiendo = false;
    }

    @Override
    public void run() {
        while(true){
            try {
                //necesita adquirir el tiempo y su estado
                this.setEscribiendo(false);
                this.sleep(1);
                this.setEscribiendo(true);
                
                SEJefe.acquire();
                registrar();
                SEJefe.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(JefeMesoneros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void registrar(){
        try {
            this.sleep((long)0.05); //pensar
        } catch (InterruptedException ex) {
            Logger.getLogger(JefeMesoneros.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(getContador() != 0){
            setContador(getContador()-1);
            //se cambia en interfaz
        }
    }

    public void setEscribiendo(boolean Escribiendo) {
        this.Escribiendo = Escribiendo;
        if(Escribiendo){
            //se pone en la interfaz que esta escribiendo/contando
        }
        else{
            //se pone que esta esperando
        }
    }

    public boolean isEscribiendo() {
        return Escribiendo;
    }

    public double getContador() {
        return Contador;
    }

    public void setContador(double Contador) {
        this.Contador = Contador;
    }

    public Semaphore getSEJefe() {
        return SEJefe;
    }

    public void setSEJefe(Semaphore SEJefe) {
        this.SEJefe = SEJefe;
    }

    public ServicioInterfaz getServicio() {
        return servicio;
    }
    
    
    
}
