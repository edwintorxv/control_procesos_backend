package control.procesos.controlProcesos.response;

import control.procesos.controlProcesos.entity.DocumentoMaestro;
import lombok.Data;

import java.util.List;

@Data
public class DocumentoMaestroResponse {

    public List<DocumentoMaestro> lstDocumentoMaestro;
}
