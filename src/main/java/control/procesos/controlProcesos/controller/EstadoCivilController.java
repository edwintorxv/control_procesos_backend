package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.EstadoCivilResponseRest;
import control.procesos.controlProcesos.service.IEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class EstadoCivilController {

    @Autowired
    private IEstadoCivilService iEstadoCivilService;

    @GetMapping("/estadoCivil")
    public ResponseEntity<EstadoCivilResponseRest> obtenerEstadoCivil(){
        ResponseEntity<EstadoCivilResponseRest> estadoCivilResponse = iEstadoCivilService.obtenerEstadoCivil();
        return estadoCivilResponse;
    }

}
