package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.entity.DocumentoMaestro;
import control.procesos.controlProcesos.response.DocumentoMaestroResponseRest;
import control.procesos.controlProcesos.service.IDocumentoMaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controlProcesos")
public class DocumentoMaestroController {

    @Autowired
    private IDocumentoMaestroService iDocumentoMaestroService;

    @GetMapping("/documentos/{idTipoDocumento}")
    public ResponseEntity<DocumentoMaestroResponseRest> obtenerDocumentos(@PathVariable Integer idTipoDocumento){
        ResponseEntity<DocumentoMaestroResponseRest> responseDocumentoMaestro = iDocumentoMaestroService.obtenerDocumentos(idTipoDocumento);
        return responseDocumentoMaestro;
    }

}
