/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import serviciorestaurante.Servicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ivan
 */
public class Mesonero extends Thread{
    //basicamente es el ensamblador
    private Semaphore SEComida;
    private Semaphore SPComida;
    private Semaphore SCComida;
    private int entraC; //entra comida
    private int saleC;
    
    private Semaphore SEEntrada;
    private Semaphore SPEntrada;
    private Semaphore SCEntrada;
    private int entraE; 
    private int saleE;
    
    private Semaphore SEPlato; //plato fuerte
    private Semaphore SPPlato;
    private Semaphore SCPlato;
    private int entraPF; //entra plato fuerte
    private int salePF;
    
    private Semaphore SEPostre;
    private Semaphore SPPostre;
    private Semaphore SCPostre;
    private int entraP; 
    private int saleP;
    
    private Servicio servicio;
    
    private int mesonEntradas[];
    private int mesonPlato[]; //meson plato fuerte
    private int mesonPostre[];
    private int mesonComida[]; //digo que seria como el total?
    
    private double tiempo;
    private boolean ejecutar = true;


    public Mesonero(Semaphore SEComida, Semaphore SPComida, Semaphore SCComida, int entraC, int saleC, Semaphore SEEntrada, Semaphore SPEntrada, Semaphore SCEntrada, int entraE, int saleE,
            Semaphore SEPlato, Semaphore SPPlato, Semaphore SCPlato, int entraPF, int salePF, Semaphore SEPostre, Semaphore SPPostre, Semaphore SCPostre, int entraP, int saleP,
            Servicio servicio, int[] mesonEntradas, int[] mesonPlato, int[] mesonPostre, int[] mesonComida) {
        this.SEComida = SEComida;
        this.SPComida = SPComida;
        this.SCComida = SCComida;
        this.entraC = entraC;
        this.saleC = saleC;
        this.SEEntrada = SEEntrada;
        this.SPEntrada = SPEntrada;
        this.SCEntrada = SCEntrada;
        this.entraE = entraE;
        this.saleE = saleE;
        this.SEPlato = SEPlato;
        this.SPPlato = SPPlato;
        this.SCPlato = SCPlato;
        this.entraPF = entraPF;
        this.salePF = salePF;
        this.SEPostre = SEPostre;
        this.SPPostre = SPPostre;
        this.SCPostre = SCPostre;
        this.entraP = entraP;
        this.saleP = saleP;
        this.servicio = servicio;
        this.mesonEntradas = mesonEntradas;
        this.mesonPlato = mesonPlato;
        this.mesonPostre = mesonPostre;
        this.mesonComida = mesonComida;
        this.tiempo = 0.15;
    }

    @Override
    public void run() {
        while(ejecutar){
            try {
                SCEntrada.acquire(3);
                SEEntrada.acquire(1);
                tomarEntrada();
                SEEntrada.release();
                SPEntrada.release();
                SCPlato.acquire(2);
                SEPlato.acquire(1);
                tomarPlatofuerte();
                SEPlato.release();
                SPPlato.release();
                SCPostre.acquire(1);
                SEPostre.acquire(1);
                tomarPostre();
                SEPostre.release();
                SPPostre.release();
                this.sleep((long)tiempo);
                //luego viene servir
                SPComida.acquire(1);
                SEComida.acquire(1);
                servir();
                SEComida.release();
                SCComida.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesonero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void tomarEntrada(){
        mesonEntradas[saleE] = 0;
        mesonEntradas[saleE+1] = 0; //VERIFICAR creo que no es asi porque hay que considerar el tamn~ano maximo?
        mesonEntradas[saleE+2] = 0;
        saleE = saleE+3;
        //cambiar en interfaz
    }
    
    public void tomarPlatofuerte(){
        mesonPlato[salePF] = 0;
        mesonPlato[salePF+1] = 0; //VERIFICAR creo que no es asi
        saleP = salePF+2;
        //cambiar en interfaz
    }
    
    public void tomarPostre(){
        mesonPostre[saleP] = 0;
        saleP = saleP+1;
        //cambiar en interfaz
    }
    
    public void servir(){
        mesonComida[entraC] = 1;
        entraC = entraC+1;
        //cambiar en interfaz
    }
    //luego contratar y despedir
}
