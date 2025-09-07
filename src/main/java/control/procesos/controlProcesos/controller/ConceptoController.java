package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.ConceptoResponseRest;
import control.procesos.controlProcesos.service.IClienteService;
import control.procesos.controlProcesos.service.IConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class ConceptoController {

    @Autowired
    private IConceptoService iConceptoService;

    @GetMapping("/concepto")
    public ResponseEntity<ConceptoResponseRest> lstConcepto() {
        ResponseEntity<ConceptoResponseRest> conceptoResponseRestResponseEntity;
        conceptoResponseRestResponseEntity = iConceptoService.lstConcepto();
        return conceptoResponseRestResponseEntity;
    }

}
