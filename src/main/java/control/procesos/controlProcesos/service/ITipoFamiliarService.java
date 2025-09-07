package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.TipoFamiliarResponseRest;
import org.springframework.http.ResponseEntity;

public interface ITipoFamiliarService {

    public ResponseEntity<TipoFamiliarResponseRest> obtenetTipoFaimilar();
}
