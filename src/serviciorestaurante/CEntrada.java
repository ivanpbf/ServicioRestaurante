/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import serviciorestaurante.Servicio;
import java.util.concurrent.Semaphore;


public class CEntrada extends Cocinero{
    private int mesonEntradas[];
    private boolean ejecutar = true;
    private boolean pausar = false;

    public CEntrada(int mesonEntradas[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, 0.25, 1, entra, sale, interfaz);
        //0.25 es el tiempo que le toma producir [1] 
        this.mesonEntradas = mesonEntradas;
    }
    
    

    public int[] getMesonEntradas() {
        return mesonEntradas;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonEntradas = mesonEntradas;
    }
    
    
    
}
