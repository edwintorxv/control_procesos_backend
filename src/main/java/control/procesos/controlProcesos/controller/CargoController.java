package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.CargoResponseRest;
import control.procesos.controlProcesos.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class CargoController {

    @Autowired
    private ICargoService iCargoService;

    @GetMapping("/cargo")
    public ResponseEntity<CargoResponseRest> obtenerCargo(){
        ResponseEntity<CargoResponseRest> cargoResponseRest = iCargoService.obtenerCargo();
        return cargoResponseRest;
    }


}
