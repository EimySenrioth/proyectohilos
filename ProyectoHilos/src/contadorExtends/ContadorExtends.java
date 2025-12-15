package contadorExtends;

/**
 * Clase que demuestra el uso de hilos extendiendo la clase Thread
 */
public class ContadorExtends extends Thread {
    private static final long SLEEP_DURATION = 500;
    private final String nombre;
    private final int limite;
    
    /**
     * Constructor de la clase ContadorExtends
     * @param nombre Nombre del hilo contador
     * @param limite Número hasta el cual contar
     */
    public ContadorExtends(String nombre, int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }
    
    /**
     * Método run que contiene la lógica del hilo
     */
    @Override
    public void run() {
        System.out.println("Iniciando contador: " + nombre);
        
        for (int i = 1; i <= limite; i++) {
            System.out.println(nombre + " - Contador: " + i);
            try {
                // Pausa entre cada número
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                System.out.println("Hilo " + nombre + " interrumpido");
                Thread.currentThread().interrupt(); // Restore interrupted status
                return;
            }
        }
        
        System.out.println("Finalizando contador: " + nombre);
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