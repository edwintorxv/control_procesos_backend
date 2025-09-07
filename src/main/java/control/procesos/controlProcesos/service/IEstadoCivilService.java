package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.EstadoCivilResponseRest;
import org.springframework.http.ResponseEntity;

public interface IEstadoCivilService {

    public ResponseEntity<EstadoCivilResponseRest> obtenerEstadoCivil();

}
