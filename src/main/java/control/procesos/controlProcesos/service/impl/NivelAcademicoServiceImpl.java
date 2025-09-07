package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.NivelAcademico;
import control.procesos.controlProcesos.repository.INivelAcademicoRepository;
import control.procesos.controlProcesos.response.NivelAcademicoResponseRest;
import control.procesos.controlProcesos.service.INivelAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAcademicoServiceImpl implements INivelAcademicoService {

    @Autowired
    private INivelAcademicoRepository iNivelAcademicoRepository;

    @Override
    public ResponseEntity<NivelAcademicoResponseRest> obtenerNivelAcademico() {
        NivelAcademicoResponseRest nivelAcademicoResponseRest = new NivelAcademicoResponseRest();
        try {
            List<NivelAcademico> lstNivelAcademico = iNivelAcademicoRepository.findAll();
            nivelAcademicoResponseRest.getNivelAcademicoResponse().setLstNivelAcademico(lstNivelAcademico);
            nivelAcademicoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            nivelAcademicoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<NivelAcademicoResponseRest>(nivelAcademicoResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<NivelAcademicoResponseRest>(nivelAcademicoResponseRest, HttpStatus.OK);
    }
}
