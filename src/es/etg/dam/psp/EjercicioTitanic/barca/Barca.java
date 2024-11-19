package es.etg.dam.psp.EjercicioTitanic.barca;

// Importación de bibliotecas y paquetería
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Barca {

    // Constantes de datos
    private static final int NUM_BARCAS = 10;
    private static final int MAX_SUPERVIVIENTES = 101;
    private static final int MIN_TIEMPO_DESCENSO = 2000; // en milisegundos
    private static final int MAX_TIEMPO_DESCENSO = 6000; // en milisegundos

    // Constantes de texto
    private static final String PATRON = "dd/MM/yyyy HH:mm:ss";
    private static final String TIEMPO = "Ejecucion realizada el dia ";
    private static final String BARCA = "Barca B0%d: %d supervivientes";
    private static final String ERROR_BARCA = "Error en el descenso de la barca B";
    private static final String TOTAL_SUPERVIVIENTES = "Total de supervivientes: ";
    private static final String SUPERVIVIENTES = " supervivientes.";

    public static void main(String[] args) {

        // Declaración de variables
        int totalSupervivientes = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(PATRON);

        // Muestra del tiempo de ejecución actual
        System.out.println(TIEMPO + LocalDateTime.now().format(formato));

        // Bucle que irá contando los supervivientes de cada barca, los suma a un total de supervivientes y se espera un tiempo determinado hasta lanzar la siguiente
        for (int i = 0; i < NUM_BARCAS; i++) {
            int supervivientes = (int) (Math.random() * MAX_SUPERVIVIENTES);
            totalSupervivientes += supervivientes;
            System.out.println(String.format(BARCA, i, supervivientes));

            // Establece el tiempo de espera antes de lanzar la siguiente barca
            try {
                Thread.sleep((int) Math.random() * (MAX_TIEMPO_DESCENSO - MIN_TIEMPO_DESCENSO) + MIN_TIEMPO_DESCENSO);
            } catch (InterruptedException e) {
                System.out.println(ERROR_BARCA + i);
            }
        }

        // Muestra la cantidad total de supervivientes
        System.out.println(TOTAL_SUPERVIVIENTES + totalSupervivientes + SUPERVIVIENTES);
    }
}
