package control.procesos.controlProcesos.service;

import control.procesos.controlProcesos.response.CargoResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICargoService {

    public ResponseEntity<CargoResponseRest> obtenerCargo();

}
