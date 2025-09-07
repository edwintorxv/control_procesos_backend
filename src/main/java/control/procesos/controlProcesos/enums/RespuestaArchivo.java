package control.procesos.controlProcesos.enums;

public enum RespuestaArchivo {

    LIMITE_SUPERADO("El archivo es muy grande"),
    FORMATO_PDF(".pdf"),
    FORMATO_INCORRECTO("El archivo seleccionado %s, no es del formato esperado");

    private final String descripcion;

    private RespuestaArchivo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}