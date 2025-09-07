package control.procesos.controlProcesos.service.impl;

import control.procesos.controlProcesos.constants.MensajesConstantes;
import control.procesos.controlProcesos.entity.Cargo;
import control.procesos.controlProcesos.repository.IcargoRepository;
import control.procesos.controlProcesos.response.CargoResponseRest;
import control.procesos.controlProcesos.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements ICargoService {

    @Autowired
    private IcargoRepository icargoRepository;

    @Override
    public ResponseEntity<CargoResponseRest> obtenerCargo() {
        CargoResponseRest cargoResponseRest = new CargoResponseRest();
        try {
            List<Cargo> lstCargo = icargoRepository.findAll();
            cargoResponseRest.getCargoResponse().setLstCargo(lstCargo);
            cargoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_OK, MensajesConstantes.RESPUESTA_CODIGO_OK,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_OK);
        } catch (Exception e) {
            cargoResponseRest.setMetadata(MensajesConstantes.RESPUESTA_FALLIDA, MensajesConstantes.RESPUESTA_CODIGO_ERROR,
                    MensajesConstantes.RESPUESTA_DESCRIPCION_FALLIDA);
            return new ResponseEntity<CargoResponseRest>(cargoResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CargoResponseRest>(cargoResponseRest, HttpStatus.OK);
    }
}
