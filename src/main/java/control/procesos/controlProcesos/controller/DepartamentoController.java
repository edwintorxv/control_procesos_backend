package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.DepartamentoResponseRest;
import control.procesos.controlProcesos.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/controlProcesos")
public class DepartamentoController {

    @Autowired
    private IDepartamentoService iDepartamentoService;

    @GetMapping("/departamentos")
    public ResponseEntity<DepartamentoResponseRest> obtenerDepartamentos(){
        ResponseEntity<DepartamentoResponseRest> departamentoResponseRestResponse = iDepartamentoService.obtenerDepartamentos();
        return departamentoResponseRestResponse;
    }

}
