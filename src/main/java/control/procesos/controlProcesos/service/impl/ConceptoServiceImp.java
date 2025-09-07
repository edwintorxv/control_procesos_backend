package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Concepto;
import control.procesos.controlProcesos.repository.IConceptoRespository;
import control.procesos.controlProcesos.response.ConceptoResponseRest;
import control.procesos.controlProcesos.service.IConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptoServiceImp implements IConceptoService {

    @Autowired
    private IConceptoRespository iConceptoRespository;

    @Override
    public ResponseEntity<ConceptoResponseRest> lstConcepto() {
        ConceptoResponseRest conceptoResponseRest = new ConceptoResponseRest();

        try {
            List<Concepto> lstConcepto = iConceptoRespository.findAll();

            if (!lstConcepto.isEmpty()) {
                conceptoResponseRest.getConceptoResponse().setLstConcepto(lstConcepto);
                conceptoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);

                return new ResponseEntity<ConceptoResponseRest>(conceptoResponseRest, HttpStatus.OK);

            } else {
                conceptoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
                return new ResponseEntity<ConceptoResponseRest>(conceptoResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            conceptoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<ConceptoResponseRest>(conceptoResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
