package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.CiudadMunicipioResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICiudadMunicipioService {

    public ResponseEntity<CiudadMunicipioResponseRest> obtenerCiudadMunicipio(Integer idDepartamento);
}
