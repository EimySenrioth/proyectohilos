package contadorRunnable;

/**
 * Clase que demuestra el uso de hilos implementando la interfaz Runnable
 */
public class ContadorRunnable implements Runnable {
    private final String nombre;
    private final int limite;
    
    /**
     * Constructor de la clase ContadorRunnable
     * @param nombre Nombre del hilo contador
     * @param limite Número hasta el cual contar
     */
    public ContadorRunnable(String nombre, int limite) {
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
            
            // Only sleep if not the last iteration to avoid unnecessary delay
            if (i < limite) {
                try {
                    // Pausa de 600 milisegundos entre cada número
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    System.out.println("Hilo " + nombre + " interrumpido");
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    return;
                }
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
    
    /**
     * Método para obtener información del contador
     */
    public String getInfo() {
        return "Contador: " + nombre + ", Límite: " + limite;
    }
}