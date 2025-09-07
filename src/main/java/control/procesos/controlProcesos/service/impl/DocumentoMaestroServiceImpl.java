package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.DocumentoMaestro;
import control.procesos.controlProcesos.repository.IDocumentoMaestroRepository;
import control.procesos.controlProcesos.response.DocumentoMaestroResponseRest;
import control.procesos.controlProcesos.service.IDocumentoMaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoMaestroServiceImpl implements IDocumentoMaestroService {

    @Autowired
    private IDocumentoMaestroRepository iDocumentoMaestroRepository;

    @Override
    public ResponseEntity<DocumentoMaestroResponseRest> obtenerDocumentos(Integer idTipoDocumento) {
        DocumentoMaestroResponseRest documentoMaestroResponseRest = new DocumentoMaestroResponseRest();
        try {
            List<DocumentoMaestro> lstDocumentoMaestro = iDocumentoMaestroRepository.lstDocumentoMaestroPorTipoDocumento(idTipoDocumento);
            documentoMaestroResponseRest.getDocumentoMaestroResponse().setLstDocumentoMaestro(lstDocumentoMaestro);
            documentoMaestroResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            documentoMaestroResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    "" + e.getCause());
            return new ResponseEntity<DocumentoMaestroResponseRest>(documentoMaestroResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<DocumentoMaestroResponseRest>(documentoMaestroResponseRest, HttpStatus.OK);
    }
}
