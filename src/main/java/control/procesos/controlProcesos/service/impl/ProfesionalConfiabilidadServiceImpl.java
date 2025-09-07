package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.ProfesionalConfiabilidad;
import control.procesos.controlProcesos.repository.IProfesionalConfiabilidadRepository;
import control.procesos.controlProcesos.response.ProfesionalConfiabilidadResponseRest;
import control.procesos.controlProcesos.service.IProfesionalConfiabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalConfiabilidadServiceImpl implements IProfesionalConfiabilidadService {

    @Autowired
    private IProfesionalConfiabilidadRepository iProfesionalConfiabilidadRepository;

    @Override
    public ResponseEntity<ProfesionalConfiabilidadResponseRest> obtenerProfesionalConfiabilidad() {
        ProfesionalConfiabilidadResponseRest profesionalConfiabilidadResponseRest = new ProfesionalConfiabilidadResponseRest();

        try {
            List<ProfesionalConfiabilidad> lstProfesionalConfiabilidad = iProfesionalConfiabilidadRepository.findAll();

            if (!lstProfesionalConfiabilidad.isEmpty()) {
                profesionalConfiabilidadResponseRest.getProfesionalConfiabilidadResponse().setLstProfesionaConfiabilidad(lstProfesionalConfiabilidad);

                profesionalConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_OK);

                return new ResponseEntity<ProfesionalConfiabilidadResponseRest>(profesionalConfiabilidadResponseRest, HttpStatus.OK);
            } else {
                profesionalConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                        MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);

                return new ResponseEntity<ProfesionalConfiabilidadResponseRest>(profesionalConfiabilidadResponseRest, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            profesionalConfiabilidadResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<ProfesionalConfiabilidadResponseRest>(profesionalConfiabilidadResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
