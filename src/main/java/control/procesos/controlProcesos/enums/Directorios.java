package control.procesos.controlProcesos.enums;

import lombok.Getter;

@Getter
public enum Directorios {

    DOCUMENTO_ACADEMICO("Documento_academico"),
    DOCUMENTO_INGRESO("Documento_ingreso"),
    DOCUMENTO_CONFIABILIDAD("Documento_confiabilidad"),
    //UNIDAD_ALMACENAMIENTO("D://Storage");
    UNIDAD_ALMACENAMIENTO("/media/toshiba/Storage");


    private final String parametroDirectorio;

    private Directorios(String parametroDirectorio) {
        this.parametroDirectorio = parametroDirectorio;
    }

}
