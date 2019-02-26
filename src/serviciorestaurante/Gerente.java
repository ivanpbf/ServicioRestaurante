package serviciorestaurante;
import serviciorestaurante.ServicioInterfaz;
import java.util.Random;
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
    private int ordenesAtendidas;

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
        this.ordenesAtendidas = 0;
    }

    @Override
    public void run() {
        while(true){
            try {
                SEJefe.acquire(1);
                if(getJefem().getContador() == 0){ //la hora de cerrar
                    cerrar();
                    getJefem().setContador(18); //dependera de donde inicia
                    this.servicio.getHorasRestantes().setText(Integer.toString((int) getJefem().getContador()));
                }
                SEJefe.release(1);
                descansar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void cerrar(){ try {
        int ordenesActuales = 0; //?? creo
        SEComida.acquire(1);
        for(int i = 0; i < 200; i++){ // recordar que es la cantidad en la que lo iniciamos al comienzo
            if(mesonComida[i] == 1){
                mesonComida[i] = 0;
                ordenesActuales++;
            }
        }
        ordenesAtendidas = ordenesAtendidas + ordenesActuales;
        servicio.getComidas().setText(Integer.toString(ordenesAtendidas));
        setSaleC(0);
        setEntraC(0);
        SEComida.release(1);
        SPComida.release(ordenesActuales);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void descansar(){
        try {
            Random r = new Random();
            double random = 0.25 + (0.45 - 0.25) * r.nextDouble();
            this.servicio.getGerente().setText("Descansando");
            this.sleep((long)(random*1000*ServicioRestaurant.tiempo));
            this.servicio.getGerente().setText("Revisando");
        } catch (InterruptedException ex) {
            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    