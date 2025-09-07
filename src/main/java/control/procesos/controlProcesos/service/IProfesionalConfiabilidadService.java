package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.ProfesionalConfiabilidadResponseRest;
import org.springframework.http.ResponseEntity;

public interface IProfesionalConfiabilidadService {

    public ResponseEntity<ProfesionalConfiabilidadResponseRest> obtenerProfesionalConfiabilidad();
}
