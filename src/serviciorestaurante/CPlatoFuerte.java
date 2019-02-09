/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ivan
 */
public class CPlatoFuerte extends Cocinero{
    private int[] mesonPlatoFuerte;
    private boolean ejecutar = true;
    private boolean pausar = false;

    public CPlatoFuerte(int mesonPlatoFuerte[], Semaphore SE, Semaphore SP, Semaphore SC, double tiempo, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, tiempo, entra, sale, interfaz);
        this.mesonPlatoFuerte = mesonPlatoFuerte;
    }
    
    

    public int[] getMesonEntradas() {
        return mesonPlatoFuerte;
    }

    public void setMesonEntradas(int[] mesonEntradas) {
        this.mesonPlatoFuerte = mesonEntradas;
    }
}
