package contadorExtends;

/**
 * Clase principal para demostrar hilos sincronizados por fases
 * Primero todos los 1s, luego todos los 2s, etc.
 */
public class MainContadorSincronizado {
    
    public static void main(String[] args) {
        System.out.println("=== Ejemplo sincronizado por fases ===");
        System.out.println("Primero todos los 1s, luego todos los 2s, etc.");
        System.out.println();
        
        // Crear instancias de ContadorExtendsSincronizado
        ContadorExtendsSincronizado contador1 = new ContadorExtendsSincronizado("Hilo-A", 5, 3);
        ContadorExtendsSincronizado contador2 = new ContadorExtendsSincronizado("Hilo-B", 3, 3);
        ContadorExtendsSincronizado contador3 = new ContadorExtendsSincronizado("Hilo-C", 4, 3);
        
        // Iniciar todos los hilos al mismo tiempo
        contador1.start();
        contador2.start();
        contador3.start();
        
        try {
            // Esperar a que todos los hilos terminen
            contador1.join();
            contador2.join();
            contador3.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
        
        System.out.println();
        System.out.println("Todos los contadores han terminado.");
    }
}