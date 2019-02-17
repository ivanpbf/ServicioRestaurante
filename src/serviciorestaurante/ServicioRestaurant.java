/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.util.concurrent.Semaphore;
import serviciorestaurante.ServicioInterfaz; //interfaz

/**
 *
 * Aqui ponemos nuestros nombres
 */
public class ServicioRestaurant { // ojo que esta es la clase principal donde se inicializara el programa y guardara lo importante
    
    //Cocineros y Mesoneros
    static public CEntrada CEntradas [] = new CEntrada[3];
    static public CPlatoFuerte CPlato [] = new CPlatoFuerte[4];
    static public CPostre CPostres [] = new CPostre[2];
    static public Mesonero Mesoneros [] = new Mesonero[6];
    //Mesones
    static public int mesonEntradas [] = new int [20];
    static public int mesonPlato [] = new int [30];
    static public int mesonPostre [] = new int [10];
    static public int mesonComida [] = new int [200]; //pendiente que no hay limite, por eso decide este
    //Semaforos de Entradas (comida)
    static public Semaphore SEEntrada = new Semaphore(1);
    static public Semaphore SPEntrada = new Semaphore(mesonEntradas.length);
    static public Semaphore SCEntrada  = new Semaphore(0);
    static public int entraE=0;
    static public int saleE=0;
    //Semaforos de Plato Fuerte
    static public Semaphore SEPlato = new Semaphore(1);
    static public Semaphore SPPlato = new Semaphore(mesonPlato.length);
    static public Semaphore SCPlato  = new Semaphore(0);
    static public int entraPF=0;
    static public int salePF=0;
    //Semaforos de Postre
    static public Semaphore SEPostre = new Semaphore(1);
    static public Semaphore SPPostre = new Semaphore(mesonPostre.length);
    static public Semaphore SCPostre  = new Semaphore(0);
    static public int entraP=0;
    static public int saleP=0;
    //Semaforos de Comida (lo que sirve el mesonero, todo)
    static public Semaphore SEComida = new Semaphore(1);
    static public Semaphore SPComida = new Semaphore(mesonComida.length);
    static public Semaphore SCComida  = new Semaphore(0);
    static public int entraC=0;
    static public int saleC=0;
    //tiene la interfaz
    public static ServicioInterfaz servicio = new ServicioInterfaz();
    //iniciar el gerente y cronometrador
    
     public static void main(String[] args) {
         //iniciamos todo
         //ojo que estos son los valores predeterminados, esto cambia si existe archivo de objeto o texto
        servicio.setVisible(true);
        
        //comenzamos las cantidades iniciales
        CEntradas[0] = new CEntrada(mesonEntradas, SEEntrada, SEEntrada, SCEntrada, entraE, saleE, servicio);
        CEntradas[0].start();
        servicio.getCocinerosEntradas().setText("1"); //la cantidad inicial

        for(int i = 0; i < 2; i++){
            CPlato[i] = new CPlatoFuerte(mesonPlato, SEPlato, SEPlato, SCPlato, entraE, saleE, servicio);
            CPlato[i].start();
            //set numero en interfaz
        }
        servicio.getCocinerosPlatos().setText("2");
        //la cantidad de cocineros de postre inicial es 0
        servicio.getCocinerosPostres().setText("0");
        //tampoco nos dan una cantidad inicial de ensambladores, asi que usemos 1?
        Mesoneros[0] = new Mesonero(SEComida, SPComida, SCComida, entraC, saleC, SEEntrada, SPEntrada, SCEntrada, entraE, saleE,
                SEPlato, SPPlato, SCPlato, entraPF, salePF, SEPostre, SPPostre, SCPostre, entraP, saleP, servicio, mesonEntradas, mesonPlato, mesonPostre, mesonComida);
        Mesoneros[0].start();
        servicio.getMesoneros().setText("1");
     }
}
