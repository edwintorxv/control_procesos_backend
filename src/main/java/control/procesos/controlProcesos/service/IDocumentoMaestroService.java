package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.DocumentoMaestroResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDocumentoMaestroService {

    public ResponseEntity<DocumentoMaestroResponseRest> obtenerDocumentos(List<Integer> idTipoDocumento);

}
