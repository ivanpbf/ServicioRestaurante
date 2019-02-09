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
public class CPostre extends Cocinero{
    private int mesonPostre[];
    private boolean ejecutar = true;
    private boolean pausar = false;

    public CPostre(int mesonPostre[], Semaphore SE, Semaphore SP, Semaphore SC, int entra, int sale, Servicio interfaz) {
        super(SE, SP, SC, 0.30, 1, entra, sale, interfaz);
        this.mesonPostre = mesonPostre;
    }
    
    

    public int[] getMesonPostre() {
        return mesonPostre;
    }

    public void setMesonPostre(int[] mesonPostre) {
        this.mesonPostre = mesonPostre;
    }
}
