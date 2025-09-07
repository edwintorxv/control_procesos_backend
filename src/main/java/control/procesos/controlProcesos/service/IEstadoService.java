package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.EstadoResponseRest;
import org.springframework.http.ResponseEntity;

public interface IEstadoService {

    public ResponseEntity<EstadoResponseRest> lstEstado();

}
