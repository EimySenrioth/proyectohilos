package contadorExtends;

/**
 * Clase principal para demostrar el uso de ContadorExtends
 */
public class MainContadorExtends {
    
    public static void main(String[] args) {
        System.out.println("=== Ejemplo usando Thread extends ===");
        
        // Crear instancias de ContadorExtends
        ContadorExtends contador1 = new ContadorExtends("Hilo-A", 5);
        ContadorExtends contador2 = new ContadorExtends("Hilo-B", 3);
        ContadorExtends contador3 = new ContadorExtends("Hilo-C", 4);
        
        // Iniciar todos los hilos al mismo tiempo
        contador1.start();
        contador2.start();
        contador3.start();
        
        // While loop para verificar si algún hilo sigue vivo
        while (contador1.isAlive() || contador2.isAlive() || contador3.isAlive()) {
            try {
                System.out.println("Monitoreando hilos...");
                System.out.println("Hilo-A vivo: " + contador1.isAlive());
                System.out.println("Hilo-B vivo: " + contador2.isAlive());
                System.out.println("Hilo-C vivo: " + contador3.isAlive());
                System.out.println("---");
                
                // Pausa de 1 segundo mientras los hilos están ejecutándose
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                System.out.println("Hilo principal interrumpido");
                break;
            }
        }
        
        System.out.println("Todos los contadores han terminado.");
    }
}