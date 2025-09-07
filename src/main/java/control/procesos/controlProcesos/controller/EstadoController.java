package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.EstadoResponseRest;
import control.procesos.controlProcesos.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class EstadoController {

    @Autowired
    private IEstadoService iEstadoService;

    @GetMapping("estado")
    public ResponseEntity<EstadoResponseRest> obtenerEstado(){
        ResponseEntity<EstadoResponseRest> estadoResponseRest = iEstadoService.lstEstado();
        return estadoResponseRest;
    }
}
