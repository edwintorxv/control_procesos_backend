package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.EstadoCivil;
import control.procesos.controlProcesos.repository.IEstadoCivilRepository;
import control.procesos.controlProcesos.response.EstadoCivilResponseRest;
import control.procesos.controlProcesos.service.IEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilServiceImpl implements IEstadoCivilService {

    @Autowired
    private IEstadoCivilRepository iEstadoCivilRepository;


    @Override
    public ResponseEntity<EstadoCivilResponseRest> obtenerEstadoCivil() {
        EstadoCivilResponseRest estadoCivilResponseRest = new EstadoCivilResponseRest();
        try {
            List<EstadoCivil> lstEstadoCivil = iEstadoCivilRepository.findAll();
            estadoCivilResponseRest.getEstadoCivilResponse().setLstEsadoCivil(lstEstadoCivil);
            estadoCivilResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            estadoCivilResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    "" + e.getCause());
            return new ResponseEntity<EstadoCivilResponseRest>(estadoCivilResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<EstadoCivilResponseRest>(estadoCivilResponseRest,HttpStatus.OK);
    }
}
