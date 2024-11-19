package es.etg.dam.psp.EjercicioTitanic.titanic;

// Importación de bibliotecas y paqueteria
import es.etg.dam.psp.EjercicioTitanic.data.FabricaImpresion;
import es.etg.dam.psp.EjercicioTitanic.data.Imprimible;
import es.etg.dam.psp.EjercicioTitanic.data.TipoImpresion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Titanic {

    // Constantes de texto
    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String[] COMANDO = {"java", "es.etg.dam.psp.EjercicioTitanic.barca.Barca"};

    // Método que da inicio a la ejecución del programa
    public static void Rescate() {
        try {
            Process process = Runtime.getRuntime().exec(COMANDO);
            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                Imprimible impresora = FabricaImpresion.crearImpresora(TipoImpresion.CONSOLA);
                impresora.imprimir(output.toString());
                System.exit(0);
            } else {
                System.out.println(MSG_ERROR);
                System.exit(1);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(MSG_ERROR + ": " + e.getMessage());
            System.exit(34);
        }
    }
}
