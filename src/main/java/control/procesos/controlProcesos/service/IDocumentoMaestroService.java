package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.DocumentoMaestroResponseRest;
import org.springframework.http.ResponseEntity;

public interface IDocumentoMaestroService {

    public ResponseEntity<DocumentoMaestroResponseRest> obtenerDocumentos(Integer idTipoDocumento);

}
