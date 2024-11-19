package es.etg.dam.psp.EjercicioTitanic.data;

public class ImpresionConsola extends Impresora {

    // Constantes de texto
    public static final String INFO_RESCATE = "=== Información del Rescate ===";
    
    @Override
    public void imprimir(String informacion) {
        System.out.println(INFO_RESCATE);
        System.out.println(informacion);
    }
}