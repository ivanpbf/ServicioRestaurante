/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviciorestaurante.ServicioInterfaz; //interfaz

/**
 *
 * Aqui ponemos nuestros nombres
 */
public class ServicioRestaurant { // ojo que esta es la clase principal donde se inicializara el programa y guardara lo importante
    //Cantidades del archivo
    static public long tiempo;
    static public int maxMesonEntradas;
    static public int maxMesonPlatos;
    static public int maxMesonPostres;
    static public int cantInicialEntrada;
    static public int cantInicialPF;
    static public int cantInicialPostres;
    static public int maxCantEntrada;
    static public int maxCantPF;
    static public int maxCantPostre;
    static public int cantInicialMesoneros;
    static public int cantMaxMesoneros;
    //Cocineros y Mesoneros
    static public CEntrada CEntradas [];
    static public CPlatoFuerte CPlato [];
    static public CPostre CPostres [];
    static public Mesonero Mesoneros [];
    //Mesones
    static public int mesonEntradas [];
    static public int mesonPlato [];
    static public int mesonPostre [];
    static public int mesonComida [] = new int [200]; //pendiente que no hay limite, por eso decide este
    //Semaforos de Entradas (comida)
    static public Semaphore SEEntrada = new Semaphore(1);
    static public Semaphore SPEntrada;
    static public Semaphore SCEntrada  = new Semaphore(0);
    static public int entraE=0;
    static public int saleE=0;
    //Semaforos de Plato Fuerte
    static public Semaphore SEPlato = new Semaphore(1);
    static public Semaphore SPPlato;
    static public Semaphore SCPlato  = new Semaphore(0);
    static public int entraPF=0;
    static public int salePF=0;
    //Semaforos de Postre
    static public Semaphore SEPostre = new Semaphore(1);
    static public Semaphore SPPostre;
    static public Semaphore SCPostre  = new Semaphore(0);
    static public int entraP=0;
    static public int saleP=0;
    //Semaforos de Comida (lo que sirve el mesonero, todo)
    static public Semaphore SEComida = new Semaphore(1);
    static public Semaphore SPComida;
    static public Semaphore SCComida  = new Semaphore(0);
    static public int entraC=0;
    static public int saleC=0;
    //tiene la interfaz
    public static ServicioInterfaz servicio = new ServicioInterfaz();
    //iniciar el gerente y cronometrador
    static public Semaphore SEJefe = new Semaphore(1);
    static public JefeMesoneros jefemesoneros = new JefeMesoneros(1, SEJefe, servicio); //inicia en 1?
    static public Gerente gerente = new Gerente(mesonComida, SEComida, SPComida, SCComida, SEJefe, entraC, saleC, jefemesoneros, servicio);
    
    
     public static void main(String[] args) {
        int[] datos = new int[12];
        datos = leerArchivoDatos();
         //iniciamos todo
         //ojo que estos son los valores predeterminados, esto cambia si existe archivo de objeto o texto
        tiempo = datos[0];
        maxMesonEntradas = datos[1];
        maxMesonPlatos = datos[2];
        maxMesonPostres = datos[3];
        cantInicialEntrada = datos[4];
        cantInicialPF = datos[5];
        cantInicialPostres = datos[6];
        maxCantEntrada = datos[7];
        maxCantPF = datos[8];
        maxCantPostre = datos[9];
        cantInicialMesoneros = datos[10];
        cantMaxMesoneros = datos[11];
        //luego lo demas
        CEntradas = new CEntrada[maxCantEntrada];
        CPlato = new CPlatoFuerte[maxCantPF];
        CPostres = new CPostre[maxCantPostre];
        Mesoneros = new Mesonero[cantMaxMesoneros];
        mesonEntradas = new int [maxMesonEntradas];
        mesonPlato = new int [maxMesonPlatos];
        mesonPostre = new int [maxMesonPostres];
        SPEntrada = new Semaphore(mesonEntradas.length);
        SPPlato = new Semaphore(mesonPlato.length);
        SPPostre = new Semaphore(mesonPostre.length);
        SPComida = new Semaphore(mesonComida.length);
        servicio.setVisible(true);
        
        //comenzamos las cantidades iniciales
        for(int i = 0; i < cantInicialEntrada; i++){
            CEntradas[i] = new CEntrada(mesonEntradas, SEEntrada, SEEntrada, SCEntrada,tiempo, entraE, saleE, servicio);
            CEntradas[i].start();
        }
        servicio.getCocinerosEntradas().setText(Integer.toString(cantInicialEntrada)); //la cantidad inicial

        for(int i = 0; i < cantInicialPF; i++){
            CPlato[i] = new CPlatoFuerte(mesonPlato, SEPlato, SEPlato, SCPlato, tiempo, entraPF, salePF, servicio);
            CPlato[i].start();
            //set numero en interfaz
        }
        servicio.getCocinerosPlatos().setText(Integer.toString(cantInicialPF));
        for(int i = 0; i < cantInicialPostres; i++){
            CPostres[i] = new CPostre(mesonPostre, SEPostre, SEPostre, SCPostre,tiempo, entraP, saleP, servicio);
            CPostres[i].start();
            //set numero en interfaz
        }
        servicio.getCocinerosPostres().setText(Integer.toString(cantInicialPostres));

        for(int i = 0; i < cantInicialMesoneros; i++){
            Mesoneros[i] = new Mesonero(SEComida, SPComida, SCComida, entraC, saleC, SEEntrada, SPEntrada, SCEntrada, entraE, saleE,
                SEPlato, SPPlato, SCPlato, entraPF, salePF, SEPostre, SPPostre, SCPostre, entraP, saleP, servicio,tiempo, mesonEntradas, mesonPlato, mesonPostre, mesonComida);
        Mesoneros[i].start();
        }
        
        servicio.getMesoneros().setText(Integer.toString(cantInicialMesoneros));
        jefemesoneros.start();
        gerente.start();
     }
    public static int[] leerArchivoDatos(){ //lee las columnas filas y minas predeterminadas
        int[] datos = new int[12];
        //linea 1 tiempo en segundos que dura una hora
        //linea 2 capacidad meson entradas
        //linea 3 capacidad meson de platos fuertes
        //linea 4 capacidad meson postres
        //linea 5 cant inicial cocineros de entrada
        //linea 6 cant inicial cocineros de pf
        //linea 7 cant inicial cocineros de postres
        //linea 8 cant max cocineros de entrada
        //linea 9 cant max cocineros de pf
        //linea 10 cant max cocineros de postres
        //linea 11 cant inicial mesoneros
        //linea 12 cantidad maxima de mesoneros
        String datosausar = "Datos.txt";
        String linea = null;
        try{
            Scanner scanner = new Scanner(new File("Datos.txt"));
            int i = 0;
            while(scanner.hasNextInt()){
                datos[i] = scanner.nextInt();
                i++;
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("No se puede abrir el archivo " +datosausar);                
        }
        catch(IOException ex) {
            System.out.println("Error leyendo el archivo "+datosausar);             
        }
        return datos;
    }
    /*public static void escribirArchivo(int columnas, int filas, int minas){ //escribe el archivo de texto por si no hay o el jugador quiero usar otras reglas
        String datos = "Datos.txt";
        try {
            FileWriter fileWriter = new FileWriter(datos);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write((new Integer(columnas).toString()));
            bufferedWriter.newLine();
            bufferedWriter.write((new Integer(filas).toString()));
            bufferedWriter.newLine();
            bufferedWriter.write((new Integer(minas).toString()));
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error escribiendo el archivo "+datos);
        }*/ //esto es viejo, lo dejo aqui por si acaso hay que poner que la persona lo cambie DENTRO del programa
}
