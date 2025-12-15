package contadorRunnable;

/**
 * Clase principal para demostrar el uso de ContadorRunnable
 */
public class MainContadorRunnable {
    
    public static void main(String[] args) {
        System.out.println("=== Ejemplo usando Runnable interface ===");
        
        // Crear instancias de ContadorRunnable
        ContadorRunnable contador1 = new ContadorRunnable("Runnable-X", 4);
        ContadorRunnable contador2 = new ContadorRunnable("Runnable-Y", 6);
        ContadorRunnable contador3 = new ContadorRunnable("Runnable-Z", 3);
        
        // Crear hilos pasando las instancias Runnable
        Thread hilo1 = new Thread(contador1);
        Thread hilo2 = new Thread(contador2);
        Thread hilo3 = new Thread(contador3);
        
        // Mostrar información de los contadores
        System.out.println(contador1.getInfo());
        System.out.println(contador2.getInfo());
        System.out.println(contador3.getInfo());
        System.out.println();
        
        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        try {
            // Esperar a que todos los hilos terminen
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
        
        System.out.println("Todos los contadores Runnable han terminado.");
    }
}