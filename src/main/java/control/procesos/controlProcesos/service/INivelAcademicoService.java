package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.NivelAcademicoResponseRest;
import org.springframework.http.ResponseEntity;

public interface INivelAcademicoService {

    public ResponseEntity<NivelAcademicoResponseRest> obtenerNivelAcademico();

}
