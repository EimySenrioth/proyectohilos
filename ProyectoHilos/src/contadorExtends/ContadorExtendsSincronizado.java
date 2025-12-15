package contadorExtends;

import java.util.concurrent.CyclicBarrier;

/**
 * Clase que demuestra el uso de hilos extendiendo la clase Thread
 * con sincronización para ejecutar por fases
 */
public class ContadorExtendsSincronizado extends Thread {
    private final String nombre;
    private final int limite;
    private static CyclicBarrier barrera;
    
    /**
     * Constructor de la clase ContadorExtendsSincronizado
     * @param nombre Nombre del hilo contador
     * @param limite Número hasta el cual contar
     * @param totalHilos Número total de hilos para la sincronización
     */
    public ContadorExtendsSincronizado(String nombre, int limite, int totalHilos) {
        this.nombre = nombre;
        this.limite = limite;
        if (barrera == null) {
            barrera = new CyclicBarrier(totalHilos);
        }
    }
    
    /**
     * Método run que contiene la lógica del hilo sincronizado
     */
    @Override
    public void run() {
        System.out.println("Iniciando contador: " + nombre);
        
        for (int i = 1; i <= limite; i++) {
            try {
                // Imprimir el número actual
                System.out.println(nombre + " - Contador: " + i);
                
                // Esperar a que todos los hilos terminen esta fase
                barrera.await();
                
                // Pausa pequeña para mejor visualización
                Thread.sleep(200);
                
            } catch (InterruptedException | java.util.concurrent.BrokenBarrierException e) {
                System.out.println("Hilo " + nombre + " interrumpido");
                return;
            }
        }
        
        System.out.println("Finalizando contador: " + nombre);
        System.out.println("*** " + nombre + " ha terminado completamente ***");
    }
    
    /**
     * Método getter para el nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método getter para el límite
     */
    public int getLimite() {
        return limite;
    }
}