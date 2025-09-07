package control.procesos.controlProcesos.controller;

import control.procesos.controlProcesos.response.TipoFamiliarResponseRest;
import control.procesos.controlProcesos.service.IEmpleadoDocumentoService;
import control.procesos.controlProcesos.service.ITipoFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controlProcesos")
public class TipoFamiliarController {

    @Autowired
    private ITipoFamiliarService iTipoFamiliarService;

    @GetMapping("/tipoFamiliar")
    public ResponseEntity<TipoFamiliarResponseRest> obtenerTipoFamiliar(){
        ResponseEntity<TipoFamiliarResponseRest> tipoFamiliarResponseRest = iTipoFamiliarService.obtenetTipoFaimilar();
        return tipoFamiliarResponseRest;
    }

}
