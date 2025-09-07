package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Estado;
import control.procesos.controlProcesos.repository.IEstadoRespository;
import control.procesos.controlProcesos.response.EstadoResponseRest;
import control.procesos.controlProcesos.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    private IEstadoRespository iEstadoRespository;

    @Override
    public ResponseEntity<EstadoResponseRest> lstEstado() {
        EstadoResponseRest estadoResponseRest = new EstadoResponseRest();
        try {
            List<Estado> lstEstado = iEstadoRespository.findAll();
            estadoResponseRest.getEstadoResponse().setLstEstado(lstEstado);
            estadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        }catch(Exception e){
            estadoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<EstadoResponseRest>(estadoResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<EstadoResponseRest>(estadoResponseRest, HttpStatus.OK);
    }
}
