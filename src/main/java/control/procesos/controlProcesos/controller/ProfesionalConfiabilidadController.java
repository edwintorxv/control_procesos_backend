package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.ProfesionalConfiabilidadResponseRest;
import control.procesos.controlProcesos.service.IProfesionalConfiabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controlProcesos")
public class ProfesionalConfiabilidadController {

    @Autowired
    private IProfesionalConfiabilidadService iProfesionalConfiabilidadService;

    @GetMapping("/profesionalConfiabilidad")
    public ResponseEntity<ProfesionalConfiabilidadResponseRest> lstProfesionalConfiabilida(){
        ResponseEntity<ProfesionalConfiabilidadResponseRest> profesionalConfiabilidadResponseRest;
        profesionalConfiabilidadResponseRest = iProfesionalConfiabilidadService.obtenerProfesionalConfiabilidad();
        return profesionalConfiabilidadResponseRest;
    }
}
