package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.DepartamentoResponseRest;
import org.springframework.http.ResponseEntity;

public interface IDepartamentoService {

    public ResponseEntity<DepartamentoResponseRest> obtenerDepartamentos();
}
