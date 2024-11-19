package es.etg.dam.psp.EjercicioTitanic.data;

public class FabricaImpresion {

    // Constantes de texto
    private static final String ERROR_IMPRESION = "Tipo de impresión no soportado: ";

    // Función para crear distintas impresiones en caso de haberlas
    public static Imprimible crearImpresora(TipoImpresion tipo) {
        switch (tipo) {
            case CONSOLA:
                return new ImpresionConsola();
            default:
                throw new IllegalArgumentException(ERROR_IMPRESION + tipo);
        }
    }
}