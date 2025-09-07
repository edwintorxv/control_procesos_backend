package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.ConceptoResponseRest;
import org.springframework.http.ResponseEntity;

public interface IConceptoService {

    public ResponseEntity<ConceptoResponseRest> lstConcepto();
}
