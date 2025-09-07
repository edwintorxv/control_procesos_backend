package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.NivelAcademicoResponseRest;
import control.procesos.controlProcesos.service.INivelAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class NivelAcademicoController {

    @Autowired
    private INivelAcademicoService iNivelAcademicoService;

    @GetMapping("/nivelAcademico")
    public ResponseEntity<NivelAcademicoResponseRest> obtenerNivelAcademici(){
        ResponseEntity<NivelAcademicoResponseRest> nivelAcademicoResponseRest = iNivelAcademicoService.obtenerNivelAcademico();
        return nivelAcademicoResponseRest;

    }
}
