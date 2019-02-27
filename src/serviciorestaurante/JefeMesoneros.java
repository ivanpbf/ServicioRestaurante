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
        this.Contador = 18; //horas en la que se trabaja?
        this.SEJefe = SEJefe;
        this.servicio = servicio;
        this.Escribiendo = false;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.setEscribiendo(false);
                this.sleep(1000*ServicioRestaurant.tiempo);
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
            this.sleep((long)0.05*100*ServicioRestaurant.tiempo); //pensar
        } catch (InterruptedException ex) {
            Logger.getLogger(JefeMesoneros.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(getContador() != 0){
            setContador(getContador()-1);
            this.servicio.getHorasRestantes().setText(Integer.toString((int) Contador));
        }
    }

    public void setEscribiendo(boolean Escribiendo) {
        this.Escribiendo = Escribiendo;
        if(Escribiendo){
            this.servicio.getJefeMesoneros().setText("Leyendo");
        }
        else{
            this.servicio.getJefeMesoneros().setText("Descansando");
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